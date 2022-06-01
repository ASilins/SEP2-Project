package com.uno.server.networking;

import com.uno.database.Database;
import com.uno.database.DatabaseHandler;
import com.uno.database.DatabaseImpl;
import com.uno.server.model.*;
import com.uno.shared.networking.*;

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

  private ReservationServer rs;
  private MenuItemsServer mis;
  private OrderServer os;
  private AccountServer as;
  private TableServer ts;


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
    System.out.println("\nServer started");
  }

  /**
   * Returns MenuItemServer object.
   * @return MenuItemServer object.
   */
  @Override
  public MenuItemsServer getMenuItemsServer() {
    if (mis == null) {
      mis = new MenuItemsServerImpl(new MenuItemsHandlerImpl(new DatabaseImpl()));
    }

    return mis;
  }

  /**
   * Returns OrderServer object.
   * @return OrderServer object.
   */
  @Override
  public OrderServer getOrderServer(){
    if (os == null) {
      try {
        os = new OrderServerImpl(new OrderHandlerImpl(new DatabaseImpl()));
      } catch (RemoteException e) {
        e.printStackTrace();
      }
    }

    return os;
  }

  /**
   * A method that creates and returns account server instance.
   * @return An instance of account server object.
   */
  @Override
  public AccountServer getAccountServer() {
    if (as == null) {
      as = new AccountServerImpl(new AccountHandlerImpl(new DatabaseImpl()));
    }

    return as;
  }

  /**
   * A method that returns new instance of table server
   * @return An table server object
   */
  @Override
  public TableServer getTableServer() {
    if (ts == null) {
      ts = new TableServerImpl(new TableHandlerImpl(new DatabaseImpl()));
    }
    return ts;
  }

  @Override
  public ReservationServer getReservationServer() {
    if (rs == null) {
      try {
        rs = new ReservationServerImpl(new ReservationHandlerImpl(new DatabaseImpl()));
      } catch (RemoteException e) {
        e.printStackTrace();
      }
    }

    return rs;
  }
}
