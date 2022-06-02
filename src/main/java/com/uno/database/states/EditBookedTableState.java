package com.uno.database.states;

import com.uno.database.DatabaseConnection;
import com.uno.database.DatabaseHandler;
import com.uno.shared.transferobjects.MenuItem;
import com.uno.shared.transferobjects.Order;
import com.uno.shared.transferobjects.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that updates objects from a database
 * @author Arturs Silins
 * @version 1.0.0
 */
public class EditBookedTableState implements DatabaseHandler
{

  /**
   * a method that sends an object to the database
   * @param object The object that will be inserted in to database.
   */

  @Override public void sendToDatabase(Object object)
  {
    Table temp = (Table) object;

    try(Connection connection = DatabaseConnection.getInstance().getConnection()) {
      PreparedStatement statement =
          connection.prepareStatement("UPDATE Reservation SET TableNumber = ?, Date = ?, TableCapacity = ? WHERE ReservationNumber = ?");
      statement.setInt(1, temp.getTableNumber());
//      statement.setInt(2, temp.getDate());
//      statement.setInt(3, temp.getTableCapacity());
//      statement.setInt(4, temp.getReservationNumber());

      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * A method that creates and returns booked table objects from tables
   * table in the database
   * @return null
   */

  @Override public Object getFromDatabase(Object searchParameter)
  {
    return null;
  }

  /**
   * a method that sends a list to the database
   *
   * @param list That will be inserted.
   */

  @Override public void sendListToDatabase(Object list)
  {

  }

  @Override public Object getListFromDatabase()
  {
    return null;
  }

}
