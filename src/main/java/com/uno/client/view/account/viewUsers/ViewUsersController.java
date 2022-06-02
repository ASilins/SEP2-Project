package com.uno.client.view.account.viewUsers;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.view.ViewController;
import com.uno.shared.transferobjects.Account;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * A method that controls vies users fxml
 * @author Arturs Silins
 * @version 1.0.0
 */
public class ViewUsersController implements ViewController {

  private ViewHandler viewHandler;
  private ViewUsersViewModel viewModel;

  @FXML
  private TableView<Account> table;
  public TableColumn<String, Account> phoneNr;
  public TableColumn<String, Account> name;
  public TableColumn<String, Account> position;

  /**
   * A method that starts the controller
   * @param viewHandler An object that will be set in instance
   * @param vmf An object that will give an object for the instance
   */
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

  /**
   * A method that sends an account object that will edited
   */
  public void editUser() {
    viewModel.editUser(table.getSelectionModel().getSelectedItem());
    viewHandler.openEditUser();
  }

  /**
   * A method that changes the view to manager main menu
   */
  public void back() {
    viewHandler.openManagerMainMenu();
  }
}
