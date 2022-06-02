package com.uno.client.view.account.editUser;

import com.uno.client.model.AccountModel;
import com.uno.shared.transferobjects.Account;
import com.uno.shared.transferobjects.Reservation;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.sql.Timestamp;

/**
 * A method that controls edit user controller and model
 * @author Arturs Silins
 * @version 1.0.0
 */
public class EditUserViewModel {

  private AccountModel model;

  private StringProperty phoneNr;
  private StringProperty name;
  private StringProperty position;

  /**
   * A constructor that sets the instance of the model
   */
  public EditUserViewModel(AccountModel model) {
    this.model = model;
    model.addListener("UserToEdit", this::userToEdit);

    phoneNr = new SimpleStringProperty();
    name = new SimpleStringProperty();
    position = new SimpleStringProperty();
  }

  /**
   * A method that sets the info that will be edited
   * @param event The property change event
   */
  private void userToEdit(PropertyChangeEvent event) {
    Account account;

    if (event.getNewValue() == null) {
      account = new Account("", "", "", null);
    } else {
      account = (Account) event.getNewValue();
    }

    Platform.runLater(() -> {
      phoneNr.set(account.getPhoneNumber());
      name.set(account.getName());
      position.set(account.getPosition());
    });
  }

  /**
   * A method that creates and send an Account object to model
   */
  public void updateUser() {
    model.editUser(new Account(phoneNr.get(), name.get(), position.get(), null));
  }

  /**
   * A method that return String property for phoneNr
   * @return String property
   */
  public StringProperty phoneNrProperty() {
    return phoneNr;
  }

  /**
   * A method that return String property for name
   * @return String property
   */
  public StringProperty nameProperty() {
    return name;
  }

  /**
   * A method that return String property for position
   * @return String property
   */
  public StringProperty positionProperty() {
    return position;
  }
}
