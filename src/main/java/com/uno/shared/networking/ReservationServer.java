package com.uno.shared.networking;

import com.uno.shared.transferobjects.Reservation;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ReservationServer extends Remote {

  void createReservation(Reservation reservation) throws RemoteException;

  void updateReservation(Reservation reservation) throws RemoteException;

  List<Reservation> getReservations() throws RemoteException;
}
