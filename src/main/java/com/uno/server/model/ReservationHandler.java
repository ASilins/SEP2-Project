package com.uno.server.model;

import com.uno.shared.transferobjects.Reservation;

public interface ReservationHandler {

  void createReservation(Reservation reservation);
}
