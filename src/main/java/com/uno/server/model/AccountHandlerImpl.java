package com.uno.server.model;

import com.uno.database.Database;
import com.uno.shared.transferobjects.Account;

import java.util.List;

/**
 * A class that implements account handler interface and handles account objects.
 * @author Arturs Silins
 * @version 1.0.0
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

  /**
   * a login method
   * @param phoneNumber takes phone number as a parameter
   * @param password takes password as a parameter
   * @return returns an account
   */

  @Override
  public Account login(String phoneNumber, String password) {
    return database.login(phoneNumber, password);
  }

  /**
   * a method that retrieves users
   * @return returns a list of accounts
   */

  @Override
  public List<Account> getUsers() {
    return database.getUsers();
  }

  /**
   * a method that edits a user
   * @param account takes an account as a parameter
   */

  @Override
  public void editUser(Account account) {
    database.editUser(account);
  }
}
