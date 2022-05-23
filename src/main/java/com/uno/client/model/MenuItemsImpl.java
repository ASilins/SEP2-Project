package com.uno.client.model;

import com.uno.client.networking.Client;
import com.uno.client.networking.MenuItemsClient;
import com.uno.shared.transferobjects.MenuItem;

import java.util.ArrayList;

public class MenuItemsImpl implements MenuItems{

    private MenuItemsClient menuItemClient;

    /**
     * a constructor for MenuItemsImpl
     * @param client takes a client as a parameter
     */

    public MenuItemsImpl(Client client) {
        this.menuItemClient = client.getMenuItemsClient();
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
