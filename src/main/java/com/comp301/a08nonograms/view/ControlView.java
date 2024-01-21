package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import com.comp301.a08nonograms.model.Model;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ControlView implements FXComponent {

  private final Controller controller;
  private final Model model;

  public ControlView(Controller controller, Model model) {
    this.controller = controller;
    this.model = model;
  }

  @Override
  public Parent render() {
    HBox layout = new HBox();
    layout.setSpacing(10);
    layout.setStyle("-fx-background-color: #3A190E;");

    Button prev = new Button("Previous Puzzle");
    prev.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
    prev.setStyle("-fx-background-color: #BA9696;");
    prev.setOnAction(
        event -> {
          if (controller.getPuzzleIndex() == 0) {
            model.setPuzzleIndex(model.getPuzzleCount() - 1);
          } else {
            controller.prevPuzzle();
          }
        });

    Button reset = new Button("RESET");
    reset.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
    reset.setStyle("-fx-background-color: #BA9696;");
    reset.setOnAction((ActionEvent event) -> controller.clearBoard());

    Button next = new Button("Next Puzzle");
    next.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
    next.setStyle("-fx-background-color: #BA9696;");
    next.setOnAction(
        event -> {
          if (controller.getPuzzleIndex() == (model.getPuzzleCount() - 1)) {
            model.setPuzzleIndex(0);
          } else {
            controller.nextPuzzle();
          }
        });

    Button random = new Button("RANDOM");
    random.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
    random.setStyle("-fx-background-color: #BA9696;");
    random.setOnAction((ActionEvent event) -> controller.randPuzzle());

    layout.getChildren().add(prev);
    layout.getChildren().add(reset);
    layout.getChildren().add(random);
    layout.getChildren().add(next);
    layout.setAlignment(Pos.TOP_CENTER);
    return layout;
  }
}
