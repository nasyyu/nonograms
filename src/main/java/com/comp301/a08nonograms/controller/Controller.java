package com.comp301.a08nonograms.controller;

import com.comp301.a08nonograms.model.Clues;

public interface Controller {

  Clues getClues();

  boolean isSolved();

  boolean isShaded(int row, int col);

  boolean isEliminated(int row, int col);

  void toggleShaded(int row, int col);

  void toggleEliminated(int row, int col);

  void nextPuzzle();

  void prevPuzzle();

  void randPuzzle();

  void clearBoard();

  int getPuzzleIndex();

  int getPuzzleCount();
}
