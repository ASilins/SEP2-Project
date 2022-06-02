package com.uno.client.networking;

import com.uno.shared.transferobjects.Reservation;
import com.uno.shared.util.Subject;
import java.util.List;

/**
 * An interface for Reservation client
 * @author Arturs Silins
 * @version 1.0.0
 */
public interface ReservationClient extends Subject {

  /**
   * method to create an order
   * @param reservation takes a reservation as a parameter
   */

  void createReservation(Reservation reservation);

  void updateReservation(Reservation reservation);

  List<Reservation> getReservations();

  void registerClient();
}
