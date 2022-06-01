package com.uno.client.view.mainMenu;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.view.ViewController;

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

  }

  public void viewManagerBookings() {

  }

  public void viewTables() {

  }

  public void viewManagerTables() {

  }

  public void viewUsers() {

  }
}
