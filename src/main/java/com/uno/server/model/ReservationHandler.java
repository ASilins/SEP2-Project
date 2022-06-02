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

  /**
   * a method that creates a reservation
   * @param reservation takes a reservation as a parameter
   */

  void createReservation(Reservation reservation);

  /**
   * a method that updates a reservation
   * @param reservation takes a reservation as a parameter
   */

  void updateReservation(Reservation reservation);

  /**
   * a method that retrieves reservations
   * @return returns a list of reservations
   */

  List<Reservation> getReservations();
}
