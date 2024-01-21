package com.comp301.a08nonograms.model;

public interface Clues {

  int getWidth();

  int getHeight();

  int[] getRowClues(int index);

  int[] getColClues(int index);

  int getRowCluesLength();

  int getColCluesLength();
}
