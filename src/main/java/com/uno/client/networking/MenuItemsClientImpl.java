package com.uno.client.networking;

import com.uno.client.model.MenuItems;
import com.uno.shared.transferobjects.MenuItem;

import java.util.ArrayList;

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
