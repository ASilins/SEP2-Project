package com.uno.database.states;

import com.uno.database.DatabaseConnection;
import com.uno.database.DatabaseHandler;
import com.uno.shared.transferobjects.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * A class that interacts with the database account table.
 * @author Arturs Silins
 * @version 0.2.0
 */
public class AccountState implements DatabaseHandler {

  /**
   * A method that inserts account object in the database table.
   * @param object The object that will be inserted in to database.
   */
  @Override
  public void sendToDatabase(Object object) {
    Account temp = (Account) object;

    try(Connection connection = DatabaseConnection.getInstance().getConnection()) {
      PreparedStatement statement =
          connection.prepareStatement("INSERT INTO \"User\"(phonenumber, name, position, password) VALUES (?, ?, ?, ?);");
      statement.setString(1, temp.getPhoneNumber());
      statement.setString(2, temp.getName());
      statement.setString(3, "Guest");
      statement.setString(4, temp.getPassword());
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Object getFromDatabase() {
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
