package com.uno.client.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.uno.client.view.ViewController;

import java.io.IOException;

/**
 * A model factory class
 * @author Maximillian Wallin, Arturs Silins
 * @version 1.0.0
 */

public class ViewHandler {

  private Scene menuScene;
  private Scene orderScene;
  private Scene createAccountScene;
  private Scene loginScene;
  private Scene mainMenuScene;
  private Scene staffMainMenuScene;
  private Scene managerMainMenuScene;
  private Scene managerViewOrdersScene;
  private Scene editOrderScene;

  private Stage stage;
  private ViewModelFactory vmf;

  /**
   * constructor for ViewHandler
   * @param vmf takes ViewModelFactory as a parameter
   */

  public ViewHandler(ViewModelFactory vmf) {
    this.vmf = vmf;
  }

  /**
   * executes the method that will open the login scene
   */

  public void start() {
    stage = new Stage();
    openLoginScene();
  }
  /**
   * method to open the menu scene
   */

  public void openMenuScene() {
    if (menuScene == null) {
      try {
        Parent root = loadFXML("../view/menuItem/menu.fxml");

        menuScene = new Scene(root);
        stage.setTitle("Menu");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    stage.setScene(menuScene);
    stage.show();
  }

  /**
   * method to open the order scene
   */

  public void openOrderScene() {
    if (orderScene == null) {
      try {
        Parent root = loadFXML("../view/order/order.fxml");

        orderScene = new Scene(root);
        stage.setTitle("Order");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    stage.setScene(orderScene);
    stage.show();
  }

  /**
   * method to open the create account scene
   */

  public void openCreateAccountScene() {
    if (createAccountScene == null) {
      try {
        Parent root = loadFXML("../view/createaccount/CreateAccount.fxml");

        createAccountScene = new Scene(root);
        stage.setTitle("Create Account");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    stage.setScene(createAccountScene);
    stage.show();
  }

  /**
   * method to open the login scene if the login scene is not created
   */

  public void openLoginScene() {
    if (loginScene == null) {
      try {
        Parent root = loadFXML("../view/login/Login.fxml");

        loginScene = new Scene(root);
        stage.setTitle("Login");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    stage.setScene(loginScene);
    stage.show();
  }

  /**
   * method to open the main menu scene
   */

  public void openMainMenu() {
    if (mainMenuScene == null) {
      try {
        Parent root = loadFXML("../view/mainMenu/guestview.fxml");

        mainMenuScene = new Scene(root);
        stage.setTitle("Main Menu");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    stage.setScene(mainMenuScene);
    stage.show();
  }

  /**
   * method to open the staff main menu scene
   */

  public void openStaffMainMenu() {
    if (staffMainMenuScene == null) {
      try {
        Parent root = loadFXML("../view/mainMenu/staffView.fxml");

        staffMainMenuScene = new Scene(root);
        stage.setTitle("Main Menu");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    stage.setScene(staffMainMenuScene);
    stage.show();
  }

  /**
   * method to open the manager main menu scene
   */

  public void openManagerMainMenu() {
    if (managerMainMenuScene == null) {
      try {
        Parent root = loadFXML("../view/mainMenu/managerView.fxml");

        managerMainMenuScene = new Scene(root);
        stage.setTitle("Main Menu");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    stage.setScene(managerMainMenuScene);
    stage.show();
  }

  /**
   * method to open the manager view order scene
   */

  public void openManagerViewOrders() {
    if (managerViewOrdersScene == null) {
      try {
        Parent root = loadFXML("../view/viewOrders/viewOrders.fxml");

        managerViewOrdersScene = new Scene(root);
        stage.setTitle("Orders");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    stage.setScene(managerViewOrdersScene);
    stage.show();
  }

  /**
   * method to open the edit order scene
   */

  public void openEditOrder() {
    if (editOrderScene == null) {
      try {
        Parent root = loadFXML("../view/editOrder/editOrder.fxml");

        editOrderScene = new Scene(root);
        stage.setTitle("Edit Order");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    stage.setScene(editOrderScene);
    stage.show();
  }

  private Parent loadFXML(String path) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(path));
    Parent root = loader.load();

    ViewController ctrl = loader.getController();
    ctrl.init(this, vmf);
    return root;
  }
}
