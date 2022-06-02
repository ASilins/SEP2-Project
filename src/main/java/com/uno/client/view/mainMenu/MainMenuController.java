package com.uno.client.view.mainMenu;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.view.ViewController;

/**
 *
 * @author Arturs Silins
 * @version 1.0.0
 */

public class MainMenuController implements ViewController {

  private ViewHandler viewHandler;

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

  public void viewOrders() {
    viewHandler.openManagerViewOrders();
  }

  public void viewBookings() {
    viewHandler.openViewBooking();
  }

  public void viewManagerBookings() {
    viewHandler.openManagerViewBooking();
  }

  public void viewTables() {
    viewHandler.openViewTables();
  }

  public void viewManagerTables() {
    viewHandler.openManagerViewTables();
  }

  public void viewUsers() {
    viewHandler.openViewUsers();
  }
}
