package com.uno.client.networking;

import com.uno.shared.transferobjects.MenuItem;

import java.util.ArrayList;

public interface MenuItemsClient {

    /**
     * method to retrieve menu items
     * @return returns an array list with menu items
     */

    ArrayList<MenuItem> getMenuItems();

}
