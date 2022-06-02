package com.uno.server.networking;

import com.uno.server.model.OrderHandler;
import com.uno.shared.networking.OrderServer;
import com.uno.shared.transferobjects.Order;
import com.uno.shared.transferobjects.PreOrder;
import com.uno.shared.transferobjects.Reservation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * This class implements OrderServer Interface. This server object handles
 * sending and receiving Order objects from client and server.
 * @author Arturs Silins
 * @version 1.0.0
 */
public class OrderServerImpl implements OrderServer {

  private OrderHandler handler;

  /**
   * Constructor that export instance and sets the instance for a class
   * that handles Order Objects in the server.
   * @param handler
   */
  public OrderServerImpl(OrderHandler handler) throws RemoteException {
      UnicastRemoteObject.exportObject(this, 0);
    this.handler = handler;
  }

  /**
   * A method that creates and order in a database.
   * @param order The order that will be created in the database.
   * @throws RemoteException If it is not possible to receive from client.
   */
  @Override
  public void createOrder(Order order) throws RemoteException {
    handler.createOrder(order);
  }

  /**
   * Method that return a list of Orders from the database
   * @return A list of Order objects
   * @throws RemoteException If not possible to return
   */
  @Override
  public ArrayList<Order> getOrders() throws RemoteException {
    return handler.getOrders();
  }

  /**
   * A method that creates pre-order in a database
   * @param order takes order as the first of the two parameters
   * @param reservation takes reservation as the second of the two parameters
   * @throws RemoteException If it's not possible to receive from the client
   */
  @Override
  public void createPreOrder(Order order, Reservation reservation) throws RemoteException {
    handler.createPreOrder(order, reservation);
  }

  @Override
  public void editOrder(Order newOrder) throws RemoteException{
    handler.editOrder(newOrder);
  }
}
