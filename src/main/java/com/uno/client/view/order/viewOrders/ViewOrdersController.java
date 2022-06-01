package com.uno.client.view.order.viewOrders;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.view.ViewController;
import com.uno.shared.transferobjects.Order;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewOrdersController implements ViewController {

  private ViewHandler viewHandler;
  private ViewOrdersViewModel viewModel;

  @FXML
  private TableView<Order> table;
  public TableColumn<String, Order> orderNumber;
  public TableColumn<String, Order> menuItem;
  public TableColumn<String, Order> comment;
  public TableColumn<String, Order> dietaryNeeds;

  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
    this.viewModel = vmf.getViewOrdersViewModel();
    this.viewHandler = viewHandler;
    viewModel.loadOrders();
    table.setItems(viewModel.getOrders());
    orderNumber.setCellValueFactory(new PropertyValueFactory<>("orderNumber"));
    menuItem.setCellValueFactory(new PropertyValueFactory<>("menuItem"));
    comment.setCellValueFactory(new PropertyValueFactory<>("comment"));
    dietaryNeeds.setCellValueFactory(new PropertyValueFactory<>("dietaryNeeds"));
  }

  public void backManager() {
    viewHandler.openManagerMainMenu();
  }

  public void back() {
    viewHandler.openStaffMainMenu();
  }

  public void editOrder() {
    viewModel.editOrder(table.getSelectionModel().getSelectedItem());
    viewHandler.openEditOrder();
  }
}
