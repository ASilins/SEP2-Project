package com.uno.server.model;

import com.uno.shared.transferobjects.Order;

import java.util.ArrayList;

/**
 * An interface that is used to send and receive Order objects
 * using these methods.
 * @author Arturs Silins,Bhupas
 * @version 0.1.0
 */
public interface OrderHandler {

  /**
   * Send order object to the database.
   * @param order The object that will be sent to the database.
   */
  void createOrder(Order order);

  /**
   * Returns a list of order objects from the database
   * @return A list of Order Objects
   */
  ArrayList<Order> getOrders();
}
