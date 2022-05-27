package com.uno.client.model;


import com.uno.client.networking.Client;
import com.uno.client.networking.TableClient;
import com.uno.shared.transferobjects.Order;
import com.uno.shared.transferobjects.Table;

import java.rmi.RemoteException;


/**
 * A class for handling tables
 * @author Siddhartha Grasse, Bhupas
 * @version 0.2.0
 */

public class TablesImpl implements Tables{

    private TableClient tableClient;
    private Table oldBooking;

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

    /**
     * @param oldOrder
     * @param newOrder
     */
    @Override
    public void editOrder(Order oldOrder, Order newOrder) {

    }
    /**
     * Method to edit the table booking
     * @param oldBooking takes the information form old booking
     * @param newBooking send out the information for new booking
     */
    public void editTableBooking(Table oldBooking, Table newBooking) {
        this.oldBooking = oldBooking;
        oldBooking = newBooking;
    }}