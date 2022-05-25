package com.uno.client.model;
import com.uno.shared.transferobjects.Table;

import java.rmi.RemoteException;

/**
 * An interface of a class for handling table items
 * @author Siddhartha Grasse
 * @version 0.2.0
 */

public interface Tables {

    /**
     * a method to book tables
     * @throws RemoteException If it is not possible to receive the object.
     */

    void bookTable(Table table) throws RemoteException;

}
