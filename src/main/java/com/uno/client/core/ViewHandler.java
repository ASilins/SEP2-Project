package com.uno.client.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.uno.client.view.ViewController;

import java.io.IOException;

public class ViewHandler {

  private Scene menuScene;
  private Scene orderScene;
  private Stage stage;
  private ViewModelFactory vmf;

  public ViewHandler(ViewModelFactory vmf) {this.vmf = vmf;}

  public void start() {
    stage = new Stage();
    openMenuScene();
  }



}
