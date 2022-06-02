package com.uno.client.view.bookings;

import com.uno.client.model.ReservationModel;
import com.uno.shared.transferobjects.Order;
import com.uno.shared.transferobjects.Reservation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class ViewBookingsViewModel {

  private ReservationModel model;

  private ObservableList<Reservation> bookings;

  public ViewBookingsViewModel(ReservationModel model) {
    this.model = model;
    model.addListener("Update", this::update);
  }

  private void update(PropertyChangeEvent event) {
    loadBookings();
  }

  public void loadBookings() {
    List<Reservation> reservationList = model.getReservations();
    bookings = FXCollections.observableArrayList(reservationList);
  }

  public ObservableList<Reservation> getBookings() {
    return bookings;
  }

  public void sendSelectedBooking(Reservation reservation) {
    model.sendSelectedBooking(reservation);
  }
}
