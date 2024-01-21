package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.model.Model;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MessageView implements FXComponent {

  private final Model model;

  public MessageView(Model model) {
    this.model = model;
  }

  @Override
  public Parent render() {
    HBox winner = new HBox();

    if (model.isSolved()) {
      winner.setStyle("-fx-background-color: #3A190E;");
      Text win = new Text("!!!Winner Winner Chicken Dinner!!!");
      win.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
      win.setFill(Color.web("#BA9696"));
      winner.getChildren().add(win);
      winner.setAlignment(Pos.CENTER);
    }
    return winner;
  }
}
