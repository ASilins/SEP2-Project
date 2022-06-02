package com.uno.client.model;

import com.uno.shared.transferobjects.Reservation;
import com.uno.shared.util.Subject;

import java.util.List;

public interface ReservationModel extends Subject {

  void createReservation(Reservation reservation);

  List<Reservation> getReservations();

  void updateReservation(Reservation reservation);

  void sendSelectedBooking(Reservation reservation);
}
