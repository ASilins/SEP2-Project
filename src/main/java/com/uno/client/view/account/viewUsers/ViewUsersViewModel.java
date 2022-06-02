package com.uno.client.view.account.viewUsers;

import com.uno.client.model.AccountModel;
import com.uno.shared.transferobjects.Account;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class ViewUsersViewModel {

  private AccountModel model;

  private ObservableList<Account> users;

  public ViewUsersViewModel(AccountModel model) {
    this.model = model;
  }

  public void loadUsers() {
    List<Account> list = model.getUsers();
    users = FXCollections.observableArrayList(list);
  }

  public void editUser(Account account) {
    model.editUser(account);
  }

  public ObservableList<Account> getUsers() {
    return users;
  }
}
