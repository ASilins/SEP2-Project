package com.uno.client.networking;

import com.uno.shared.transferobjects.MenuItem;
import com.uno.shared.util.Subject;

import java.util.ArrayList;

/**
 * An interface for menu items client
 * @author Ondrej Klimek
 * @version 1.0.0
 */
public interface MenuItemsClient extends Subject {

    /**
     * method to retrieve menu items
     * @return returns an array list with menu items
     */
    ArrayList<MenuItem> getMenuItems();

    /**
     * A method that registers the client to the server
     */
    void registerClient();
}
