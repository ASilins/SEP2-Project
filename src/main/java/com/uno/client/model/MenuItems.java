package com.uno.client.model;

import com.uno.shared.transferobjects.MenuItem;

import java.util.ArrayList;

/**
 * An interface of a class for handling menu items
 * @author Ondrej Klimek
 * @version 0.1.0
 */

public interface MenuItems {

    /**
     * a method to retrieve menu items
     * @return returns an ArrayList of menu items
     */

    ArrayList<MenuItem> getMenuItems();

}
