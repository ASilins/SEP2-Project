package com.uno.client.view.order.viewOrders;

import com.uno.client.model.MakeOrder;
import com.uno.shared.transferobjects.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.util.List;

/**
 *
 * @author Arturs Silins
 * @version 1.0.0
 */

public class ViewOrdersViewModel {

  private MakeOrder model;
  private ObservableList<Order> orders;

  public ViewOrdersViewModel(MakeOrder model) {
    this.model = model;
    model.addListener("Update", this::update);
  }

  private void update(PropertyChangeEvent event) {
    loadOrders();
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
