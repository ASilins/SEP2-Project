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

    /**
     * Update oldBooking object from database.
     * @param oldBooking The object that will be updated from the database.
     */

    void editTableBooking(Table oldBooking, Table newBooking);
}
