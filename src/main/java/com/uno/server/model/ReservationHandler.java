package com.uno.server.model;

import com.uno.shared.transferobjects.Reservation;

import java.util.List;

public interface ReservationHandler {

  void createReservation(Reservation reservation);

  void updateReservation(Reservation reservation);

  List<Reservation> getReservations();
}
