package com.uno.client.model;

import com.uno.client.networking.AccountClient;
import com.uno.client.networking.Client;
import com.uno.shared.transferobjects.Account;

/**
 * A class that handles creating and logging in account.
 * @author Arturs Silins
 * @version 0.2.0
 */
public class AccountImpl implements AccountModel {

  private AccountClient client;

  /**
   * Constructor that set instance of client for the instance.
   * @param client The object that will provide the instance.
   */
  public AccountImpl(Client client) {
    this.client = client.getAccountClient();
  }

  /**
   * A class that sends account object to client class.
   * @param account The object that will be sent.
   */
  @Override
  public void createAccount(Account account) {
    client.createAccount(account);
  }
}
