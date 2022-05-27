package com.uno.database;

import com.uno.shared.transferobjects.MenuItem;
import com.uno.shared.transferobjects.Order;
import com.uno.shared.transferobjects.PreOrder;

import java.util.ArrayList;

/**
 * A class that implements Database interface. The class handles sending the
 * objects from database to the server or back.
 * @author Arturs Silins
 * @version 0.1.0
 */
public class DatabaseImpl implements Database {

  private DatabaseHandler currentState;
  private DatabaseHandler handler;

  /**
   * No-Argument constructor that initializes the handler
   */
  public DatabaseImpl() {
    handler = new OrderState();
  }

  /**
   * Method that returns a list of menu item object from the database.
   * @return A list of menuItem objects.
   */
  @Override
  public ArrayList<MenuItem> getMenuItems() {
    setState(new MenuItemsState());
    return (ArrayList<MenuItem>) currentState.getListFromDatabase();
  }

  /**
   * Method that creates a new Order entry in the database.
   * @param order The entry that will be inserted in the database.
   */
  @Override
  public void createOrder(Order order) {
    setState(new OrderState());
    currentState.sendToDatabase(order);
  }

  /**
   *a method for creating a pre-order
   * @param orderNumber number of the corresponding order
   * @param reservationNumber number of the corresponding reservation
   */

  @Override
  public void createPreOrder(int orderNumber, int reservationNumber) {

    PreOrder preOrder = new PreOrder(orderNumber, reservationNumber);

    setState(new PreOrderState());
    currentState.sendToDatabase(preOrder);
  }


  /**
   * Changes state of the handler so that the correct methods are used
   * @param state The handler that will be used
   */
  private void setState(DatabaseHandler state) {
    this.currentState = state;
  }
}
