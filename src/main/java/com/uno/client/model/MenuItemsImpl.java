package com.uno.client.model;

import com.uno.client.networking.Client;
import com.uno.client.networking.MenuItemsClient;
import com.uno.shared.transferobjects.MenuItem;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * A class for handling menu items
 * @author Ondrej Klimek
 * @version 0.1.0
 */

public class MenuItemsImpl implements MenuItems{

    private MenuItemsClient menuItemClient;

    private PropertyChangeSupport support;

    /**
     * a constructor for MenuItemsImpl
     * @param client takes a client as a parameter
     */

    public MenuItemsImpl(Client client) {
        try {
            this.menuItemClient = client.getMenuItemsClient();
            menuItemClient.registerClient();
            menuItemClient.addListener("Update", this::update);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        support = new PropertyChangeSupport(this);
    }

    private void update(PropertyChangeEvent event) {
        support.firePropertyChange("Update", null, event.getNewValue());
    }

    /**
     * a method to retrieve menu items
     * @return retrieves an ArrayList of menu items
     */

    @Override
    public ArrayList<MenuItem> getMenuItems() {
        //method body
        return menuItemClient.getMenuItems();
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
