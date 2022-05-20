package com.uno.shared.networking;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface contains methods that is needed for the server
 * @author Arturs Silins
 * @version 0.1.0
 */
public interface Server extends Remote {

  /**
   * Method that returns MenuItemsServer object
   * @return The server object
   */
  MenuItemsServer getMenuItemsServer();
}
