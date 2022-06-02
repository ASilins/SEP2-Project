package com.uno.server.model;

import com.uno.shared.transferobjects.Account;

import java.util.List;

/**
 * Interface that lets server interact with database for the client account
 * @author Arturs Silins
 * @version 1.0.0
 */
public interface AccountHandler {

  /**
   * A method that  takes account object and sends it to the database.
   * @param account The object that will be sent to the database.
   */
  void createAccount(Account account);

  /**
   * a login method
   * @param phoneNumber takes phone number as a parameter
   * @param password takes password as a parameter
   * @return returns an account
   */

  Account login(String phoneNumber, String password);

  /**
   * a method that retrieves users
   * @return returns a list of accounts
   */

  List<Account> getUsers();

  /**
   * a method that edits a user
   * @param account takes an account as a parameter
   */

  void editUser(Account account);
}
