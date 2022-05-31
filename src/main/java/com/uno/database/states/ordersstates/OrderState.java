package com.uno.database.states.ordersstates;

import com.uno.database.DatabaseConnection;
import com.uno.database.DatabaseHandler;
import com.uno.shared.transferobjects.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that sends or takes objects from a database
 * @author Arturs Silins
 * @version 0.1.0
 */
public class OrderState implements DatabaseHandler {

  /**
   * A method that creates a new entry in order table in the database.
   * @param object The object that will be inserted in to database.
   */
  @Override
  public void sendToDatabase(Object object) {
    Order temp = (Order) object;

    try(Connection connection = DatabaseConnection.getInstance().getConnection()) {
      PreparedStatement statement =
          connection.prepareStatement("INSERT INTO Order(menuitem, comment, dietaryneeds) values (?, ?, ?)");
      statement.setInt(1, temp.getMenuItem());
      statement.setString(2, temp.getComment());
      statement.setString(3, temp.getDietaryNeeds());
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

  /**
   * A method that creates and returns Order objects from order
   * table in the database
   * @return A list of order objects
   */
  @Override
  public Object getListFromDatabase() {
    List<Order> list = new ArrayList<>();
    try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
      PreparedStatement statement =
          connection.prepareStatement("SELECT * FROM Order");
      ResultSet result = statement.executeQuery();
      if (result.next()) {
        list.add(new Order(result.getInt(1), result.getInt(2), result.getString(3), result.getString(4)));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }
}
