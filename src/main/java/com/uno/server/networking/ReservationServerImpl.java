package com.uno.server.networking;

import com.uno.server.model.ReservationHandler;
import com.uno.shared.networking.ReservationServer;
import com.uno.shared.transferobjects.Reservation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ReservationServerImpl implements ReservationServer {

  private ReservationHandler handler;

  public ReservationServerImpl(ReservationHandler handler) throws RemoteException{
    UnicastRemoteObject.exportObject(this, 0);
    this.handler = handler;
  }

  @Override
  public void createReservation(Reservation reservation) throws RemoteException {

  }

  @Override
  public void updateReservation(Reservation reservation) throws RemoteException {
    handler.updateReservation(reservation);
  }

  @Override
  public List<Reservation> getReservations() throws RemoteException {
    return handler.getReservations();
  }
}
