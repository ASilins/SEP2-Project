package com.uno.client.networking;

import com.uno.client.model.MenuItems;
import com.uno.shared.transferobjects.MenuItem;

import java.util.ArrayList;

/**
 * A class for menu items client
 * @author Ondrej Klimek
 * @version 0.1.0
 */

public class MenuItemsClientImpl implements MenuItemsClient{

    private MenuItemsServer server;
    private ArrayList<MenuItems> menuItems;

    /**
     * constructor for MenuItemsClientImpl class
     * @param server
     */

    public MenuItemsClientImpl(MenuItemsServer server){
        this.server = server;
    }

    /**
     * get method to retrieve menu items
     * @return returns an array list with menu items
     */

    @Override
    public ArrayList<MenuItem> getMenuItems() {
        return server.getMenuItems();
    }
}
