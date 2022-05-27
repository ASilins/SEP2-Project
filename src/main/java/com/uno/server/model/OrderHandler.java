package com.uno.server.model;

import com.uno.shared.transferobjects.Order;
import com.uno.shared.transferobjects.PreOrder;

import java.util.ArrayList;

/**
 * An interface that is used to send and receive Order objects
 * using these methods.
 * @author Arturs Silins
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

  /**
   * Send pre-order object to the database
   * @param order takes order as the first of the two parameters
   * @param reservation takes reservation as the second of the two parameters
   */

  void createPreOrder(Order order, Reservation reservation);
}
