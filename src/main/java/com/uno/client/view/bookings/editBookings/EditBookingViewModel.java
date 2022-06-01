package com.uno.client.view.bookings.editBookings;

import com.uno.client.model.ReservationModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EditBookingViewModel {

  private ReservationModel model;

  private StringProperty bookingNr;
  private StringProperty customerNr;
  private StringProperty guests;
  private StringProperty comment;
  private StringProperty dietaryNeeds;
  private StringProperty tableNr;

  public EditBookingViewModel(ReservationModel model) {
    this.model = model;

    bookingNr = new SimpleStringProperty();
    customerNr = new SimpleStringProperty();
    guests = new SimpleStringProperty();
    comment = new SimpleStringProperty();
    dietaryNeeds = new SimpleStringProperty();
    tableNr = new SimpleStringProperty();
  }

  public void updateBooking() {

  }

  public StringProperty bookingNrProperty() {
    return bookingNr;
  }

  public StringProperty customerNrProperty() {
    return customerNr;
  }

  public StringProperty guestsProperty() {
    return guests;
  }

  public StringProperty commentProperty() {
    return comment;
  }

  public StringProperty dietaryNeedsProperty() {
    return dietaryNeeds;
  }

  public StringProperty tableNrProperty() {
    return tableNr;
  }
}
