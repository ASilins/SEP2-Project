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

    /**
     * A method that registers client to the server
     */
    public void registerClient() {
        try {
            server.registerClient(this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * A method that sends a Table object to the server
     * @param table The Table object that will be sent
     */
    @Override
    public void createTable(Table table) {
        try {
            server.createTable(table);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * A method that sends an edited Table object to the server
     * @param table The Table Object that will be sent
     */
    @Override
    public void updateTable(Table table) {
        try {
            server.updateTable(table);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * A method that takes a list of Table objects from the server
     * @return A list of Table objects
     */
    @Override
    public List<Table> getTables() {
        try {
            return server.getTables();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * A method that fires property change event
     */
    @Override
    public void update() {
        support.firePropertyChange("Update", null, getTables());
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
