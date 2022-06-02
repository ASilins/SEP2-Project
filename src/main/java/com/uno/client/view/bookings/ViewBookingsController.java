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

    bookingNr.setCellValueFactory(new PropertyValueFactory<>("reservationNumber"));
    customerNr.setCellValueFactory(new PropertyValueFactory<>("customerNumber"));
    date.setCellValueFactory(new PropertyValueFactory<>("date"));
    guests.setCellValueFactory(new PropertyValueFactory<>("amountOfPeople"));
    comment.setCellValueFactory(new PropertyValueFactory<>("comment"));
    dietaryNeeds.setCellValueFactory(new PropertyValueFactory<>("dietaryNeeds"));
    tableNr.setCellValueFactory(new PropertyValueFactory<>("table"));
  }

  public void back() {
    viewHandler.openStaffMainMenu();
  }

  public void backManager() {
    viewHandler.openManagerMainMenu();
  }

  public void editBooking() {
    sendSelectedBooking();
    viewHandler.openEditBooking();
  }

  public void managerEditBooking() {
    sendSelectedBooking();
    viewHandler.openManagerEditBooking();
  }

  private void sendSelectedBooking() {
    viewModel.sendSelectedBooking(table.getSelectionModel().getSelectedItem());
  }
}
