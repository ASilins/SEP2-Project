package com.uno.shared.networking;

import com.uno.shared.transferobjects.Reservation;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * An interface that creates order object in database.
 * @author Arturs Silins
 * @version 1.0.0
 */
public interface ReservationServer extends Remote {

  void createReservation(Reservation reservation) throws RemoteException;
}
