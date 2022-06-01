package com.uno.client.view.order.editOrder;

import com.uno.client.model.MakeOrder;
import com.uno.shared.transferobjects.Order;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class EditOrderViewModel {

  private MakeOrder model;

  private StringProperty orderNumber;
  private StringProperty menuItem;
  private StringProperty comment;
  private StringProperty dietaryNeeds;

  public EditOrderViewModel(MakeOrder model) {
    this.model = model;
    model.addListener("OrderToEdit", this::orderToEdit);

    orderNumber = new SimpleStringProperty();
    menuItem = new SimpleStringProperty();
    comment = new SimpleStringProperty();
    dietaryNeeds = new SimpleStringProperty();
  }

  private void orderToEdit(PropertyChangeEvent event) {
    Order order;

    if (event.getNewValue() == null) {
      order = new Order(0,0,"","");
    } else {
      order = (Order) event.getNewValue();
    }

    Platform.runLater(() ->{
      orderNumber.set(Integer.toString(order.getOrderNumber()));
      menuItem.set(Integer.toString(order.getMenuItem()));
      comment.set(order.getComment());
      dietaryNeeds.set(order.getDietaryNeeds());
    });
  }

  public void updateOrder() {
    model.editOrder(new Order(Integer.parseInt(orderNumber.get()), Integer.parseInt(menuItem.get()), comment.get(), dietaryNeeds.get()));
  }

  public StringProperty orderNumberProperty() {
    return orderNumber;
  }

  public StringProperty menuItemProperty() {
    return menuItem;
  }

  public StringProperty commentProperty() {
    return comment;
  }

  public StringProperty dietaryNeedsProperty() {
    return dietaryNeeds;
  }
}
