package com.uno.database;

import com.uno.shared.transferobjects.Account;
import com.uno.shared.transferobjects.MenuItem;
import com.uno.shared.transferobjects.Order;

import java.util.ArrayList;

/**
 * An interface that has all methods for getting items from and to the database.
 * @author Arturs Silins
 * @version 0.2.0
 */
public interface Database {

  /**
   * Method that returns a list of menu item object from the database.
   * @return A list of menuItem objects.
   */
  ArrayList<MenuItem> getMenuItems();

  /**
   * Method that creates a new Order entry in the database.
   * @param order The entry that will be inserted in the database.
   */
  void createOrder(Order order);

  /**
   * A method that takes account object and send it to the database.
   * @param account An account object that will be sent.
   */
  void createAccount(Account account);
}
