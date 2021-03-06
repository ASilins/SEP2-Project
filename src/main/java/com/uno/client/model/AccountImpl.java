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
 * @version 1.0.0
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

  /**
   * A private method that fires a property change
   * @param event The property change from a listener
   */
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

  /**
   * A class that sends account object to client and returns it
   * @param phoneNumber The object that will be sent.
   * @param password The object that will be sent.
   */
  @Override
  public Account login(String phoneNumber, String password) {
    return client.login(phoneNumber, password);
  }

  /**
   * A method that gets a list of Accounts from the client
   * @return a list of Account objects
   */
  @Override
  public List<Account> getUsers() {
    return client.getUsers();
  }

  /**
   * A method that sends a edited account object to the client
   * @param account An Account object that has been edited
   */
  @Override
  public void editUser(Account account) {
    client.editUser(account);
  }

  /**
   * A method that keeps an account object and fires a property
   * change while the gui is changing
   * @param account An Account object that will be sent back
   */
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

  /**
   * A method that adds property change listener
   * @param evtName The name of event it is waiting
   * @param lstnr An object that is listening
   */
  @Override
  public void addListener(String evtName, PropertyChangeListener lstnr) {
    support.addPropertyChangeListener(evtName, lstnr);
  }

  /**
   * A method that removes property change listener
   * @param evtName The name of the event it was waiting
   * @param lstnr An object that was listening
   */
  @Override
  public void removeListener(String evtName, PropertyChangeListener lstnr) {
    support.removePropertyChangeListener(evtName, lstnr);
  }
}
