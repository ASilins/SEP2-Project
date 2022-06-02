package com.uno.client.model;


import com.uno.client.networking.Client;
import com.uno.client.networking.TableClient;
import com.uno.shared.transferobjects.Order;
import com.uno.shared.transferobjects.Table;

import java.rmi.RemoteException;


/**
 * A class for handling tables
 * @author Siddhartha Grasse, Bhupas Gautam
 * @version 1.0.0
 */

public class TablesImpl implements Tables{

    private TableClient tableClient;

    /**
     * a constructor for MenuItemsImpl
     * @param client takes a client as a parameter
     */

    public TablesImpl(Client client) {
        try {
            this.tableClient = client.getTableClient();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
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

    /**
     * Method to edit the table booking
     * @param newBooking send out the information for new booking
     */
    public void editTableBooking(Table newBooking) {
        tableClient.editTableBooking(newBooking);
    }}
