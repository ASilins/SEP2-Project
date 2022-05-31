package com.uno.client.model;

import com.uno.client.networking.Client;
import com.uno.client.networking.MenuItemsClient;
import com.uno.shared.transferobjects.MenuItem;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * A class for handling menu items
 * @author Ondrej Klimek
 * @version 0.1.0
 */

public class MenuItemsImpl implements MenuItems{

    private MenuItemsClient menuItemClient;

    /**
     * a constructor for MenuItemsImpl
     * @param client takes a client as a parameter
     */

    public MenuItemsImpl(Client client) {
        try {
            this.menuItemClient = client.getMenuItemsClient();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
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
}
