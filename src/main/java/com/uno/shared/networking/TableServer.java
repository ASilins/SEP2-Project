package com.uno.shared.networking;

import com.uno.shared.transferobjects.Table;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * This interface is for Tables that handles only things associated with tables
 * @author Siddhartha Grasse, Maximillian Wallin
 * @version 0.2.0
 */
public interface TableServer extends Remote {

    void createTable(Table table) throws RemoteException;

    void updateTable(Table table) throws RemoteException;

    /**
     * Method that creates a TableBooking object in database.
     * @param table The table that will be created in the database.
     * @throws RemoteException If it is not possible to receive the object.
     */
    void bookTable(Table table) throws RemoteException;

    void editTableBooking(Table newBooking);

    List<Table> getTables() throws RemoteException;
}