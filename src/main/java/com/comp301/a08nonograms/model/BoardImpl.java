package com.comp301.a08nonograms.model;

public class BoardImpl implements Board {

  private final int boardHeight;
  private final int boardWidth;
  private final int[][] boardToggles;

  public BoardImpl(Clues clueInstance) {
    if (clueInstance == null) {
      throw new NullPointerException("clues cannot be null!");
    }
    this.boardHeight = clueInstance.getHeight();
    this.boardWidth = clueInstance.getWidth();
    this.boardToggles = new int[boardHeight][boardWidth];

    for (int i = 0; i < this.boardHeight; i++) {
      for (int j = 0; j < this.boardWidth; j++) {
        this.boardToggles[i][j] = 0;
      }
    }
  }

  @Override
  public boolean isShaded(int row, int col) {
    if ((row < 0) || (row >= boardHeight)) {
      throw new IllegalArgumentException("row is out of bounds!");
    }
    if ((col < 0) || (col >= boardWidth)) {
      throw new IllegalArgumentException("col is out of bounds!");
    }
    return boardToggles[row][col] == 1;
  }

  @Override
  public boolean isEliminated(int row, int col) {
    if ((row < 0) || (row >= boardHeight)) {
      throw new IllegalArgumentException("row is out of bounds!");
    }
    if ((col < 0) || (col >= boardWidth)) {
      throw new IllegalArgumentException("col is out of bounds!");
    }
    return boardToggles[row][col] == -1;
  }

  @Override
  public boolean isSpace(int row, int col) {
    if ((row < 0) || (row >= boardHeight)) {
      throw new IllegalArgumentException("row is out of bounds!");
    }
    if ((col < 0) || (col >= boardWidth)) {
      throw new IllegalArgumentException("col is out of bounds!");
    }
    return boardToggles[row][col] == 0;
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    if (boardToggles[row][col] != 1) {
      boardToggles[row][col] = 1;
    } else {
      boardToggles[row][col] = 0;
    }
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    if (boardToggles[row][col] != -1) {
      boardToggles[row][col] = -1;
    } else {
      boardToggles[row][col] = 0;
    }
  }

  @Override
  public void clear() {
    for (int i = 0; i < boardHeight; i++) {
      for (int j = 0; j < boardWidth; j++) {
        boardToggles[i][j] = 0;
      }
    }
  }
}
