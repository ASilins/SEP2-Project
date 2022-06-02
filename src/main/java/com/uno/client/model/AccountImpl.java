package com.uno.client.model;

import com.uno.client.networking.AccountClient;
import com.uno.client.networking.Client;
import com.uno.shared.transferobjects.Account;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.util.List;

/**
 * A class that handles creating and logging in account.
 * @author Arturs Silins
 * @version 0.2.0
 */
public class AccountImpl implements AccountModel {

  private AccountClient client;

  private PropertyChangeSupport support;

  /**
   * Constructor that set instance of client for the instance.
   * @param client The object that will provide the instance.
   */
  public AccountImpl(Client client) {
    try {
      this.client = client.getAccountClient();
      this.client.registerClient();
      this.client.addListener("Update", this::update);
    } catch (RemoteException e) {
      e.printStackTrace();
    }

    support = new PropertyChangeSupport(this);
  }

  private void update(PropertyChangeEvent event) {
    support.firePropertyChange("Update", null, event.getNewValue());
  }

  /**
   * A class that sends account object to client class.
   * @param account The object that will be sent.
   */
  @Override
  public void createAccount(Account account) {
    client.createAccount(account);
  }

  @Override
  public Account login(String phoneNumber, String password) {
    return client.login(phoneNumber, password);
  }

  @Override
  public List<Account> getUsers() {
    return client.getUsers();
  }

  @Override
  public void editUser(Account account) {
    client.editUser(account);
  }

  @Override
  public void userToEdit(Account account) {
    new Thread(() -> {
      try {
        Thread.sleep(250);
        support.firePropertyChange("UserToEdit", null, account);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();
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
