package com.uno.client.networking;

import com.uno.shared.networking.AccountClientCallBack;
import com.uno.shared.networking.AccountServer;
import com.uno.shared.networking.Server;
import com.uno.shared.transferobjects.Account;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * A class that logins the account and can also create account.
 * @author Arturs Silins
 * @version 0.2.0
 */
public class AccountClientImpl implements AccountClient, AccountClientCallBack {

  private AccountServer server;

  private PropertyChangeSupport support;

  /**
   * Constructor that sets instance of account server for the object.
   * @param server The object that gives the instance.
   */
  public AccountClientImpl(Server server) {
    try {
      this.server = server.getAccountServer();
      UnicastRemoteObject.exportObject(this, 0);
    } catch (RemoteException e) {
      e.printStackTrace();
    }

    support = new PropertyChangeSupport(this);
  }

  public void registerClient() {
    try {
      server.registerClient(this);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }

  /**
   * A method that takes account object and send it to the server.
   * @param account The object that will be sent to the server.
   */
  @Override
  public void createAccount(Account account) {
    try {
      server.createAccount(account);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public Account login(String phoneNumber, String password) {
    Account temp = null;

    try {
      temp = server.login(phoneNumber, password);
    } catch (RemoteException e) {
      e.printStackTrace();
    }

    return temp;
  }

  @Override
  public List<Account> getUsers() {
    try {
      return server.getUsers();
    } catch (RemoteException e) {
      e.printStackTrace();
    }

    return null;
  }

  @Override
  public void editUser(Account account) {
    try {
      server.editUser(account);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update() {
      support.firePropertyChange("Update", null, getUsers());
  }

  @Override
  public void addListener(String evtName, PropertyChangeListener lstnr) {
    support.addPropertyChangeListener(evtName, lstnr);
  }

  @Override
  public void removeListener(String evtName, PropertyChangeListener lstnr) {
    support.removePropertyChangeListener(evtName, lstnr);
  }
}
