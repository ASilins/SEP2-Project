package com.uno.client.networking;

import com.uno.shared.networking.AccountServer;
import com.uno.shared.networking.Server;
import com.uno.shared.transferobjects.Account;

/**
 * A class that logins the account and can also create account.
 * @author Arturs Silins
 * @version 0.2.0
 */
public class AccountClientImpl implements AccountClient{

  private AccountServer server;

  /**
   * Constructor that sets instance of account server for the object.
   * @param server The object that gives the instance.
   */
  public AccountClientImpl(Server server) {
    this.server = server.getAccountServer();
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
}
