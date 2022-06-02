package com.uno.client.networking;

import com.uno.shared.networking.Server;
import com.uno.shared.networking.TableClientCallBack;
import com.uno.shared.networking.TableServer;
import com.uno.shared.transferobjects.Table;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * class for table client
 * @author Arturs Silins, Siddhartha Grasse, Bhupas Gautam
 * @version 1.0.0
 */

public class TableClientImpl implements TableClient, TableClientCallBack {

    private TableServer server;

    private PropertyChangeSupport support;

    /**
     * constructor for OrderClientImpl
     * @param server takes an order as a parameter
     */
    public TableClientImpl(Server server){
        try {
            this.server = server.getTableServer();
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        support = new PropertyChangeSupport(this);
    }

    public void registerClient() {
        try {
            server.registerClient(this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createTable(Table table) {
        try {
            server.createTable(table);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateTable(Table table) {
        try {
            server.updateTable(table);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
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

    /**
     * Method to edit the table booking
     * @param newBooking send out the information for new booking
     */
    @Override
    public void editTableBooking(Table newBooking) {
        try {
            server.editTableBooking(newBooking);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Table> getTables() {
        try {
            return server.getTables();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void update() {
        support.firePropertyChange("Update", null, getTables());
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
