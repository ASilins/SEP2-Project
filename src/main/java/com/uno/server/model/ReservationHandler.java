package com.uno.server.model;

import com.uno.shared.transferobjects.Reservation;
import java.util.List;

/**
 * An interface that is used to send and receive Reservation objects
 * using these methods.
 * @author Arturs Silins, Maximillian Wallin
 * @version 1.0.0
 */
public interface ReservationHandler {

  void createReservation(Reservation reservation);

  void updateReservation(Reservation reservation);

  List<Reservation> getReservations();
}
