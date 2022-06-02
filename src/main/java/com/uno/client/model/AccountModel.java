package com.uno.client.model;

import com.uno.shared.transferobjects.Account;

/**
 * An interface that is used to interact from the gui with the model.
 * @author Arturs Silins
 * @version 1.0.0
 */
public interface AccountModel {

  /**
   * A method that send account object to client.
   * @param account The object that will be sent.
   */
  void createAccount(Account account);

  /**
   * A method that finds the connected phoneNumber and password in the system to login
   */

  Account login(String phoneNumber, String password);
}
