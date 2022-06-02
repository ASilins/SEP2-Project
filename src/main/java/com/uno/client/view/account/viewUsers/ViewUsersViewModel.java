package com.uno.client.view.account.viewUsers;

import com.uno.client.model.AccountModel;
import com.uno.shared.transferobjects.Account;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.util.List;

/**
 * A class that controls view user and model
 */
public class ViewUsersViewModel {

  private AccountModel model;

  private ObservableList<Account> users;

  /**
   * A constructor that sets the model instance
   * @param model
   */
  public ViewUsersViewModel(AccountModel model) {
    this.model = model;
    model.addListener("Update", this::update);
  }

  /**
   * a method that clears the list and resets it
   * @param event The list that will be placed
   */
  private void update(PropertyChangeEvent event) {
    users.clear();
    users.addAll((List<Account>) event.getNewValue());
  }

  /**
   * A method that gets list of users from model
   */
  public void loadUsers() {
    List<Account> list = model.getUsers();
    users = FXCollections.observableArrayList(list);
  }

  /**
   * A method that sends an Account object to the model
   */
  public void editUser(Account account) {
    model.userToEdit(account);
  }

  /**
   * A method that returns an observable list of users
   * @return An observable list of users
   */
  public ObservableList<Account> getUsers() {
    return users;
  }
}
