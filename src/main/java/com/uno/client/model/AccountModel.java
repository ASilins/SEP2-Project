package com.uno.client.model;

import com.uno.shared.transferobjects.Account;
import com.uno.shared.util.Subject;

import java.util.List;

/**
 * An interface that is used to interact from the gui with the model.
 * @author Arturs Silins
 * @version 1.0.0
 */
public interface AccountModel extends Subject {

  /**
   * A method that send account object to client.
   * @param account The object that will be sent.
   */
  void createAccount(Account account);

  /**
   * A method that finds the connected phoneNumber and password in the system to login
   */
  Account login(String phoneNumber, String password);

  /**
   * A method that returns a list of Account objects from the client
   * @return A list of Account objects
   */
  List<Account> getUsers();

  /**
   * A method that sends an edited account object to the client
   * @param account The Account object that will be sent
   */
  void editUser(Account account);

  /**
   * A method that fires a property change and sends the Account object
   * @param account The Account object
   */
  void userToEdit(Account account);
}
