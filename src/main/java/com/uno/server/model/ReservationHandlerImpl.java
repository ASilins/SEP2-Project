package com.uno.server.model;

import com.uno.database.Database;
import com.uno.shared.transferobjects.Reservation;

/**
 * A class that handles Reservation objects from the database to the client.
 * @author Arturs Silins
 * @version 1.0.0
 */
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
