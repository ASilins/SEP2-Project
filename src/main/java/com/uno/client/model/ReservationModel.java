package com.uno.client.model;

import com.uno.shared.transferobjects.Reservation;
import com.uno.shared.util.Subject;
import java.util.List;

/**
 *
 * @author Arturs Silins
 * @version 1.0.0
 */
public interface ReservationModel extends Subject {

  void createReservation(Reservation reservation);

  List<Reservation> getReservations();

  void updateReservation(Reservation reservation);

  void sendSelectedBooking(Reservation reservation);
}
