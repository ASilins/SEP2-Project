package com.uno.database.states;

import com.uno.database.DatabaseConnection;
import com.uno.database.DatabaseHandler;
import com.uno.shared.transferobjects.Account;
import com.uno.shared.transferobjects.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that interacts with the database account table.
 *
 * @author Arturs Silins
 * @version 1.0.0
 */
public class AccountState implements DatabaseHandler {

  /**
   * A method that inserts account object in the database table.
   *
   * @param object The object that will be inserted in to database.
   */
  @Override
  public void sendToDatabase(Object object) {
    Account temp = (Account) object;

    try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
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
  public Object getFromDatabase(Object searchParameter) {
    try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
      PreparedStatement statement =
          connection.prepareStatement("SELECT * FROM \"User\" WHERE phoneNumber = ?;");
      statement.setString(1, (String) searchParameter);
      statement.execute();
      ResultSet result = statement.getResultSet();
      if (result.next()) {
        return new Account(result.getString(1), result.getString(2), result.getString(3), result.getString(4));
      } else {
        return null;
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return null;
  }

  @Override
  public void sendListToDatabase(Object list) {

  }

  @Override
  public Object getListFromDatabase() {
    List<Account> list = new ArrayList<>();

    try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
      PreparedStatement statement =
          connection.prepareStatement("SELECT * FROM \"User\"");
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        list.add(new Account(result.getString(1), result.getString(2), result.getString(3), null));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return list;
  }
}
