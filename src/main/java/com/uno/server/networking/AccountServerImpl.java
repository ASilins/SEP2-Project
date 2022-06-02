package com.uno.server.networking;

import com.uno.server.model.AccountHandler;
import com.uno.shared.networking.AccountClientCallBack;
import com.uno.shared.networking.AccountServer;
import com.uno.shared.transferobjects.Account;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that implements account server interface. Handles receiving and
 * sending account objects from the server to the client.
 * @author Arturs Silins
 * @version 1.0.0
 */
public class AccountServerImpl implements AccountServer {

  private AccountHandler handler;

  private List<AccountClientCallBack> clients;

  /**
   * A constructor that sets the account handler instance for the object.
   * @param handler The object that will be set as.
   */
  public AccountServerImpl(AccountHandler handler) {
    try {
      UnicastRemoteObject.exportObject(this,0);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
    this.handler = handler;
    clients = new ArrayList<>();
  }

  /**
   * A method that registers the client in the server
   * @param client The object that is registered
   * @throws RemoteException If connection failed
   */
  public void registerClient(AccountClientCallBack client) throws RemoteException {
    clients.add(client);
  }

  /**
   * A method that sends an update to all clients
   */
  private void update() {
    for (AccountClientCallBack account : clients) {
      try {
        account.update();
      } catch (RemoteException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * A method that takes account object and creates it.
   * @param account The object that will be sent to the database.
   */
  @Override
  public void createAccount(Account account) {
    handler.createAccount(account);
    update();
  }

  /**
   * A method that sends login info and returns account
   * @param phoneNumber the phone number
   * @param password the hash code of the password
   * @return An account object
   * @throws RemoteException If connection failed
   */
  @Override
  public Account login(String phoneNumber, String password) {
    return handler.login(phoneNumber, password);
  }

  /**
   * A method that returns a list of users
   * @return A list of Account objects
   * @throws RemoteException If connection failed
   */
  @Override
  public List<Account> getUsers() throws RemoteException {
    return handler.getUsers();
  }

  /**
   * A method that sends Account object to the model
   * @param account The object that will be sent
   * @throws RemoteException If connection failed
   */
  @Override
  public void editUser(Account account) throws RemoteException {
    handler.editUser(account);
    update();
  }
}
