package com.uno.shared.networking;

import com.uno.shared.transferobjects.Reservation;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ReservationServer extends Remote {

  void createReservation(Reservation reservation) throws RemoteException;
}
