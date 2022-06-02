package com.uno.shared.networking;

import com.uno.shared.transferobjects.Table;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * This interface is for Tables that handles only things associated with tables
 * @author Siddhartha Grasse, Maximillian Wallin, Arturs Silins
 * @version 1.0.0
 */
public interface TableServer extends Remote {

    /**
     * A method that registers the client in the server
     * @param client The object that is registered
     * @throws RemoteException If connection failed
     */
    void registerClient(TableClientCallBack client) throws RemoteException;

    /**
     * A method that sends table object to the server model
     * @param table The object that will be sent
     * @throws RemoteException If connection failed
     */
    void createTable(Table table) throws RemoteException;

    /**
     * A method that sends an edited table object
     * @param table The object that will be sent
     * @throws RemoteException If connection failed
     */
    void updateTable(Table table) throws RemoteException;

    /**
     * Method that gets a list of tables from the server model
     * @return A list of table objects
     * @throws RemoteException If connection failed
     */
    List<Table> getTables() throws RemoteException;
}