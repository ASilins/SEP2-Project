package com.uno.database.states;

import com.uno.database.DatabaseConnection;
import com.uno.database.DatabaseHandler;
import com.uno.shared.transferobjects.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * A class for editing tables
 * @author Arturs Silins
 * @version 1.0.0
 */

public class EditTableState implements DatabaseHandler {

  /**
   * a method that sends the table object to the database
   * @param object The object that will be inserted in to database.
   */

  @Override
  public void sendToDatabase(Object object) {
    Table table = (Table) object;

    try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
      PreparedStatement statement = connection.prepareStatement("UPDATE \"Table\" SET capacity = ? WHERE tablenumber = ?");
      statement.setInt(1, table.getCapacity());
      statement.setInt(2, table.getTableNumber());
      statement.execute();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
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
