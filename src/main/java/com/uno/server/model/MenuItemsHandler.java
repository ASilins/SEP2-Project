package com.uno.server.model;

import com.uno.shared.transferobjects.MenuItem;

import java.util.ArrayList;

/**
 * An interface that controls MenuItem object sending and receiving.
 * @author Arturs Silins
 * @version 0.1.0
 */
public interface MenuItemsHandler {

  /**
   * A method that returns list of menu items from a database
   * @return A list of MenuItem objects
   */
  ArrayList<MenuItem> getMenuItems();
}
