package com.uno.server.networking;

import com.uno.server.model.MenuItemsHandler;
import com.uno.shared.networking.MenuItemsServer;
import com.uno.shared.transferobjects.MenuItem;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * This class is a server class that handles menu item objects in the server
 * @author Arturs Silins
 * @version 0.1.0
 */
public class MenuItemsServerImpl implements MenuItemsServer {

  private MenuItemsHandler handler;

  /**
   * Constructor that takes as a parameter an MenuItemsHandler object
   * @param handler An object that handles menu items
   */
  public MenuItemsServerImpl(MenuItemsHandler handler) {
    try {
      UnicastRemoteObject.exportObject(this, 0);
    } catch (RemoteException e) {
      e.printStackTrace();
    }

    this.handler = handler;
  }

  /**
   * A method that returns a list of menu items
   * @return A list of menuItem objects
   * @throws RemoteException If it is not possible to return the object
   */
  @Override
  public ArrayList<MenuItem> getMenuItems() throws RemoteException {
    return handler.getMenuItems();
  }
}
