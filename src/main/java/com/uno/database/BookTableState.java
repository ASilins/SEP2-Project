package com.uno.database;

import com.uno.shared.transferobjects.MenuItem;
import com.uno.shared.transferobjects.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that sends or takes objects from a database
 * @author Siddhartha Grasse
 * @version 0.2.0
 */
public class BookTableState implements DatabaseHandler {
    /**
     * a method that sends an object to the database
     * @param object The object that will be inserted in to database.
     */

    @Override
    public void sendToDatabase(Object object) {

    }

    /**
     * a method that returns null
     * @return null
     */

    @Override
    public Object getFromDatabase() {
        return null;
    }

    /**
     * a method that sends a list to the database
     * @param list That will be inserted.
     */

    @Override
    public void sendListToDatabase(Object list) {

    }

    /**
     * A method that takes creates objects from the Table table
     * from the database and returns them
     * @return A list of Table objects
     */
    @Override
    public Object getListFromDatabase() {
        List<Table> list = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getInstance().getConnection()) {
            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM table");
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                list.add(new Table(result.getInt(1), result.getInt(2), result.getBoolean(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
