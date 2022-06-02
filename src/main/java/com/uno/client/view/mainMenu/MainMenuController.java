package com.uno.client.view.mainMenu;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.view.ViewController;

/**
 * A controller that changes the scenes
 * @author Arturs Silins
 * @version 1.0.0
 */

public class MainMenuController implements ViewController {

  private ViewHandler viewHandler;

  /**
   * Sets the instance for the vievhandler
   * @param viewHandler the instance of viewhandler
   */
  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
    this.viewHandler = viewHandler;
  }


  public void bookTable() {

  }

  public void takeAway() {

  }

  public void openMenu() {

  }

  public void dineIn() {

  }

  /**
   * Changes the scene to view orders
   */
  public void viewOrders() {
    viewHandler.openManagerViewOrders();
  }

  /**
   * Changes the scene to view bookings
   */
  public void viewBookings() {
    viewHandler.openViewBooking();
  }

  /**
   * Changes the scene to manager bookings
   */
  public void viewManagerBookings() {
    viewHandler.openManagerViewBooking();
  }

  /**
   * Changes to view tables
   */
  public void viewTables() {
    viewHandler.openViewTables();
  }

  /**
   * Changes the scene to manager table scene
   */
  public void viewManagerTables() {
    viewHandler.openManagerViewTables();
  }

  /**
   * Changes the scene to view users
   */
  public void viewUsers() {
    viewHandler.openViewUsers();
  }
}
