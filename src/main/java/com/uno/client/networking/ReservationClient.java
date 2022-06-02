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

  /**
   * A method that sends an edited object to the server
   * @param reservation Teh object that will be sent
   */
  void updateReservation(Reservation reservation);

  /**
   * A method that gets a list of Reservation objects from the server
   * @return A list og Reservation objects
   */
  List<Reservation> getReservations();

  /**
   * A method that registers client to the server
   */
  void registerClient();
}
