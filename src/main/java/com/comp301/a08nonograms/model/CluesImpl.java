package com.comp301.a08nonograms.model;

public class CluesImpl implements Clues {

  private final int puzzleHeight;
  private final int puzzleWidth;
  private final int[][] rowClues;
  private final int[][] colClues;

  public CluesImpl(int[][] rowClues, int[][] colClues) {
    this.rowClues = rowClues;
    this.colClues = colClues;
    this.puzzleHeight = rowClues.length;
    this.puzzleWidth = colClues.length;
  }

  @Override
  public int getWidth() {
    return puzzleWidth;
  }

  @Override
  public int getHeight() {
    return puzzleHeight;
  }

  @Override
  public int[] getRowClues(int index) {
    return rowClues[index];
  }

  @Override
  public int[] getColClues(int index) {
    int[] column = new int[colClues[index].length];
    for (int i = 0; i < column.length; i++) {
      column[i] = colClues[index][i];
    }
    return column;
  }

  @Override
  public int getRowCluesLength() {
    return rowClues[0].length;
  }

  @Override
  public int getColCluesLength() {
    return colClues[0].length;
  }
}
