package com.uno.client.networking;

import com.uno.shared.transferobjects.Table;
import com.uno.shared.util.Subject;
import javafx.scene.Scene;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * An interface for table client
 * @author Siddhartha Grasse, Bhupas Gautam
 * @version 0.2.1
 */
public interface TableClient extends Subject {

    void createTable(Table table);

    void updateTable(Table table);

    /**
     * Method to create a table booking
     * @param table takes a table as a parameter
     * @throws RemoteException If it is not possible to receive the object.
     */
    void bookTable(Table table) throws RemoteException;

    /**
     * Method to edit table booking
     * @param newBooking sends the new information about table booking
     */

    void editTableBooking(Table newBooking);

    List<Table> getTables();

    void registerClient();
}
