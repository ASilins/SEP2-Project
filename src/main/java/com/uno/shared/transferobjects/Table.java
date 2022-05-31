package com.uno.shared.transferobjects;

import java.io.Serializable;

/**
 * transferobject to use in the system
 * @author Siddhartha Grasse
 * @version 0.2.0
 */

public class Table implements Serializable {

    private int tableNumber;
    private int capacity;
    private boolean availability;
    /**
     * Constructor that creates a transferobject of table
     *
     * @param tableNumber, the number of that particular table
     * @param capacity, the capacity of that particular table
     * @param availability, returns true if the table is available
     */

    public Table(int tableNumber, int capacity, boolean availability)
    {
        this.tableNumber = tableNumber;
        this.capacity=capacity;
        this.availability=availability;


    }

    /**
     * method that returns the table number
     * @return tablenumber
     */
    public int getTableNumber()
    {
        return tableNumber;
    }

    /**
     * method that returns the capacity of that table
     * @return capacity of that table
     */

    public int getCapacity()
    {
        return capacity;
    }

    /**
     * returns availability of that table
     * @return availability of that table
     */
    public boolean getAvailability()
    {
        return availability;
    }
}
