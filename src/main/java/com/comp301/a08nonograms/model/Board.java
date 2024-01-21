package com.comp301.a08nonograms.model;

public interface Board {

  boolean isShaded(int row, int col);

  boolean isEliminated(int row, int col);

  boolean isSpace(int row, int col);

  void toggleCellShaded(int row, int col);

  void toggleCellEliminated(int row, int col);

  void clear();
}
