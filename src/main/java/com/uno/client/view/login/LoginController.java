package com.uno.client.view.login;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.model.AccountModel;
import com.uno.client.view.ViewController;
import com.uno.shared.transferobjects.Account;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements ViewController {

  private ViewHandler viewHandler;
  private LoginViewModel viewModel;

  @FXML
  private TextField phoneNumber;
  @FXML
  private PasswordField password;
  @FXML
  private Label errorText;

  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
    this.viewModel = vmf.getLoginViewModel();
    this.viewHandler = viewHandler;

    phoneNumber.textProperty().bindBidirectional(viewModel.phoneNumberProperty());
    password.textProperty().bindBidirectional(viewModel.passwordProperty());
    errorText.textProperty().bindBidirectional(viewModel.errorTextProperty());
  }

  @FXML
  public void login() {
    boolean login = viewModel.login();

    if(login) {
      //Opens main menu.
    }
  }

  @FXML
  public void createAccount() {
    viewHandler.openCreateAccountScene();
  }
}
