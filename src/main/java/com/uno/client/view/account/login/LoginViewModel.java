package com.uno.client.view.account.login;

import com.uno.client.model.AccountModel;
import com.uno.shared.transferobjects.Account;
import com.uno.shared.util.PasswordHasher;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Arturs Silins
 * @version 1.0.0
 */

public class LoginViewModel {

  private AccountModel model;

  private StringProperty phoneNumber;
  private StringProperty password;
  private StringProperty errorText;

  /**
   * Constructor that sets instance of login view model for the object.
   * @param model The object that gives the instance.
   */

  public LoginViewModel(AccountModel model) {
    this.model = model;
    phoneNumber = new SimpleStringProperty();
    password = new SimpleStringProperty();
    errorText = new SimpleStringProperty();
  }

  public Account login() {
    Account account = model.login(phoneNumber.get(), PasswordHasher.hashPassword(password.get()));
    
    if (account == null) {
      errorText.set("Password and/or phone number is incorrect");
      return null;
    }
    
    return account;
  }

  /**
   * returns the string property of the phone number
   */
  public StringProperty phoneNumberProperty() {
    return phoneNumber;
  }
  /**
   * returns the string property of the password
   */
  public StringProperty passwordProperty() {
    return password;
  }
  /**
   * returns the string property of the error text
   */
  public StringProperty errorTextProperty() {
    return errorText;
  }
}
