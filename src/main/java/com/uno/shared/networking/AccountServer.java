package com.uno.shared.networking;

import com.uno.shared.transferobjects.Account;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * An interface that extends remote. Handles receiving and sending account
 * objects to the server and back to the client.
 * @author Arturs Silins
 * @version 0.2.0
 */
public interface AccountServer extends Remote {

  void registerClient(AccountClientCallBack client) throws RemoteException;

  /**
   * A method that send account object to the server.
   * @param account The account object that is sent from th client.
   * @throws RemoteException If not possible to send from the client.
   */
  void createAccount(Account account) throws RemoteException;

  Account login(String phoneNumber, String password) throws RemoteException;

  List<Account> getUsers() throws RemoteException;

  void editUser(Account account) throws RemoteException;
}
