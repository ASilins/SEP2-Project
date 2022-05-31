package com.uno.client.networking;

import com.uno.client.model.MenuItems;
import com.uno.shared.networking.MenuItemsServer;
import com.uno.shared.networking.Server;
import com.uno.shared.transferobjects.MenuItem;

import java.rmi.RemoteException;
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

    public MenuItemsClientImpl(Server server){
        try {
            this.server = server.getMenuItemsServer();
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
}
