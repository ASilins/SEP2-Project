package com.uno.shared.networking;

import com.uno.shared.transferobjects.Table;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * This interface is for Tables that handles only things associated with tables
 * @author Siddhartha Grasse, Maximillian Wallin
 * @version 0.2.0
 */
public interface TableServer extends Remote {

    /**
     * Method that creates a TableBooking object in database.
     * @param table The table that will be created in the database.
     * @throws RemoteException If it is not possible to receive the object.
     */
    void bookTable(Table table) throws RemoteException;

    /**
     * Method that updates a TableBooking object in the database.
     * @param oldBooking The table that will be updated in the database.
     * @throws RemoteException If it is not possible to receive the object.
     */
    void editTableBooking(Table oldBooking, Table newBooking)
        throws RemoteException;
}

