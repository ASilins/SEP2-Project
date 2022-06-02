package com.uno.database.states;

import com.uno.database.DatabaseConnection;
import com.uno.database.DatabaseHandler;
import com.uno.shared.transferobjects.Account;
import com.uno.shared.transferobjects.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditAccountState implements DatabaseHandler {

  @Override
  public void sendToDatabase(Object object) {
    Account account = (Account) object;

    try(Connection connection = DatabaseConnection.getInstance().getConnection()) {
      PreparedStatement statement =
          connection.prepareStatement("UPDATE \"User\" SET position = ?, name = ? WHERE phonenumber = ?");
      statement.setString(1, account.getPosition());
      statement.setString(2, account.getName());
      statement.setString(3, account.getPhoneNumber());
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Object getFromDatabase(Object searchParameter) {
    return null;
  }

  @Override
  public void sendListToDatabase(Object list) {

  }

  @Override
  public Object getListFromDatabase() {
    return null;
  }
}
