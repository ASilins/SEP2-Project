package com.uno.shared.networking;

import com.uno.shared.transferobjects.Order;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * An interface that creates order object in database.
 * @author Arturs Silins
 * @version 0.1.0
 */
public interface OrderServer extends Remote {

  /**
   * Method that creates an Order object in database.
   * @param order The order that will be created in the database.
   * @throws RemoteException If it is not possible to receive the object.
   */
  void createOrder(Order order) throws RemoteException;

  /**
   * Method that gets all orders from the database.
   * @return a list of Order Objects
   * @throws RemoteException If it's not possible to call the method
   */
  ArrayList<Order> getOrders() throws RemoteException;

   void editOrder(Order oldOrder, Order newOrder);
}
