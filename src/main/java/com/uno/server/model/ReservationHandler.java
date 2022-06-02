package com.uno.server.model;

import com.uno.shared.transferobjects.Reservation;

/**
 * An interface that is used to send and receive Reservation objects
 * using these methods.
 * @author Arturs Silins, Maximillian Wallin
 * @version 1.0.0
 */

public interface ReservationHandler {

  void createReservation(Reservation reservation);
}
