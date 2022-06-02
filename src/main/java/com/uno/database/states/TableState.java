package com.uno.database.states;

import com.uno.database.DatabaseConnection;
import com.uno.database.DatabaseHandler;
import com.uno.shared.transferobjects.Reservation;
import com.uno.shared.transferobjects.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * A class for table state
 * @author Arturs Silins
 * @version 1.0.0
 */

public class TableState implements DatabaseHandler {

  /**
   * a method that sends a table object to the database
   * @param object The object that will be inserted in to database.
   */

  @Override
  public void sendToDatabase(Object object) {
    Table table = (Table) object;

    try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
      PreparedStatement statement = connection.prepareStatement("INSERT INTO \"Table\" VALUES (?, ?, ?)");
      statement.setInt(1, table.getTableNumber());
      statement.setInt(2, table.getCapacity());
      statement.setBoolean(3, table.getAvailability());
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

  /**
   * a method that retrieves a list of tables from the database
   * @return returns a table list
   */

  @Override
  public Object getListFromDatabase() {
    List<Table> list = new ArrayList<>();

    try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
      PreparedStatement statement =
          connection.prepareStatement("SELECT * FROM \"Table\"");
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        list.add(new Table(result.getInt(1), result.getInt(2), result.getBoolean(3)));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return list;
  }
}
