package com.uno.client.networking;

import com.uno.shared.transferobjects.Table;

import java.rmi.RemoteException;


/**
 * An interface for table client
 * @author Siddhartha Grasse
 * @version 0.2.0
 */
public interface TableClient {

    /**
     * Method to create a table booking
     * @param table takes a table as a parameter
     * @throws RemoteException If it is not possible to receive the object.
     */
    void bookTable(Table table) throws RemoteException;


}
