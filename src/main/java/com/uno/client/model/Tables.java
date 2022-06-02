package com.uno.client.model;

import com.uno.shared.transferobjects.Table;
import com.uno.shared.util.Subject;
import java.rmi.RemoteException;
import java.util.List;

/**
 * An interface of a class for handling table items
 * @author Siddhartha Grasse, Bhupas Gautam, Arturs Silins
 * @version 1.0.0
 */
public interface Tables extends Subject {

    /**
     * A method that sends a Table object to the client
     * @param table The Table object that will be sent
     */
    void createTable(Table table);

    /**
     * A method that sends an edited Table object to the client
     * @param table The Table Object that will be sent
     */
    void updateTable(Table table);

    /**
     * A method that takes a list of Table objects from the client
     * @return A list of Table objects
     */
    List<Table> getTables();

    /**
     * A method that holds and fires a property change with A table object
     * @param table The object that will be fired
     */
    void tableToEdit(Table table);
}
