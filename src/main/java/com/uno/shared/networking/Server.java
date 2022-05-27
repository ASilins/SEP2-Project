package com.uno.shared.networking;

import java.rmi.Remote;

/**
 * Interface contains methods that is needed for the server.
 * @author Arturs Silins
 * @version 0.2.0
 */
public interface Server extends Remote {

  /**
   * Method that returns MenuItemsServer object.
   * @return The server object.
   */
  MenuItemsServer getMenuItemsServer();

  /**
   * Method that return OrderServer object.
   * @return The server object.
   */
  OrderServer getOrderServer();

  /**
   * A method that return account server.
   * @return An account server object.
   */
  AccountServer getAccountServer();

  /**
   * A method that returns table server
   * @return A table server object
   */
  TableServer getTableServer();
}
