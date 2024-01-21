package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.PuzzleLibrary;
import com.comp301.a08nonograms.controller.Controller;
import com.comp301.a08nonograms.controller.ControllerImpl;
import com.comp301.a08nonograms.model.Model;
import com.comp301.a08nonograms.model.ModelImpl;
import com.comp301.a08nonograms.model.ModelObserver;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AppLauncher extends Application {

  @Override
  public void start(Stage stage) {
    stage.setTitle("Welcome to Nonogram Jam!");

    Model model = new ModelImpl(new PuzzleLibrary().create());
    Controller controller = new ControllerImpl(model);

    PuzzleView puzzleView = new PuzzleView(model);
    ControlView controlView = new ControlView(controller, model);
    MessageView messageView = new MessageView(model);

    StackPane root = new StackPane();
    BorderPane align = new BorderPane();
    align.setCenter(puzzleView.render());
    align.setTop(controlView.render());

    root.getChildren().add(align);
    Scene sceneOne = new Scene(root, 600, 600);
    stage.setScene(sceneOne);

    ModelObserver observer =
        model1 -> {
          StackPane change = new StackPane();
          BorderPane alignChange = new BorderPane();
          alignChange.setCenter(puzzleView.render());
          alignChange.setTop(controlView.render());
          alignChange.setBottom(messageView.render());
          change.getChildren().add(alignChange);
          Scene scene = new Scene(change, 600, 600);
          stage.setScene(scene);
        };
    model.addObserver(observer);

    stage.show();
  }
}
