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

  void registerClient(ReservationClientCallBack client) throws RemoteException;

  void createReservation(Reservation reservation) throws RemoteException;

  void updateReservation(Reservation reservation) throws RemoteException;

  List<Reservation> getReservations() throws RemoteException;
}
