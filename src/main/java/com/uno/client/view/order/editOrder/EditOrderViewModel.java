package com.uno.client.view.order.editOrder;

import com.uno.client.model.MakeOrder;
import com.uno.shared.transferobjects.Order;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

/**
 *
 * @author Arturs Silins
 * @version 1.0.0
 */

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

  /**
   * returns the string property of the order number
   */
  public StringProperty orderNumberProperty() {
    return orderNumber;
  }

  /**
   * returns the string property of the menu item
   */
  public StringProperty menuItemProperty() {
    return menuItem;
  }

  /**
   * returns the string property of the comment
   */
  public StringProperty commentProperty() {
    return comment;
  }

  /**
   * returns the string property of the dietary needs
   */
  public StringProperty dietaryNeedsProperty() {
    return dietaryNeeds;
  }
}
