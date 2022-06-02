package com.uno.client.networking;

import com.uno.shared.transferobjects.Account;
import com.uno.shared.util.Subject;

import java.util.List;

/**
 * An interface that is used to interact with the server
 * from the model using client classes.
 * @author Arturs Silins
 * @version 1.0.0
 */
public interface AccountClient extends Subject {

  /**
   * A method that send account object to the server.
   * @param account The object that will be sent to the server.
   */
  void createAccount(Account account);

  /**
   * A method that finds the connected phoneNumber and password in the system to login
   */
  Account login(String phoneNumber, String password);

  /**
   * A method that returns a list of Accounts from a server
   * @return A list of Account objects
   */
  List<Account> getUsers();

  /**
   * A method that send an edited object to the server
   * @param account The object that will be sent
   */
  void editUser(Account account);

  /**
   * A method that registers client to the server
   */
  void registerClient();
}
