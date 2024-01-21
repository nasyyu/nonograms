package com.comp301.a08nonograms.model;

public class Puzzle implements Clues, Board {

  private final Clues clue;
  private final Board puzzleBoard;

  public Puzzle(Clues libClue) {
    if (libClue == null) {
      throw new NullPointerException("clues cannot be null!");
    }
    this.clue = libClue;
    puzzleBoard = new BoardImpl(clue);
  }

  @Override
  public int getWidth() {
    return clue.getWidth();
  }

  @Override
  public int getHeight() {
    return clue.getHeight();
  }

  @Override
  public int[] getRowClues(int index) {
    return clue.getRowClues(index);
  }

  @Override
  public int[] getColClues(int index) {
    return clue.getColClues(index);
  }

  @Override
  public int getRowCluesLength() {
    return clue.getRowCluesLength();
  }

  @Override
  public int getColCluesLength() {
    return clue.getColCluesLength();
  }

  @Override
  public boolean isShaded(int row, int col) {
    return puzzleBoard.isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return puzzleBoard.isEliminated(row, col);
  }

  @Override
  public boolean isSpace(int row, int col) {
    return puzzleBoard.isSpace(row, col);
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    puzzleBoard.toggleCellShaded(row, col);
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    puzzleBoard.toggleCellEliminated(row, col);
  }

  @Override
  public void clear() {
    puzzleBoard.clear();
  }
}
