package com.uno.database.states.ordersstates;

import com.uno.database.DatabaseConnection;
import com.uno.database.DatabaseHandler;
import com.uno.shared.transferobjects.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * A class that updates objects from a database
 * @author Maximillian Wallin
 * @version 0.1.0
 */

public class EditOrderState implements DatabaseHandler {

  /**
   * A method that creates an update in order table in the database.
   * @param object The updated object that will be inserted in to database.
   */
  @Override public void sendToDatabase(Object object) {
    Order temp = (Order) object;

    try(Connection connection = DatabaseConnection.getInstance().getConnection()) {
      PreparedStatement statement =
          connection.prepareStatement("UPDATE Order SET MenuItem = ?, comment = ?, dietaryneeds = ? WHERE ordernumber = ?");
      statement.setInt(1, temp.getMenuItem());
      statement.setString(2, temp.getComment());
      statement.setString(3, temp.getDietaryNeeds());
      statement.setInt(4, temp.getOrderNumber());
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  /**
   * A method that creates and returns Order objects from order
   * table in the database
   * @return null
   */
  @Override public Object getFromDatabase() {
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
