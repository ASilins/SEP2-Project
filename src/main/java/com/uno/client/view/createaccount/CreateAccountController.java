package com.uno.client.view.createaccount;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.model.AccountModel;
import com.uno.client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CreateAccountController implements ViewController {

  private ViewHandler viewHandler;
  private CreateAccountViewModel viewModel;

  @FXML
  private TextField phoneNumber;
  @FXML
  private TextField name;
  @FXML
  private PasswordField password;

  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
    this.viewHandler = viewHandler;
    this.viewModel = vmf.getCreateAccountViewModel();
    phoneNumber.textProperty().bindBidirectional(viewModel.phoneNumberProperty());
    name.textProperty().bindBidirectional(viewModel.nameProperty());
    password.textProperty().bindBidirectional(viewModel.passwordProperty());
  }

  @FXML
  public void createAccount() {
    viewModel.createAccount();
  }

  @FXML
  public void cancel() {
    viewHandler.openLoginScene();
  }
}
