package com.uno.server.model;

import com.uno.shared.transferobjects.Account;

/**
 * Interface that lets server interact with database for the client account
 * @author Arturs Silins
 * @version 0.2.0
 */
public interface AccountHandler {

  /**
   * A method that  takes account object and sends it to the database.
   * @param account The object that will be sent to the database.
   */
  void createAccount(Account account);

  Account login(String phoneNumber, String password);
}
