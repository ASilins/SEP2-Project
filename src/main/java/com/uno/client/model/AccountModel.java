package com.uno.client.model;

import com.uno.shared.transferobjects.Account;

/**
 * An interface that is used to interact from the gui with the model.
 * @author Arturs Silins
 * @version 0.2.0
 */
public interface AccountModel {

  /**
   * A method that send account object to client.
   * @param account The object that will be sent.
   */
  void createAccount(Account account);

  Account login(String phoneNumber, String password);
}
