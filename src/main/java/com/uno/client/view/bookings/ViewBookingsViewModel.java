package com.uno.client.view.bookings;

import com.uno.client.model.ReservationModel;
import com.uno.shared.transferobjects.Reservation;
import javafx.collections.ObservableList;

public class ViewBookingsViewModel {

  private ReservationModel model;

  private ObservableList<Reservation> bookings;

  public ViewBookingsViewModel(ReservationModel model) {
    this.model = model;
  }

  public void loadBookings() {

  }

  public ObservableList<Reservation> getBookings() {
    return bookings;
  }
}
