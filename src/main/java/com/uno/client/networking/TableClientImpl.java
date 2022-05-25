package com.uno.client.networking;

import com.uno.shared.networking.TableServer;
import com.uno.shared.transferobjects.Table;

import java.rmi.RemoteException;

/**
 * class for table client
 * @author Siddhartha Grasse
 * @version 0.2.0
 */

public class TableClientImpl implements TableClient{


    private TableServer server;

    /**
     * constructor for OrderClientImpl
     * @param server takes an order as a parameter
     */

    public TableClientImpl(TableServer server){
        this.server = server;
    }

    /**
     * Method to create a table booking
     * @param table takes a table as a parameter
     * @throws RemoteException If it is not possible to receive the object.
     */

    @Override
    public void bookTable(Table table) throws RemoteException {
        server.bookTable(table);

    }
}