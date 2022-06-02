package com.uno.client.view.bookings.editBookings;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author Arturs Silins
 * @version 1.0.0
 */

public class EditBookingController implements ViewController {

  private ViewHandler viewHandler;
  private EditBookingViewModel viewModel;

  @FXML
  private TextField bookingNr;
  @FXML
  private TextField customerNr;
  @FXML
  private TextField guests;
  @FXML
  private TextField comment;
  @FXML
  private TextField dietaryNeeds;
  @FXML
  private TextField tableNr;

  /**
   * A method that initializes the view handler and view model factory
   */
  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory vmf) {

    this.viewHandler = viewHandler;

    bookingNr.textProperty().bindBidirectional(viewModel.bookingNrProperty());
    customerNr.textProperty().bindBidirectional(viewModel.customerNrProperty());
    guests.textProperty().bindBidirectional(viewModel.guestsProperty());
    comment.textProperty().bindBidirectional(viewModel.commentProperty());
    dietaryNeeds.textProperty().bindBidirectional(viewModel.dietaryNeedsProperty());
    tableNr.textProperty().bindBidirectional(viewModel.tableNrProperty());
  }
  //Opens staff booking view
  public void cancel() {
  }

  //Opens manager booking view
  public void cancelManager() {
  }

  /**
   * A method that updates the booking
   */

  public void updateBooking() {
    viewModel.updateBooking();
  }
}
