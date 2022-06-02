package com.uno.client.view.bookings.editBookings;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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


  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
    viewModel = vmf.getEditBookingViewModel();
    this.viewHandler = viewHandler;

    bookingNr.textProperty().bindBidirectional(viewModel.bookingNrProperty());
    customerNr.textProperty().bindBidirectional(viewModel.customerNrProperty());
    guests.textProperty().bindBidirectional(viewModel.guestsProperty());
    comment.textProperty().bindBidirectional(viewModel.commentProperty());
    dietaryNeeds.textProperty().bindBidirectional(viewModel.dietaryNeedsProperty());
    tableNr.textProperty().bindBidirectional(viewModel.tableNrProperty());
  }

  public void cancel() {
    viewHandler.openViewBooking();
  }

  public void cancelManager() {
    viewHandler.openManagerViewBooking();
  }

  public void updateBooking() {
    viewModel.updateBooking();
  }
}
