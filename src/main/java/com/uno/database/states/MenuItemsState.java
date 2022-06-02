package com.uno.database.states;

import com.uno.database.DatabaseConnection;
import com.uno.database.DatabaseHandler;
import com.uno.shared.transferobjects.MenuItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that sends or takes objects from a database
 * @author Arturs Silins
 * @version 1.0.0
 */
public class MenuItemsState implements DatabaseHandler {

  @Override
  public void sendToDatabase(Object object) {

  }

  @Override
  public Object getFromDatabase(Object searchParameter) {
    return null;
  }

  @Override
  public void sendListToDatabase(Object list) {

  }

  /**
   * A method that takes creates objects from the menu_item table
   * from the database and returns them
   * @return A list of MenuItem objects
   */
  @Override
  public Object getListFromDatabase() {
    List<MenuItem> list = new ArrayList<>();
    try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
      PreparedStatement statement =
          connection.prepareStatement("SELECT * FROM menu_item");
      ResultSet result = statement.executeQuery();
      if (result.next()) {
        list.add(new MenuItem(result.getInt(1), result.getString(2), result.getInt(3)));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }
}
