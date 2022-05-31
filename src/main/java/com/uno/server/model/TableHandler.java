package com.uno.server.model;

import com.uno.shared.transferobjects.Table;

/**
 * An interface that is used to send and receive Table objects
 * using these methods.
 * @author Siddhartha Grasse, Maximillian Wallin
 * @version 0.2.0
 */
public interface TableHandler {

    /**
     * Send table object to the database.
     * @param table The object that will be sent to the database.
     */
    void bookTable(Table table);

    void editTableBooking(Table newBooking);
}
