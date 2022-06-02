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

    @Override
    public void createTable(Table table) {
        database.createTable(table);
    }

    @Override
    public void updateTable(Table table) {
        database.updateTable(table);
    }

    /**
     * A method that sends table object to the database.
     * @param table The object that will be sent to the database
     */
    @Override
    public void bookTable(Table table) {
        database.bookTable(table);
    }

    @Override
    public void editTableBooking(Table newBooking) {

    }

    @Override
    public List<Table> getTables() {
        return database.getTables();
    }
}
