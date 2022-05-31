package com.uno.client.view.createaccount;

import com.uno.client.model.AccountModel;
import com.uno.shared.transferobjects.Account;
import com.uno.shared.util.PasswordHasher;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CreateAccountViewModel {

  private AccountModel model;

  private StringProperty phoneNumber;
  private StringProperty name;
  private StringProperty password;

  public CreateAccountViewModel(AccountModel model) {
    this.model = model;
    phoneNumber = new SimpleStringProperty();
    name = new SimpleStringProperty();
    password = new SimpleStringProperty();
  }

  public void createAccount() {
    model.createAccount(new Account(phoneNumber.get(), name.get(), "Guest", PasswordHasher.hashPassword(password.get())));
  }

  public StringProperty phoneNumberProperty() {
    return phoneNumber;
  }

  public StringProperty nameProperty() {
    return name;
  }

  public StringProperty passwordProperty() {
    return password;
  }
}
