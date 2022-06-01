package com.uno.client.view.bookings;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.view.ViewController;
import com.uno.shared.transferobjects.Reservation;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewBookingsController implements ViewController {

  private ViewHandler viewHandler;
  private ViewBookingsViewModel viewModel;

  @FXML
  private TableView<Reservation> table;
  public TableColumn<String, Reservation> bookingNr;
  public TableColumn<String, Reservation> customerNr;
  public TableColumn<String, Reservation> date;
  public TableColumn<String, Reservation> guests;
  public TableColumn<String, Reservation> comment;
  public TableColumn<String, Reservation> dietaryNeeds;
  public TableColumn<String, Reservation> tableNr;


  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
    viewModel = vmf.getViewBookingsViewModel();
    this.viewHandler = viewHandler;

    viewModel.loadBookings();
    table.setItems(viewModel.getBookings());
    bookingNr.setCellValueFactory(new PropertyValueFactory<>(""));
    customerNr.setCellValueFactory(new PropertyValueFactory<>(""));
    date.setCellValueFactory(new PropertyValueFactory<>(""));
    guests.setCellValueFactory(new PropertyValueFactory<>(""));
    comment.setCellValueFactory(new PropertyValueFactory<>(""));
    dietaryNeeds.setCellValueFactory(new PropertyValueFactory<>(""));
    tableNr.setCellValueFactory(new PropertyValueFactory<>(""));
  }

  public void backManager() {
    viewHandler.openManagerMainMenu();
  }

  public void back() {
    viewHandler.openStaffMainMenu();
  }

  public void editBooking() {

  }
}
