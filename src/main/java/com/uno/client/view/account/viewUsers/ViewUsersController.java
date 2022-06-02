package com.uno.client.view.account.viewUsers;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.view.ViewController;
import com.uno.shared.transferobjects.Account;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewUsersController implements ViewController {

  private ViewHandler viewHandler;
  private ViewUsersViewModel viewModel;

  @FXML
  private TableView<Account> table;
  public TableColumn<String, Account> phoneNr;
  public TableColumn<String, Account> name;
  public TableColumn<String, Account> position;

  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
    viewModel = vmf.getViewUsersViewModel();
    this.viewHandler = viewHandler;

    viewModel.loadUsers();
    table.setItems(viewModel.getUsers());
    phoneNr.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
    name.setCellValueFactory(new PropertyValueFactory<>("name"));
    position.setCellValueFactory(new PropertyValueFactory<>("position"));
  }

  public void editUser() {
    viewModel.editUser(table.getSelectionModel().getSelectedItem());
  }

  public void back() {
    viewHandler.openManagerMainMenu();
  }
}
