package com.uno.server.model;

import com.uno.database.Database;
import com.uno.shared.transferobjects.Account;

/**
 * A class that implements account handler interface and handles account objects.
 * @author Arturs Silins
 * @version 0.2.0
 */
public class AccountHandlerImpl implements AccountHandler {

  private Database database;

  /**
   * Constructor that takes database object and sets it in the instance.
   * @param database The object that will be set in the instance.
   */
  public AccountHandlerImpl(Database database) {
    this.database = database;
  }

  /**
   * A method that send account object and sends it to the database.
   * @param account The object that will be sent to the database.
   */
  @Override
  public void createAccount(Account account) {
    database.createAccount(account);
  }
}