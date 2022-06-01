package com.uno.client.view.order.editOrder;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditOrderController implements ViewController {

  private ViewHandler viewHandler;
  private EditOrderViewModel viewModel;

  @FXML
  private TextField orderNumber;
  @FXML
  private TextField menuItem;
  @FXML
  private TextField comment;
  @FXML
  private TextField dietaryNeeds;

  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
    viewModel = vmf.getEditOrderViewModel();
    this.viewHandler = viewHandler;

    orderNumber.textProperty().bindBidirectional(viewModel.orderNumberProperty());
    menuItem.textProperty().bindBidirectional(viewModel.menuItemProperty());
    comment.textProperty().bindBidirectional(viewModel.commentProperty());
    dietaryNeeds.textProperty().bindBidirectional(viewModel.dietaryNeedsProperty());
  }

  public void updateOrder() {
    viewModel.updateOrder();
  }

  public void cancel() {
    //Opens staff order view
  }

  public void cancelManager() {
    //Opens manager order view
  }
}
