package com.uno.client.model;

import com.uno.shared.transferobjects.MenuItem;

import java.util.ArrayList;

public interface MenuItems {

    /**
     * a method to retrieve menu items
     * @return retruns an ArrayList of menu items
     */

    ArrayList<MenuItem> getMenuItems();

}
