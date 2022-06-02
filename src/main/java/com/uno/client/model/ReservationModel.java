package com.uno.client.model;

import com.uno.shared.transferobjects.Reservation;
import com.uno.shared.util.Subject;
import java.util.List;

/**
 * An interface
 * @author Arturs Silins
 * @version 1.0.0
 */
public interface ReservationModel extends Subject {

  /**
   * A method that sends a reservation object to the client
   * @param reservation The Reservation object that will be sent
   */
  void createReservation(Reservation reservation);

  /**
   * A method that takes a list of Reservation objects from the client
   * @return A list of Reservation objects
   */
  List<Reservation> getReservations();

  /**
   * A method that sends an edited reservation object to the client
   * @param reservation The object that will be sent
   */
  void updateReservation(Reservation reservation);

  /**
   * A method that fires a property change with the reservation object
   * @param reservation The reservation object that will be fired
   */
  void sendSelectedBooking(Reservation reservation);
}
