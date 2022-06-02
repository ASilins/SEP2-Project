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
  private Scene editBookingScene;
  private Scene managerEditBookingScene;
  private Scene viewBookingScene;
  private Scene managerViewBookingScene;
  private Scene viewTablesScene;
  private Scene managerViewTablesScene;
  private Scene editTableScene;
  private Scene createTableScene;
  private Scene viewUsersScene;
  private Scene editUsersScene;

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
        Parent root = loadFXML("../view/account/createaccount/CreateAccount.fxml");

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
        Parent root = loadFXML("../view/account/login/Login.fxml");

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
        Parent root = loadFXML("../view/order/viewOrders/viewOrders.fxml");

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
        Parent root = loadFXML("../view/order/editOrder/editOrder.fxml");

        editOrderScene = new Scene(root);
        stage.setTitle("Edit Order");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    stage.setScene(editOrderScene);
    stage.show();
  }

  /**
   * A method that opens edit booking scene
   */
  public void openEditBooking() {
    if (editBookingScene == null) {
      try {
        Parent root = loadFXML("../view/bookings/editBookings/editBooking.fxml");

        editBookingScene = new Scene(root);
        stage.setTitle("Edit Booking");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    stage.setScene(editBookingScene);
    stage.show();
  }

  /**
   * A method that opens manager edit booking scene
   */
  public void openManagerEditBooking() {
    if (managerEditBookingScene == null) {
      try {
        Parent root = loadFXML("../view/bookings/editBookings/managerEditBooking.fxml");

        managerEditBookingScene = new Scene(root);
        stage.setTitle("Edit Booking");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    stage.setScene(managerEditBookingScene);
    stage.show();
  }

  /**
   * A method that opens view booking scene
   */
  public void openViewBooking() {
    if (viewBookingScene == null) {
      try {
        Parent root = loadFXML("../view/bookings/viewBookings.fxml");

        viewBookingScene = new Scene(root);
        stage.setTitle("Bookings");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    stage.setScene(viewBookingScene);
    stage.show();
  }

  /**
   * A method that opens manager view booking scene
   */
  public void openManagerViewBooking() {
    if (managerViewBookingScene == null) {
      try {
        Parent root = loadFXML("../view/bookings/managerViewBookings.fxml");

        managerViewBookingScene = new Scene(root);
        stage.setTitle("Bookings");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    stage.setScene(managerViewBookingScene);
    stage.show();
  }

  /**
   * A method that opens view tables scene
   */
  public void openViewTables() {
    if (viewTablesScene == null) {
      try {
        Parent root = loadFXML("../view/tables/viewTables/viewTables.fxml");

        viewTablesScene = new Scene(root);
        stage.setTitle("Tables");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    stage.setScene(viewTablesScene);
    stage.show();
  }

  /**
   * A method that opens manager view tables scene
   */
  public void openManagerViewTables() {
    if (managerViewTablesScene == null) {
      try {
        Parent root = loadFXML("../view/tables/viewTables/managerViewTables.fxml");

        managerViewTablesScene = new Scene(root);
        stage.setTitle("Tables");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    stage.setScene(managerViewTablesScene);
    stage.show();
  }

  /**
   * A method that opens edit table scene
   */
  public void openEditTable() {
    if (editTableScene == null) {
      try {
        Parent root = loadFXML("../view/tables/editTable/editTable.fxml");

        editTableScene = new Scene(root);
        stage.setTitle("Edit Table");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    stage.setScene(editTableScene);
    stage.show();
  }

  /**
   * A method that opens create table scene
   */
  public void openCreateTable() {
    if (createTableScene == null) {
      try {
        Parent root = loadFXML("../view/tables/createTable/createTable.fxml");

        createTableScene = new Scene(root);
        stage.setTitle("Create Table");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    stage.setScene(createTableScene);
    stage.show();
  }

  /**
   * A method that opens view users scene
   */
  public void openViewUsers() {
    if (viewUsersScene == null) {
      try {
        Parent root = loadFXML("../view/account/viewUsers/viewUsers.fxml");

        viewUsersScene = new Scene(root);
        stage.setTitle("Users");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    stage.setScene(viewUsersScene);
    stage.show();
  }

  /**
   * A method that opens edit users scene
   */
  public void openEditUser() {
    if (editUsersScene == null) {
      try {
        Parent root = loadFXML("../view/account/editUser/editUser.fxml");

        editUsersScene = new Scene(root);
        stage.setTitle("Users");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    stage.setScene(editUsersScene);
    stage.show();
  }

  /**
   * A method that creates Parent root for a fxml file
   * @param path The location of the fxml file
   * @return Parent object
   * @throws IOException If failed to find fxml file
   */
  private Parent loadFXML(String path) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(path));
    Parent root = loader.load();

    ViewController ctrl = loader.getController();
    ctrl.init(this, vmf);
    return root;
  }
}
