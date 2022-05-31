package com.uno.server.model;

import com.uno.database.Database;
import com.uno.shared.transferobjects.Reservation;

public class ReservationHandlerImpl implements ReservationHandler {

  private Database database;

  public ReservationHandlerImpl(Database database) {
    this.database = database;
  }

  @Override
  public void createReservation(Reservation reservation) {
    database.createReservation(reservation);
  }
}
