package com.uno.database.states;

import com.uno.database.DatabaseConnection;
import com.uno.database.DatabaseHandler;
import com.uno.shared.transferobjects.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReservationState implements DatabaseHandler {
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
      statement.setInt(6, temp.getTable().getTableNumber());
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

  @Override
  public Object getListFromDatabase() {
    return null;
  }
}
