package com.uno.client.view.bookings;

import com.uno.client.model.ReservationModel;
import com.uno.shared.transferobjects.Order;
import com.uno.shared.transferobjects.Reservation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.beans.PropertyChangeEvent;
import java.util.List;

/**
 * A class that controls view bookings controller and model
 * @author Arturs Silins
 * @version 1.0.0
 */
public class ViewBookingsViewModel {

  private ReservationModel model;

  private ObservableList<Reservation> bookings;

  /**
   * A constructor that sets the instance of model and creates and listener
   * @param model The model instance
   */
  public ViewBookingsViewModel(ReservationModel model) {
    this.model = model;
    model.addListener("Update", this::update);
  }

  /**
   * A method that resets the list of bookings
   * @param event The list of bookings
   */
  private void update(PropertyChangeEvent event) {
    bookings.clear();
    bookings.addAll((List<Reservation>) event.getNewValue());
  }

  /**
   * A method that gets a list and sets it to the bookings list
   */
  public void loadBookings() {
    List<Reservation> reservationList = model.getReservations();
    bookings = FXCollections.observableArrayList(reservationList);
  }

  /**
   * A method that returns an observable list of Reservations
   * @return A observable list of Reservations
   */
  public ObservableList<Reservation> getBookings() {
    return bookings;
  }

  /**
   * A method that sends selected booking to the model
   * @param reservation the object that will be sent
   */
  public void sendSelectedBooking(Reservation reservation) {
    model.sendSelectedBooking(reservation);
  }
}
