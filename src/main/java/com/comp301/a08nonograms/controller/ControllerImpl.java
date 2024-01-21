package com.comp301.a08nonograms.controller;

import com.comp301.a08nonograms.model.Clues;
import com.comp301.a08nonograms.model.Model;
import java.util.Random;

public class ControllerImpl implements Controller {

  private final Model model;

  public ControllerImpl(Model model) {
    this.model = model;
  }

  @Override
  public Clues getClues() {
    return model.getClues();
  }

  @Override
  public boolean isSolved() {
    return model.isSolved();
  }

  @Override
  public boolean isShaded(int row, int col) {
    return model.isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return model.isEliminated(row, col);
  }

  @Override
  public void toggleShaded(int row, int col) {
    model.toggleCellShaded(row, col);
  }

  @Override
  public void toggleEliminated(int row, int col) {
    model.toggleCellEliminated(row, col);
  }

  @Override
  public void nextPuzzle() {
    model.setPuzzleIndex(model.getPuzzleIndex() + 1);
  }

  @Override
  public void prevPuzzle() {
    model.setPuzzleIndex(model.getPuzzleIndex() - 1);
  }

  @Override
  public void randPuzzle() {
    model.setPuzzleIndex(new Random().nextInt(model.getPuzzleCount()));
  }

  @Override
  public void clearBoard() {
    model.clear();
  }

  @Override
  public int getPuzzleIndex() {
    return model.getPuzzleIndex();
  }

  @Override
  public int getPuzzleCount() {
    return model.getPuzzleCount();
  }
}
