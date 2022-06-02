package com.uno.client.networking;

import com.uno.shared.transferobjects.Reservation;

/**
 * An interface for Reservation client
 * @author Arturs Silins
 * @version 1.0.0
 */

public interface ReservationClient {

  /**
   * method to create an order
   * @param reservation takes a reservation as a parameter
   */

  void createReservation(Reservation reservation);
}
