package com.uno.shared.transferobjects;

/**
 * transferobject to use in the system
 * @author Siddhartha Grasse
 * @version 0.2.0
 */

public class Table {

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
     * method for retrieving the table number
     * @return tableNumber returns table number
     */
    public int getTableNumber()
    {
        return tableNumber;
    }

    /**
     * method for retrieving the capacity of the table
     * @return capacity returns the capacity of the table
     */

    public int getCapacity()
    {
        return capacity;
    }

    /**
     * method for retrieving the availability of the table
     * @return availability of that table
     */
    public boolean getAvailability()
    {
        return availability;
    }
}
