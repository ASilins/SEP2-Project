package com.uno.shared.networking;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface contains methods that is needed for the server.
 * @author Arturs Silins
 * @version 1.0.0
 */
public interface Server extends Remote {

  /**
   * Method that returns MenuItemsServer object.
   * @return The server object.
   * @throws RemoteException If connection failed
   */
  MenuItemsServer getMenuItemsServer() throws RemoteException;

  /**
   * Method that return OrderServer object.
   * @return The server object.
   * @throws RemoteException If connection failed
   */
  OrderServer getOrderServer() throws RemoteException;

  /**
   * A method that return account server.
   * @return An account server object.
   * @throws RemoteException If connection failed
   */
  AccountServer getAccountServer() throws RemoteException;

  /**
   * A method that returns table server
   * @return A table server object
   * @throws RemoteException If connection failed
   */
  TableServer getTableServer() throws RemoteException;

  /**
   * A method that returns reservation server
   * @return A reservation server object
   * @throws RemoteException If connection failed
   */
  ReservationServer getReservationServer() throws RemoteException;
}
