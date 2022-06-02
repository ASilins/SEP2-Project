package com.uno.server.model;

import com.uno.database.Database;
import com.uno.shared.transferobjects.Table;

import java.util.List;

/**
 * A class that handles Table objects from the database to the client.
 * @author Siddhartha Grasse, Maximillian Wallin
 * @version 1.0.0
 */
public class TableHandlerImpl implements TableHandler{

    private Database database;

    /**
     * A constructor that takes database object and sets it to the instance.
     * @param database The object that will be in the object instance.
     */
    public TableHandlerImpl(Database database) {
        this.database = database;
    }

    /**
     * a method that creates a table
     * @param table takes a table as a parameter
     */

    @Override
    public void createTable(Table table) {
        database.createTable(table);
    }

    /**
     * a method that updates a table
     * @param table takes a table as a parameter
     */

    @Override
    public void updateTable(Table table) {
        database.updateTable(table);
    }

    /**
     * a method that retrieves tables
     * @return returns a list of tables
     */

    @Override
    public List<Table> getTables() {
        return database.getTables();
    }
}
