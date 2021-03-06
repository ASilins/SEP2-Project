package com.uno.shared.networking;

import com.uno.shared.transferobjects.Order;
import com.uno.shared.transferobjects.PreOrder;
import com.uno.shared.transferobjects.Reservation;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * An interface that creates order object in database.
 * @author Arturs Silins
 * @version 1.0.0
 */
public interface OrderServer extends Remote {

  /**
   * A method that registers the client in the server
   * @param client The object that is registered
   * @throws RemoteException If connection failed
   */
  void registerClient(OrderClientCallBack client) throws RemoteException;

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

  /**
   * Method that creates a PreOrder object in database.
   * @param order takes order as the first of the two parameters
   * @param reservation takes reservation as the second of the two parameters
   * @throws RemoteException If it's not possible to receive the object
   */
  void createPreOrder(Order order, Reservation reservation) throws RemoteException;

  /**
  * A method that send order that has to be eddited and the new information.
  * @param newOrder The information that will be set in the old object.
  */
  void editOrder(Order newOrder) throws RemoteException;
}
