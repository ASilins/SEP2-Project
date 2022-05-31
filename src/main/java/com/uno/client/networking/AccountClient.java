package com.uno.client.networking;

import com.uno.shared.transferobjects.Account;

/**
 * An interface that is used to interact with the server
 * from the model using client classes.
 * @author Arturs Silins
 * @version 0.2.0
 */
public interface AccountClient {

  /**
   * A method that send account object to the server.
   * @param account The object that will be sent to the server.
   */
  void createAccount(Account account);

  Account login(String phoneNumber, String password);
}
