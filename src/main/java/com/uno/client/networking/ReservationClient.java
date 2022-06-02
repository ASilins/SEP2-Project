package com.uno.client.networking;

import com.uno.shared.transferobjects.Reservation;

import java.util.List;

public interface ReservationClient {

  void createReservation(Reservation reservation);

  void updateReservation(Reservation reservation);

  List<Reservation> getReservations();
}
