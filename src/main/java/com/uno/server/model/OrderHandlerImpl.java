package com.uno.server.model;

import com.uno.database.Database;
import com.uno.shared.transferobjects.Order;

import java.util.ArrayList;

/**
 * A class that handles Order objects from the database to the client.
 * @author Arturs Silins
 * @version 0.1.0
 */
public class OrderHandlerImpl implements OrderHandler{

  private Database database;
  private Order oldOrder;


  /**
   * A constructor that takes database object and sets it to the instance.
   * @param database The object that will be in the object instance.
   */
  public OrderHandlerImpl(Database database) {
    this.database = database;
  }

  /**
   * A method that sends Order object to the database.
   * @param order The object that will be sent
   */
  @Override
  public void createOrder(Order order) {
    database.createOrder(order);
  }

  /**
   * Method that gets all orders from the database
   * @return A list of order objects
   */
  @Override
  public ArrayList<Order> getOrders() {
    return null;
  }

  @Override
  public void editOrder(Order oldOrder, Order newOrder)
  {
    this.oldOrder = oldOrder;
    oldOrder = newOrder;
  }


}
