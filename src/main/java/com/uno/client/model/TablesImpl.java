package com.uno.client.model;


import com.uno.client.networking.Client;
import com.uno.client.networking.TableClient;
import com.uno.shared.transferobjects.Table;

import java.rmi.RemoteException;


/**
 * A class for handling tables
 * @author Siddhartha Grasse
 * @version 0.1.0
 */

public class TablesImpl implements Tables{

    private TableClient tableClient;

    /**
     * a constructor for MenuItemsImpl
     * @param client takes a client as a parameter
     */

    public TablesImpl(Client client) {
        this.tableClient = client.getTableClient();
    }

    /**
     * a method to retrieve menu items
     * @return retrieves an ArrayList of menu items
     * @throws RemoteException If it is not possible to receive the object.
     */


    @Override
    public void bookTable(Table table) throws RemoteException {
        tableClient.bookTable(table);

    }
}
