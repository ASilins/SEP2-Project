package com.uno.client.networking;

import com.uno.shared.transferobjects.Reservation;
import com.uno.shared.util.Subject;

import java.util.List;

public interface ReservationClient extends Subject {

  void createReservation(Reservation reservation);

  void updateReservation(Reservation reservation);

  List<Reservation> getReservations();

  void registerClient();
}
