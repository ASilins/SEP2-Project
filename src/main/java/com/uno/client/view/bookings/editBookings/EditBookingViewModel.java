package com.uno.client.view.bookings.editBookings;

import com.uno.client.model.ReservationModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Arturs Silins
 * @version 1.0.0
 */

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

  /**
   * returns the string property of the bookingNr
   */
  public StringProperty bookingNrProperty() {
    return bookingNr;
  }

  /**
   * returns the string property of the customerNr
   */
  public StringProperty customerNrProperty() {
    return customerNr;
  }

  /**
   * returns the string property of the guests
   */
  public StringProperty guestsProperty() {
    return guests;
  }

  /**
   * returns the string property of the comment
   */
  public StringProperty commentProperty() {
    return comment;
  }

  /**
   * returns the string property of the dietaryNeeds
   */
  public StringProperty dietaryNeedsProperty() {
    return dietaryNeeds;
  }

  /**
   * returns the string property of the tableNr
   */
  public StringProperty tableNrProperty() {
    return tableNr;
  }
}
