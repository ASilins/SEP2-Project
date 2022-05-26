package com.uno.server.networking;

import com.uno.database.Database;
import com.uno.database.DatabaseHandler;
import com.uno.database.DatabaseImpl;
import com.uno.server.model.AccountHandlerImpl;
import com.uno.server.model.MenuItemsHandlerImpl;
import com.uno.server.model.OrderHandlerImpl;
import com.uno.shared.networking.AccountServer;
import com.uno.shared.networking.MenuItemsServer;
import com.uno.shared.networking.OrderServer;
import com.uno.shared.networking.Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * This is a class with server interface implementation that creates other
 * classes and is the main class for the server.
 * @author Arturs Silins
 * @version 0.2.0
 */
public class ServerImpl implements Server {

  /**
   * This is a no-argument constructor.
   * @throws RemoteException If it is not possible to export object.
   */
  public ServerImpl() throws RemoteException {
    UnicastRemoteObject.exportObject(this, 0);
  }

  /**
   * This class adds the object to a registry and sets the name as well
   * the object that is registered.
   * @throws RemoteException If not possible to create and bind registry.
   * @throws AlreadyBoundException If there is a registry with name server on
   * that port.
   */
  public void startServer() throws RemoteException, AlreadyBoundException {
    Registry registry = LocateRegistry.createRegistry(22222);
    registry.bind("Server", this);
  }

  /**
   * Returns MenuItemServer object.
   * @return MenuItemServer object.
   */
  @Override
  public MenuItemsServer getMenuItemsServer() {
    return new MenuItemsServerImpl(new MenuItemsHandlerImpl(new DatabaseImpl()));
  }

  /**
   * Returns OrderServer object.
   * @return OrderServer object.
   */
  @Override
  public OrderServer getOrderServer() {
    return new OrderServerImpl(new OrderHandlerImpl(new DatabaseImpl()));
  }

  /**
   * A method that creates and returns account server instance.
   * @return An instance of account server object.
   */
  @Override
  public AccountServer getAccountServer() {
    return new AccountServerImpl(new AccountHandlerImpl(new DatabaseImpl()));
  }
}
