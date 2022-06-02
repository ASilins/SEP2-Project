package com.uno.shared.networking;

import com.uno.shared.transferobjects.Reservation;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * An interface that creates order object in database.
 * @author Arturs Silins
 * @version 1.0.0
 */
public interface ReservationServer extends Remote {

  /**
   * A method that registers the client in the server
   * @param client The object that is registered
   * @throws RemoteException If connection failed
   */
  void registerClient(ReservationClientCallBack client) throws RemoteException;

  /**
   * A method that send reservation to the model
   * @param reservation The object that will be sent
   * @throws RemoteException If connection failed
   */
  void createReservation(Reservation reservation) throws RemoteException;

  /**
   * A method that send an edited reservation object to the model
   * @param reservation The object that will be sent
   * @throws RemoteException If connection failed
   */
  void updateReservation(Reservation reservation) throws RemoteException;

  /**
   * Return a list of reservations
   * @return A list of reservations
   * @throws RemoteException If connection failed
   */
  List<Reservation> getReservations() throws RemoteException;
}
