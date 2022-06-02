package com.uno.client.view.account.viewUsers;

import com.uno.client.model.AccountModel;
import com.uno.shared.transferobjects.Account;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class ViewUsersViewModel {

  private AccountModel model;

  private ObservableList<Account> users;

  public ViewUsersViewModel(AccountModel model) {
    this.model = model;
    model.addListener("Update", this::update);
  }

  private void update(PropertyChangeEvent event) {
    users.clear();
    users.addAll((List<Account>) event.getNewValue());
  }

  public void loadUsers() {
    List<Account> list = model.getUsers();
    users = FXCollections.observableArrayList(list);
  }

  public void editUser(Account account) {
    model.userToEdit(account);
  }

  public ObservableList<Account> getUsers() {
    return users;
  }
}
