package com.uno.database;

import com.uno.shared.transferobjects.PreOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that sends and/or takes objects to/from the database
 * @author Ondrej Klimek
 * @version 0.2.0
 */

public class PreOrderState implements DatabaseHandler{

    /**
     * A method that creates a new entry in pre-order table in the database.
     * @param object The object that will be inserted in to database.
     */

    @Override
    public void sendToDatabase(Object object) {
        PreOrder temp = (PreOrder) object;

        try(Connection connection = DatabaseConnection.getInstance().getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement("INSERT INTO PreOrder(reservationNumber, orderNumber) values (?, ?)");
            statement.setInt(1, temp.getReservationNumber());
            statement.setInt(2, temp.getOrderNumber());
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
     * A method that creates and returns PreOrder objects from order
     * table in the database
     * @return A list of pre-order objects
     */

    @Override
    public Object getListFromDatabase() {
        List<PreOrder> list = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM PreOrder");
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                list.add(new PreOrder(result.getInt(1), result.getInt(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
