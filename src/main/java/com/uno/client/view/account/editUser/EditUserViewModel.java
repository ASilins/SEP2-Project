package com.uno.client.view.account.editUser;

import com.uno.client.model.AccountModel;
import com.uno.shared.transferobjects.Account;
import com.uno.shared.transferobjects.Reservation;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.sql.Timestamp;

public class EditUserViewModel {

  private AccountModel model;

  private StringProperty phoneNr;
  private StringProperty name;
  private StringProperty position;

  public EditUserViewModel(AccountModel model) {
    this.model = model;
    model.addListener("UserToEdit", this::userToEdit);

    phoneNr = new SimpleStringProperty();
    name = new SimpleStringProperty();
    position = new SimpleStringProperty();
  }

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

  public void updateUser() {
    model.editUser(new Account(phoneNr.get(), name.get(), position.get(), null));
  }

  public StringProperty phoneNrProperty() {
    return phoneNr;
  }

  public StringProperty nameProperty() {
    return name;
  }

  public StringProperty positionProperty() {
    return position;
  }
}
