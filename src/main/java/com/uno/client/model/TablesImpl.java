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
 * @author Siddhartha Grasse, Bhupas Gautam, Arturs Silins
 * @version 1.0.0
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

    /**
     * A method that fires a property change
     * @param event The property change event that was fired
     */
    private void update(PropertyChangeEvent event) {
        support.firePropertyChange("Update", null, event.getNewValue());
    }

    /**
     * A method that sends a Table object to the client
     * @param table The Table object that will be sent
     */
    @Override
    public void createTable(Table table) {
        tableClient.createTable(table);
    }

    /**
     * A method that sends an edited Table object to the client
     * @param table The Table Object that will be sent
     */
    @Override
    public void updateTable(Table table) {
        tableClient.updateTable(table);
    }

    /**
     * A method that takes a list of Table objects from the client
     * @return A list of Table objects
     */
    @Override
    public List<Table> getTables() {
        return tableClient.getTables();
    }

    /**
     * A method that holds and fires a property change with A table object
     * @param table The object that will be fired
     */
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

    /**
     * A method that adds property change listener
     * @param evtName The name of event it is waiting
     * @param lstnr An object that is listening
     */
    @Override
    public void addListener(String evtName, PropertyChangeListener lstnr) {
        support.addPropertyChangeListener(evtName, lstnr);
    }

    /**
     * A method that removes property change listener
     * @param evtName The name of the event it was waiting
     * @param lstnr An object that was listening
     */
    @Override
    public void removeListener(String evtName, PropertyChangeListener lstnr) {
        support.removePropertyChangeListener(evtName, lstnr);
    }
}
