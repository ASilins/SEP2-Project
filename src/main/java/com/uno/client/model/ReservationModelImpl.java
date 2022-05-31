package com.uno.client.model;

import com.uno.client.networking.Client;
import com.uno.client.networking.ReservationClient;
import com.uno.shared.transferobjects.Reservation;

import java.rmi.RemoteException;

public class ReservationModelImpl implements ReservationModel{

  private ReservationClient client;

  public ReservationModelImpl(Client client) {
    try {
      this.client = client.getReservationClient();
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void createReservation(Reservation reservation) {
    client.createReservation(reservation);
  }
}
