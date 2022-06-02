package com.uno.client.view.account.createaccount;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * a class that controls the CreateAccount fxml file
 * @author Arturs Silins
 * @version 1.0.0
 */
public class CreateAccountController implements ViewController {

  private ViewHandler viewHandler;
  private CreateAccountViewModel viewModel;

  @FXML
  private TextField phoneNumber;
  @FXML
  private TextField name;
  @FXML
  private PasswordField password;

  /**
   * A method that initializes the view handler and view model factory
   */
  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
    this.viewHandler = viewHandler;
    this.viewModel = vmf.getCreateAccountViewModel();
    phoneNumber.textProperty().bindBidirectional(viewModel.phoneNumberProperty());
    name.textProperty().bindBidirectional(viewModel.nameProperty());
    password.textProperty().bindBidirectional(viewModel.passwordProperty());
  }

  /**
   * A method that creates the account
   */

  @FXML
  public void createAccount() {
    viewModel.createAccount();
    phoneNumber.clear();
    name.clear();
    password.clear();
    viewHandler.openLoginScene();

  }

  /**
   * A method that cancels the account creation and goes back to login scene
   */

  @FXML
  public void cancel() {
    viewHandler.openLoginScene();
  }
}
