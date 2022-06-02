package com.uno.client.model;

import com.uno.shared.transferobjects.Table;
import com.uno.shared.util.Subject;
import java.rmi.RemoteException;
import java.util.List;

/**
 * An interface of a class for handling table items
 * @author Siddhartha Grasse, Bhupas Gautam
 * @version 0.2.0
 */

public interface Tables extends Subject {

    void createTable(Table table);

    void updateTable(Table table);

    /**
     * a method for booking tables
     * @throws RemoteException If it is not possible to receive the object.
     */
    void bookTable(Table table) throws RemoteException;

    /**
     * Method to edit table booking
     * @param newBooking sends the new information about table booking
     */
    void editTableBooking(Table newBooking);

    List<Table> getTables();

    void tableToEdit(Table table);
}
