package com.uno.client.model;

import com.uno.shared.transferobjects.MenuItem;
import com.uno.shared.util.Subject;

import java.util.ArrayList;

/**
 * An interface of a class for handling menu items
 * @author Ondrej Klimek
 * @version 0.1.0
 */

public interface MenuItems extends Subject {

    /**
     * a method to retrieve menu items
     * @return retruns an ArrayList of menu items
     */

    ArrayList<MenuItem> getMenuItems();

}
