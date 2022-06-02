package com.uno.client.networking;

import com.uno.shared.networking.ReservationServer;
import com.uno.shared.networking.Server;
import com.uno.shared.transferobjects.Reservation;

import java.rmi.RemoteException;
import java.util.List;

public class ReservationClientImpl implements ReservationClient {

  private ReservationServer server;

  public ReservationClientImpl(Server server) {
    try {
      this.server = server.getReservationServer();
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void createReservation(Reservation reservation) {
    try {
      server.createReservation(reservation);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void updateReservation(Reservation reservation) {
    try {
      server.updateReservation(reservation);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<Reservation> getReservations() {
    List<Reservation> list;

    try {
      return server.getReservations();
    } catch (RemoteException e) {
      e.printStackTrace();
    }

    return null;
  }
}
