package com.uno.server.model;

import com.uno.shared.transferobjects.Table;

import java.util.List;

/**
 * An interface that is used to send and receive Table objects
 * using these methods.
 * @author Siddhartha Grasse, Maximillian Wallin
 * @version 1.0.0
 */
public interface TableHandler {

    /**
     * a method that creates a table
     * @param table takes a table as a parameter
     */

    void createTable(Table table);

    /**
     * a method that updates a table
     * @param table takes a table as a parameter
     */

    void updateTable(Table table);

    /**
     * a method that retrieves tables
     * @return returns a list of tables
     */

    List<Table> getTables();
}
