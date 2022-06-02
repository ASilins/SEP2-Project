package com.uno.shared.networking;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * An interface that is used as a call back to the client for updates in table
 * @author Arturs Silins
 * @version 1.0.0
 */
public interface ReservationClientCallBack extends Remote {

  /**
   * A method that fires a property change
   * @throws RemoteException If connection failed
   */
  void update() throws RemoteException;
}
