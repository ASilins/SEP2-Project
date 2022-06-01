package com.uno.client.view.order.viewOrders;

import com.uno.client.model.MakeOrder;
import com.uno.shared.transferobjects.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class ViewOrdersViewModel {

  private MakeOrder model;
  private ObservableList<Order> orders;

  public ViewOrdersViewModel(MakeOrder model) {
    this.model = model;
  }

  public void loadOrders() {
    List<Order> orderList = model.getOrders();
    orders = FXCollections.observableArrayList(orderList);
  }

  public ObservableList<Order> getOrders() {
    return orders;
  }

  public void editOrder(Order order) {
    model.OrderToEdit(order);
  }
}
