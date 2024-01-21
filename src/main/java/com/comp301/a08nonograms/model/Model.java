package com.comp301.a08nonograms.model;

public interface Model extends Board, Clues {

  int getPuzzleCount();

  int getPuzzleIndex();

  void setPuzzleIndex(int index);

  void addObserver(ModelObserver observer);

  void removeObserver(ModelObserver observer);

  boolean isSolved();

  Clues getClues();
}
