package com.uno.server.networking;

import com.uno.server.model.AccountHandler;
import com.uno.shared.networking.AccountServer;
import com.uno.shared.transferobjects.Account;

import java.rmi.RemoteException;

/**
 * A class that implements account server interface. Handles receiving and
 * sending account objects from the server to the client.
 * @author Arturs Silins
 * @version 0.2.0
 */
public class AccountServerImpl implements AccountServer {

  private AccountHandler handler;

  /**
   * A constructor that sets the account handler instance for the object.
   * @param handler The object that will be set as.
   */
  public AccountServerImpl(AccountHandler handler) {
    this.handler = handler;
  }

  /**
   * A method that takes account object and creates it.
   * @param account The object that will be sent to the database.
   */
  @Override
  public void createAccount(Account account) {
    handler.createAccount(account);
  }
}
