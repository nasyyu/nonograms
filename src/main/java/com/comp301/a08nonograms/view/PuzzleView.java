package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.model.Model;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PuzzleView implements FXComponent {

  private final Model model;

  public PuzzleView(Model model) {
    this.model = model;
  }

  @Override
  public Parent render() {
    GridPane gridPane = new GridPane();
    gridPane.setStyle("-fx-background-color: #C4CEBC;");
    GridPane grid = new GridPane();

    // create grid
    grid.setPadding(new Insets(25, 25, 25, 25));
    grid.setVgap(5);
    grid.setHgap(5);
    grid.setStyle("-fx-background-color: #C4CEBC;");

    for (int i = 0; i < model.getWidth(); i++) {
      for (int j = 0; j < model.getHeight(); j++) {
        if (model.isShaded(j, i)) {
          Button shaded = new Button();
          shaded.setMinSize(25, 25);
          shaded.setMaxSize(25, 25);
          shaded.setStyle("-fx-background-color: #3A190E;");
          int finalJ = j;
          int finalI = i;
          shaded.setOnMouseClicked(
              event -> {
                if (event.getButton() == MouseButton.PRIMARY) {
                  model.toggleCellShaded(finalJ, finalI);
                }
                if (event.getButton() == MouseButton.SECONDARY) {
                  model.toggleCellEliminated(finalJ, finalI);
                }
              });
          grid.add(shaded, i, j);
        } else if (model.isSpace(j, i)) {
          Button space = new Button();
          space.setMinSize(25, 25);
          space.setMaxSize(25, 25);
          space.setStyle("-fx-background-color: #BA9696;");
          int finalI1 = i;
          int finalJ1 = j;
          space.setOnMouseClicked(
              event -> {
                if (event.getButton() == MouseButton.PRIMARY) {
                  model.toggleCellShaded(finalJ1, finalI1);
                }
                if (event.getButton() == MouseButton.SECONDARY) {
                  model.toggleCellEliminated(finalJ1, finalI1);
                }
              });
          grid.add(space, i, j);
        } else if (model.isEliminated(j, i)) {
          Button eliminated = new Button();
          eliminated.setMinSize(25, 25);
          eliminated.setMaxSize(25, 25);
          eliminated.setStyle("-fx-background-color: #E6D0FF;");
          eliminated.setText("X");
          eliminated.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
          int finalI2 = i;
          int finalJ2 = j;
          eliminated.setOnMouseClicked(
              event -> {
                if (event.getButton() == MouseButton.PRIMARY) {
                  model.toggleCellShaded(finalJ2, finalI2);
                }
                if (event.getButton() == MouseButton.SECONDARY) {
                  model.toggleCellEliminated(finalJ2, finalI2);
                }
              });
          grid.add(eliminated, i, j);
        }
      }
    }

    GridPane colGrid = new GridPane();
    colGrid.setAlignment(Pos.CENTER);
    colGrid.setPadding(new Insets(5, 5, 5, 5));
    colGrid.setVgap(5);
    colGrid.setHgap(17);
    for (int i = 0; i < model.getWidth(); i++) {
      for (int j = 0; j < model.getColCluesLength(); j++) {
        Text colT = new Text();
        String num;
        if ((model.getColClues(i)[j]) != 0) {
          num = String.valueOf(model.getColClues(i)[j]);
        } else {
          num = "-";
        }
        colT.setText(num);
        colT.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        colT.setFill(Color.web("#3A190E"));
        colGrid.add(colT, i, j);
      }
    }
    GridPane rowGrid = new GridPane();
    rowGrid.setAlignment(Pos.CENTER_LEFT);
    rowGrid.setPadding(new Insets(5, 5, 5, 5));
    rowGrid.setVgap(6);
    rowGrid.setHgap(5);
    for (int i = 0; i < model.getHeight(); i++) {
      for (int j = 0; j < model.getRowCluesLength(); j++) {
        Text rowT = new Text();
        String num;
        if ((model.getRowClues(i)[j]) == 0) {
          num = "-";
        } else {
          num = String.valueOf(model.getRowClues(i)[j]);
        }
        rowT.setText(num);
        rowT.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        rowT.setFill(Color.web("#3A190E"));
        rowGrid.add(rowT, j, i);
      }
    }
    BorderPane bPane = new BorderPane();
    bPane.setStyle("-fx-background-color: #c5a7e7;");
    Text puzzleNum = new Text();
    int puzzleIndexOne = model.getPuzzleIndex() + 1;
    puzzleNum.setText(
        "    Puzzle Number: " + puzzleIndexOne + " of " + model.getPuzzleCount() + "     ");
    puzzleNum.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
    bPane.setCenter(puzzleNum);

    grid.setAlignment(Pos.CENTER);
    gridPane.setAlignment(Pos.CENTER);
    gridPane.add(rowGrid, 0, 1);
    gridPane.add(colGrid, 1, 0);
    gridPane.add(grid, 1, 1);
    gridPane.add(bPane, 1, 2);
    return gridPane;
  }
}
