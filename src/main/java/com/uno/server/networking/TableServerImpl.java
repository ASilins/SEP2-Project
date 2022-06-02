package com.uno.server.networking;

import com.uno.server.model.TableHandler;
import com.uno.shared.networking.TableServer;
import com.uno.shared.transferobjects.Table;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


/**
 * This class implements TableServer Interface. This server object handles
 * sending and receiving Table objects from client and server.
 * @author Siddhartha Grasse
 * @version 1.0.0
 */
public class TableServerImpl implements TableServer {

    private TableHandler handler;

    /**
     * Constructor that export instance and sets the instance for a class
     * that handles Table Objects in the server.
     * @param handler the Tablehandler
     */
    public TableServerImpl(TableHandler handler) {
        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.handler = handler;
    }

    /**
     * A method that creates the table in a database.
     *
     * @param table The table that will be created in the database.
     * @throws RemoteException If it is not possible to receive from client.
     */
    @Override
    public void bookTable(Table table) throws RemoteException {
        handler.bookTable(table);
    }


    @Override
    public void editTableBooking(Table newBooking) {
        handler.editTableBooking(newBooking);
    }
}