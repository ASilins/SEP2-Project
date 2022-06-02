package com.uno.shared.networking;

import com.uno.shared.transferobjects.Account;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * An interface that extends remote. Handles receiving and sending account
 * objects to the server and back to the client.
 * @author Arturs Silins
 * @version 1.0.0
 */
public interface AccountServer extends Remote {

  /**
   * A method that registers the client in the server
   * @param client The object that is registered
   * @throws RemoteException If connection failed
   */
  void registerClient(AccountClientCallBack client) throws RemoteException;

  /**
   * A method that send account object to the server.
   * @param account The account object that is sent from th client.
   * @throws RemoteException If not possible to send from the client.
   */
  void createAccount(Account account) throws RemoteException;

  /**
   * A method that sends login info and returns account
   * @param phoneNumber the phone number
   * @param password the hash code of the password
   * @return An account object
   * @throws RemoteException If connection failed
   */
  Account login(String phoneNumber, String password) throws RemoteException;

  /**
   * A method that returns a list of users
   * @return A list of Account objects
   * @throws RemoteException If connection failed
   */
  List<Account> getUsers() throws RemoteException;

  /**
   * A method that sends Account object to the model
   * @param account The object that will be sent
   * @throws RemoteException If connection failed
   */
  void editUser(Account account) throws RemoteException;
}
