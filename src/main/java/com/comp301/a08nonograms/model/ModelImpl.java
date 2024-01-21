package com.comp301.a08nonograms.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {

  private final List<Clues> cluesLibrary;
  private final List<ModelObserver> observers = new ArrayList<>();
  private final List<Puzzle> puzzles = new ArrayList<>();
  private int libraryIndex;

  public ModelImpl(List<Clues> clues) {
    this.cluesLibrary = clues;

    for (Clues clue : cluesLibrary) {
      Puzzle puzzle = new Puzzle(clue);
      puzzles.add(puzzle);
    }
  }

  @Override
  public int getPuzzleCount() {
    return puzzles.size();
  }

  @Override
  public int getPuzzleIndex() {
    return libraryIndex;
  }

  @Override
  public void setPuzzleIndex(int index) {
    this.libraryIndex = index;
    for (ModelObserver m : observers) {
      m.update(this);
    }
  }

  @Override
  public void addObserver(ModelObserver observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(ModelObserver observer) {
    observers.remove(observer);
  }

  @Override
  public boolean isSolved() {

    // count and store in array the count of hints in col and row. check count
    int[] rowCount = new int[puzzles.get(libraryIndex).getHeight()];
    int[] colCount = new int[puzzles.get(libraryIndex).getWidth()];

    // stores the count of the sum of each row of clues
    int clueRowCounter;
    for (int i = 0; i < puzzles.get(libraryIndex).getHeight(); i++) {
      clueRowCounter = 0;
      for (int j = 0; j < puzzles.get(libraryIndex).getRowCluesLength(); j++) {
        clueRowCounter += puzzles.get(libraryIndex).getRowClues(i)[j];
      }
      rowCount[i] = clueRowCounter;
    }

    // stores array of the input row 'clue' count
    int[] inputRowCount = new int[puzzles.get(libraryIndex).getHeight()];
    int[] inputColCount = new int[puzzles.get(libraryIndex).getWidth()];

    int trueRowCount;
    for (int i = 0; i < puzzles.get(libraryIndex).getHeight(); i++) {
      trueRowCount = 0;
      for (int j = 0; j < puzzles.get(libraryIndex).getWidth(); j++) {
        if (puzzles.get(libraryIndex).isShaded(i, j)) {
          trueRowCount += 1;
        }
      }
      inputRowCount[i] = trueRowCount;
    }

    // compare row clues
    for (int i = 0; i < rowCount.length; i++) {
      if (rowCount[i] != inputRowCount[i]) {
        return false;
      }
    }

    // stores the count of the sum of each column of clues
    int clueColCounter;
    for (int i = 0; i < puzzles.get(libraryIndex).getWidth(); i++) {
      clueColCounter = 0;
      for (int j = 0; j < puzzles.get(libraryIndex).getColCluesLength(); j++) {
        clueColCounter += puzzles.get(libraryIndex).getColClues(i)[j];
      }
      colCount[i] = clueColCounter;
    }

    int trueColCount;
    for (int i = 0; i < puzzles.get(libraryIndex).getWidth(); i++) {
      trueColCount = 0;
      for (int j = 0; j < puzzles.get(libraryIndex).getHeight(); j++) {
        if (puzzles.get(libraryIndex).isShaded(j, i)) {
          trueColCount += 1;
        }
      }
      inputColCount[i] = trueColCount;
    }

    // compare col clues
    for (int i = 0; i < colCount.length; i++) {
      if (colCount[i] != inputColCount[i]) {
        return false;
      }
    }

    return true;
  }

  @Override
  public boolean isShaded(int row, int col) {
    return puzzles.get(libraryIndex).isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return puzzles.get(libraryIndex).isEliminated(row, col);
  }

  @Override
  public boolean isSpace(int row, int col) {
    return puzzles.get(libraryIndex).isSpace(row, col);
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    puzzles.get(libraryIndex).toggleCellShaded(row, col);
    for (ModelObserver m : observers) {
      m.update(this);
    }
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    puzzles.get(libraryIndex).toggleCellEliminated(row, col);
    for (ModelObserver m : observers) {
      m.update(this);
    }
  }

  @Override
  public void clear() {
    puzzles.get(libraryIndex).clear();
    for (ModelObserver m : observers) {
      m.update(this);
    }
  }

  @Override
  public int getWidth() {
    return puzzles.get(libraryIndex).getWidth();
  }

  @Override
  public int getHeight() {
    return puzzles.get(libraryIndex).getHeight();
  }

  @Override
  public int[] getRowClues(int index) {
    return puzzles.get(libraryIndex).getRowClues(index);
  }

  @Override
  public int[] getColClues(int index) {
    return puzzles.get(libraryIndex).getColClues(index);
  }

  @Override
  public int getRowCluesLength() {
    return puzzles.get(libraryIndex).getRowCluesLength();
  }

  @Override
  public int getColCluesLength() {
    return puzzles.get(libraryIndex).getColCluesLength();
  }

  public Clues getClues() {
    return cluesLibrary.get(libraryIndex);
  }
}
