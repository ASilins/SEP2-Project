package com.uno.client.networking;

import com.uno.shared.transferobjects.Reservation;

public interface ReservationClient {

  void createReservation(Reservation reservation);
}
