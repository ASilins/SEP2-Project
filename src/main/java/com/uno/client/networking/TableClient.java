package com.uno.client.networking;

import com.uno.shared.transferobjects.Table;
import com.uno.shared.util.Subject;
import javafx.scene.Scene;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * An interface for table client
 * @author Siddhartha Grasse, Bhupas Gautam, Arturs Silins
 * @version 1.0.0
 */
public interface TableClient extends Subject {

    /**
     * A method that sends a Table object to the server
     * @param table The Table object that will be sent
     */
    void createTable(Table table);

    /**
     * A method that sends an edited Table object to the server
     * @param table The Table Object that will be sent
     */
    void updateTable(Table table);

    /**
     * A method that takes a list of Table objects from the server
     * @return A list of Table objects
     */
    List<Table> getTables();

    /**
     * A method that registers client to the server
     */
    void registerClient();
}
