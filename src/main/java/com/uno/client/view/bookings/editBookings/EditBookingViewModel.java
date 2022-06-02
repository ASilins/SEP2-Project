package com.uno.client.view.bookings.editBookings;

import com.uno.client.model.ReservationModel;
import com.uno.shared.transferobjects.Order;
import com.uno.shared.transferobjects.Reservation;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.sql.Timestamp;
import java.util.Date;

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

    model.addListener("ReservationToEdit", this::ReservationToEdit);
  }

  private void ReservationToEdit(PropertyChangeEvent event) {
    Reservation reservation;

    if (event.getNewValue() == null) {
      reservation = new Reservation(0, "", new Timestamp(0), 0, "", "", 0);
    } else {
      reservation = (Reservation) event.getNewValue();
    }

    Platform.runLater(() -> {
      bookingNr.set(Integer.toString(reservation.getReservationNumber()));
      customerNr.set(reservation.getCustomerNumber());
      guests.set(Integer.toString(reservation.getAmountOfPeople()));
      comment.set(reservation.getComment());
      dietaryNeeds.set(reservation.getDietaryNeeds());
      tableNr.set(Integer.toString(reservation.getTable()));
    });
  }

  public void updateBooking() {
    model.updateReservation(new Reservation(Integer.parseInt(bookingNr.get()), customerNr.get(), null, Integer.parseInt(guests.get()), comment.get(), dietaryNeeds.get(), Integer.parseInt(tableNr.get())));
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
