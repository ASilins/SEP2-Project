package com.uno.client.model;


import com.uno.client.networking.Client;
import com.uno.client.networking.TableClient;
import com.uno.shared.transferobjects.Order;
import com.uno.shared.transferobjects.Table;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.util.List;

/**
 * A class for handling tables
 * @author Siddhartha Grasse, Bhupas
 * @version 0.2.0
 */

public class TablesImpl implements Tables{

    private TableClient tableClient;

    private PropertyChangeSupport support;

    /**
     * a constructor for MenuItemsImpl
     * @param client takes a client as a parameter
     */

    public TablesImpl(Client client) {
        try {
            this.tableClient = client.getTableClient();
            tableClient.registerClient();
            tableClient.addListener("Update", this::update);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        support = new PropertyChangeSupport(this);
    }

    private void update(PropertyChangeEvent event) {
        support.firePropertyChange("Update", null, event.getNewValue());
    }

    @Override
    public void createTable(Table table) {
        tableClient.createTable(table);
    }

    @Override
    public void updateTable(Table table) {
        tableClient.updateTable(table);
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
    }

    @Override
    public List<Table> getTables() {
        return tableClient.getTables();
    }

    @Override
    public void tableToEdit(Table table) {
        new Thread(() -> {
            try {
                Thread.sleep(250);
                support.firePropertyChange("TableToUpdate", null, table);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public void addListener(String evtName, PropertyChangeListener lstnr) {
        support.addPropertyChangeListener(evtName, lstnr);
    }

    @Override
    public void removeListener(String evtName, PropertyChangeListener lstnr) {
        support.removePropertyChangeListener(evtName, lstnr);
    }
}
