package com.uno.client.networking;

import com.uno.shared.networking.ReservationServer;
import com.uno.shared.networking.Server;
import com.uno.shared.transferobjects.Reservation;

import java.rmi.RemoteException;

/**
 * class for reservation client
 * @author Arturs Silins
 * @version 1.0.0
 */

public class ReservationClientImpl implements ReservationClient {

  private ReservationServer server;

  /**
   * Constructor for ReservationClientImpl
   * @param server takes a server as a parameter
   */

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
}
