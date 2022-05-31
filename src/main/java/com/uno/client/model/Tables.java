package com.uno.client.model;
import com.uno.shared.transferobjects.Order;
import com.uno.shared.transferobjects.Table;

import java.rmi.RemoteException;

/**
 * An interface of a class for handling table items
 * @author Siddhartha Grasse, Bhupas Gautam
 * @version 0.2.0
 */

public interface Tables {

    /**
     * a method for booking tables
     * @throws RemoteException If it is not possible to receive the object.
     */

    void bookTable(Table table) throws RemoteException;

    /**
     * Method to edit table booking
     * @param newBooking sends the new information about table booking
     */

    void editTableBooking(Table newBooking);


}
