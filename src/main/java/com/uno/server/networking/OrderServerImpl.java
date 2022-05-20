package com.uno.server.networking;

import com.uno.server.model.OrderHandler;
import com.uno.shared.networking.OrderServer;
import com.uno.shared.transferobjects.Order;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * This class implements OrderServer Interface. This server object handles
 * sending and receiving Order objects from client and server.
 * @author Arturs Silins
 * @version 0.1.0
 */
public class OrderServerImpl implements OrderServer {

  private OrderHandler handler;

  /**
   * Constructor that export instance and sets the instance for a class
   * that handles Order Objects in the server.
   * @param handler
   */
  public OrderServerImpl(OrderHandler handler) {
    try {
      UnicastRemoteObject.exportObject(this, 0);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
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
}
