package com.uno.client.view.account.editUser;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditUserController implements ViewController {

  private ViewHandler viewHandler;
  private EditUserViewModel viewModel;

  @FXML
  private TextField phoneNr;
  @FXML
  private TextField name;
  @FXML
  private TextField position;

  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
    viewModel = vmf.getEditUserViewModel();
    this.viewHandler = viewHandler;

    phoneNr.textProperty().bindBidirectional(viewModel.phoneNrProperty());
    name.textProperty().bindBidirectional(viewModel.nameProperty());
    position.textProperty().bindBidirectional(viewModel.positionProperty());
  }

  public void cancel() {
    viewHandler.openViewUsers();
  }

  public void updateUser() {
    viewModel.updateUser();
    phoneNr.clear();
    name.clear();
    position.clear();
    viewHandler.openViewUsers();
  }
}
