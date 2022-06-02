package com.uno.client.networking;

import com.uno.shared.networking.MenuItemsClientCallBack;
import com.uno.shared.networking.MenuItemsServer;
import com.uno.shared.networking.Server;
import com.uno.shared.transferobjects.MenuItem;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * A class for menu items client
 * @author Ondrej Klimek
 * @version 0.1.0
 */

public class MenuItemsClientImpl implements MenuItemsClient, MenuItemsClientCallBack {

    private MenuItemsServer server;

    private PropertyChangeSupport support;

    /**
     * constructor for MenuItemsClientImpl class
     * @param server
     */

    public MenuItemsClientImpl(Server server){
        try {
            this.server = server.getMenuItemsServer();
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

    /**
     * get method to retrieve menu items
     * @return returns an array list with menu items
     */

    @Override
    public ArrayList<MenuItem> getMenuItems() {
        try {
            return server.getMenuItems();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void update() {
        support.firePropertyChange("Update", null, getMenuItems());
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
