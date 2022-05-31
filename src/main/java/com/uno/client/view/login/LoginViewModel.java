package com.uno.client.view.login;

import com.uno.client.model.AccountModel;
import com.uno.shared.transferobjects.Account;
import com.uno.shared.util.PasswordHasher;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel {

  private AccountModel model;

  private StringProperty phoneNumber;
  private StringProperty password;
  private StringProperty errorText;

  public LoginViewModel(AccountModel model) {
    this.model = model;
    phoneNumber = new SimpleStringProperty();
    password = new SimpleStringProperty();
    errorText = new SimpleStringProperty();
  }

  public boolean login() {
    Account account = model.login(phoneNumber.get(), PasswordHasher.hashPassword(password.get()));

    if (account == null) {
      
    }

    return false;
  }

  public StringProperty phoneNumberProperty() {
    return phoneNumber;
  }

  public StringProperty passwordProperty() {
    return password;
  }

  public StringProperty errorTextProperty() {
    return errorText;
  }
}
