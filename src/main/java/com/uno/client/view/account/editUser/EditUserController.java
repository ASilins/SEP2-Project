package com.uno.client.view.account.editUser;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * A class that controls the editUser fxml fiel
 * @author Arturs Silins
 * @version 1.0.0
 */
public class EditUserController implements ViewController {

  private ViewHandler viewHandler;
  private EditUserViewModel viewModel;

  @FXML
  private TextField phoneNr;
  @FXML
  private TextField name;
  @FXML
  private TextField position;

  /**
   * A method that starts the controller
   * @param viewHandler An object that will be set in instance
   * @param vmf An object that will give an object for the instance
   */
  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
    viewModel = vmf.getEditUserViewModel();
    this.viewHandler = viewHandler;

    phoneNr.textProperty().bindBidirectional(viewModel.phoneNrProperty());
    name.textProperty().bindBidirectional(viewModel.nameProperty());
    position.textProperty().bindBidirectional(viewModel.positionProperty());
  }

  /**
   * A method that changes the view to View users scene
   */
  public void cancel() {
    viewHandler.openViewUsers();
  }

  /**
   * A method that calls an update method and
   * changes the scene to view users scene
   */
  public void updateUser() {
    viewModel.updateUser();
    phoneNr.clear();
    name.clear();
    position.clear();
    viewHandler.openViewUsers();
  }
}
