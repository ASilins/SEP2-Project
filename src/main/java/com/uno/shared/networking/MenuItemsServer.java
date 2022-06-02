package com.uno.shared.networking;

import com.uno.shared.transferobjects.MenuItem;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * This interface is for MenuItemsServer that handles only things associated with menu items
 * @author Arturs Silins, Maximillian Wallin
 * @version 1.0.0
 */
public interface MenuItemsServer extends Remote {

  /**
   * Method that returns list of menu items
   * @return List of menu items
   * @throws RemoteException If it is not possible to do
   */
  ArrayList<MenuItem> getMenuItems() throws RemoteException;
}
