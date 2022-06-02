package com.uno.client.view.order.editOrder;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * A method that controls edit order fxml
 * @author Arturs Silins
 * @version 1.0.0
 */

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

  /**
   * A method that initializes the view handler and view model factory
   */
  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
    viewModel = vmf.getEditOrderViewModel();
    this.viewHandler = viewHandler;

    orderNumber.textProperty().bindBidirectional(viewModel.orderNumberProperty());
    menuItem.textProperty().bindBidirectional(viewModel.menuItemProperty());
    comment.textProperty().bindBidirectional(viewModel.commentProperty());
    dietaryNeeds.textProperty().bindBidirectional(viewModel.dietaryNeedsProperty());
  }

  /**
   * Calls the view model update board
   */
  public void updateOrder() {
    viewModel.updateOrder();
    viewHandler.openManagerViewOrders();
  }

  /**
   * A method that opens the staff view order scene
   */
  public void cancel() {
    //Opens staff order view
  }

  /**
   * A method that opens tha manager view order scene
   */
  public void cancelManager() {
    viewHandler.openManagerViewOrders();
  }
}
