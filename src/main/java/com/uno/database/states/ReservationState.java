package com.uno.database.states;

import com.uno.database.DatabaseConnection;
import com.uno.database.DatabaseHandler;
import com.uno.shared.transferobjects.Order;
import com.uno.shared.transferobjects.Reservation;

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

public class ReservationState implements DatabaseHandler {

  /**
   * A method that creates a new entry in reservation table in the database.
   * @param object The object that will be inserted in to database.
   */

  @Override
  public void sendToDatabase(Object object) {
    Reservation temp = (Reservation) object;

    try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
      PreparedStatement statement =
          connection.prepareStatement("INSERT INTO Reservation(customerNumber, "
              + "date, amountOfPeople, Comment, DietaryNeeds, Table) values(?, ?, ?, ?, ?, ?)");
      statement.setString(1, temp.getCustomerNumber());
      statement.setLong(2, temp.getDate().getTime());
      statement.setInt(3, temp.getAmountOfPeople());
      statement.setString(4, temp.getComment());
      statement.setString(5, temp.getDietaryNeeds());
      statement.setInt(6, temp.getTable());
      statement.executeUpdate();
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
   * a method that gets a list of reservations from the database
   * @return returns a reservation list
   */

  @Override
  public Object getListFromDatabase() {
    List<Reservation> list = new ArrayList<>();
    try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
      PreparedStatement statement =
          connection.prepareStatement("SELECT * FROM \"Reservation\"");
      ResultSet result = statement.executeQuery();
      while (result.next()) {
        list.add(new Reservation(result.getInt(1), result.getString(2), null, result.getInt(4), result.getString(5), result.getString(6), result.getInt(7)));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return list;
  }
}
