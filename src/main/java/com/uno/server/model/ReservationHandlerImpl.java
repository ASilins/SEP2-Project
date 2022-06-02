package com.uno.server.model;

import com.uno.database.Database;
import com.uno.shared.transferobjects.Reservation;
import java.util.List;

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

  @Override
  public void updateReservation(Reservation reservation) {
    database.updateReservation(reservation);
  }

  @Override
  public List<Reservation> getReservations() {
    return database.getReservations();
  }
}
