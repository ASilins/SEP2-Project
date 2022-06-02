package com.uno.database.states;

import com.uno.database.DatabaseConnection;
import com.uno.database.DatabaseHandler;
import com.uno.shared.transferobjects.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * A class for editing reservations
 * @author Arturs Silins
 * @version 1.0.0
 */

public class EditReservationState implements DatabaseHandler {

  /**
   * A method that sends a reservation to the database
   * @param object The object that will be inserted in to database.
   */

  @Override
  public void sendToDatabase(Object object) {
    Reservation reservation = (Reservation) object;

    try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
      PreparedStatement statement =
          connection.prepareStatement("UPDATE \"Reservation\" SET customerNumber = ?, amountOfPeople = ?, "
              + "comment = ?, dietaryneeds = ?, table = ? WHERE reservationNumber = ?");
      statement.setString(1, reservation.getCustomerNumber());
      statement.setInt(3, reservation.getAmountOfPeople());
      statement.setString(3, reservation.getComment());
      statement.setString(4, reservation.getDietaryNeeds());
      statement.setInt(5, reservation.getTable());
      statement.setInt(6, reservation.getReservationNumber());
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
