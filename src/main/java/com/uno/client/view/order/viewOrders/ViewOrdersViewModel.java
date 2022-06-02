package com.uno.client.view.order.viewOrders;

import com.uno.client.model.MakeOrder;
import com.uno.shared.transferobjects.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.util.List;

/**
 * A method that controls view order controller and the model
 * @author Arturs Silins
 * @version 1.0.0
 */

public class ViewOrdersViewModel {

  private MakeOrder model;
  private ObservableList<Order> orders;

  /**
   * A constructor that set the instance of the model
   * @param model
   */
  public ViewOrdersViewModel(MakeOrder model) {
    this.model = model;
    model.addListener("Update", this::update);
  }

  /**
   * A method that resets the table information
   * @param event
   */
  private void update(PropertyChangeEvent event) {
    orders.clear();
    orders.setAll((List<Order>) event.getNewValue());
  }

  /**
   * A method that loads the list
   */
  public void loadOrders() {
    List<Order> orderList = model.getOrders();
    orders = FXCollections.observableArrayList(orderList);
  }

  /**
   * A method that returns an observable list of orders
   * @return an observable list of orders
   */
  public ObservableList<Order> getOrders() {
    return orders;
  }

  /**
   * A method that sends an order to be edited
   * @param order The object that will be edited
   */
  public void editOrder(Order order) {
    model.OrderToEdit(order);
  }
}
