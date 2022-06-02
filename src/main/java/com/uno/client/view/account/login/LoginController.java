package com.uno.client.view.account.login;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.view.ViewController;
import com.uno.shared.transferobjects.Account;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * A method that controls login fxml
 * @author Arturs Silins
 * @version 1.0.0
 */

public class LoginController implements ViewController {

  private ViewHandler viewHandler;
  private LoginViewModel viewModel;

  @FXML
  private TextField phoneNumber;
  @FXML
  private PasswordField password;
  @FXML
  private Label errorText;

  /**
   * A method that initializes the view handler and view model factory
   */
  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
    this.viewModel = vmf.getLoginViewModel();
    this.viewHandler = viewHandler;

    phoneNumber.textProperty().bindBidirectional(viewModel.phoneNumberProperty());
    password.textProperty().bindBidirectional(viewModel.passwordProperty());
    errorText.textProperty().bindBidirectional(viewModel.errorTextProperty());
  }

  /**
   * A method that logins the user and changes to the correct view
   */
  @FXML
  public void login() {
    Account login = viewModel.login();

    if (login != null) {
      switch (login.getPosition()) {
        case "Guest":
          viewHandler.openMainMenu();
          break;
        case "Staff":
          viewHandler.openStaffMainMenu();
          break;
        case "Manager":
        case "Admin":
          viewHandler.openManagerMainMenu();
          break;
      }
    }
  }

  /**
   * A method that opens create account scene
   */
  @FXML
  public void createAccount() {
    viewHandler.openCreateAccountScene();
  }
}
