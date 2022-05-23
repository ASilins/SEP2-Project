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

public void openMenuScene(){
    if(menuScene == null){
      try{
        Parent root = loadFXML("src/main/java/com/uno/client/view/menuItem/menu.fxml");

        menuScene = new Scene(root);
        stage.setTitle("Menu");
      } catch(Exception e){
        e.printStackTrace();
      }
    }
  stage.setScene(menuScene);
  stage.show();
}

  public void openOrderScene(){
    if(orderScene == null){
      try{
        Parent root = loadFXML("src/main/java/com/uno/client/view/order/order.fxml");

        orderScene = new Scene(root);
        stage.setTitle("Order");
      } catch(Exception e){
        e.printStackTrace();
      }
    }
    stage.setScene(orderScene);
    stage.show();
    }
private Parent loadFXML (String path) throws IOException{
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(path));
    Parent root = loader.load();

    ViewController ctrl =loader.getController();
    ctrl.init(this, vmf);
    return root;
  }
}
