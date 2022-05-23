package com.uno.server.model;

import com.uno.database.Database;
import com.uno.shared.transferobjects.MenuItem;

import java.util.ArrayList;

/**
 * A class that handles sending and receiving MenuItem objects
 * @author Arturs Silins
 * @version 0.1.0
 */
public class MenuItemsHandlerImpl implements MenuItemsHandler {

  private Database database;

  /**
   * A constructor that takes a Database object
   * @param database The object that will be used in the class instance
   */
  public MenuItemsHandlerImpl(Database database) {
    this.database = database;
  }

  /**
   * Method that takes from the database MenuItem objects
   * @return A list of MenuItem objects
   */
  @Override
  public ArrayList<MenuItem> getMenuItems() {
    return database.getMenuItems();
  }
}
