package com.uno.client.networking;

import com.uno.shared.networking.AccountServer;
import com.uno.shared.networking.Server;
import com.uno.shared.transferobjects.Account;

import java.rmi.RemoteException;

/**
 * A class that logins the account and can also create account.
 * @author Arturs Silins
 * @version 1.0.0
 */
public class AccountClientImpl implements AccountClient{

  private AccountServer server;

  /**
   * Constructor that sets instance of account server for the object.
   * @param server The object that gives the instance.
   */
  public AccountClientImpl(Server server) {
    try {
      this.server = server.getAccountServer();
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }

  /**
   * A method that takes account object and sends it to the server.
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

  /**
   * A class that sends account object to client and returns it
   * @param phoneNumber The object that will be sent.
   * @param password The object that will be sent.
   */

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
}
