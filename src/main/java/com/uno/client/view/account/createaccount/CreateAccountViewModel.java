package com.uno.client.view.account.createaccount;

import com.uno.client.model.AccountModel;
import com.uno.shared.transferobjects.Account;
import com.uno.shared.util.PasswordHasher;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * A class that controls Create Account and model
 * @author Arturs Silins
 * @version 1.0.0
 */

public class CreateAccountViewModel {

  private AccountModel model;

  private StringProperty phoneNumber;
  private StringProperty name;
  private StringProperty password;

  /**
   * Constructor that sets instance of create account view model for the object.
   * @param model The object that gives the instance.
   */
  public CreateAccountViewModel(AccountModel model) {
    this.model = model;
    phoneNumber = new SimpleStringProperty();
    name = new SimpleStringProperty();
    password = new SimpleStringProperty();
  }

  /**
   * A method that creates and sends an Account object to the model
   */
  public void createAccount() {
    model.createAccount(new Account(phoneNumber.get(), name.get(), "Guest", PasswordHasher.hashPassword(password.get())));
  }
  /**
   * returns the string property of the phone number
   */
  public StringProperty phoneNumberProperty() {
    return phoneNumber;
  }

  /**
   * returns the string property of the name
   */
  public StringProperty nameProperty() {
    return name;
  }

  /**
   * returns the string property of the password
   */
  public StringProperty passwordProperty() {
    return password;
  }
}
