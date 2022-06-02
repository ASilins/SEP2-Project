package com.uno.server.networking;

import com.uno.server.model.TableHandler;
import com.uno.shared.networking.AccountClientCallBack;
import com.uno.shared.networking.TableClientCallBack;
import com.uno.shared.networking.TableServer;
import com.uno.shared.transferobjects.Table;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements TableServer Interface. This server object handles
 * sending and receiving Table objects from client and server.
 * @author Siddhartha Grasse
 * @version 1.0.0
 */
public class TableServerImpl implements TableServer {

    private TableHandler handler;
    private List<TableClientCallBack> clients;

    /**
     * Constructor that export instance and sets the instance for a class
     * that handles Table Objects in the server.
     * @param handler the Tablehandler
     */
    public TableServerImpl(TableHandler handler) throws RemoteException {
        try {
            UnicastRemoteObject.exportObject(this, 0);
            clients = new ArrayList<>();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.handler = handler;

    }

    public void registerClient(TableClientCallBack client) throws RemoteException {
        clients.add(client);
    }

    private void update() {
        for (TableClientCallBack account : clients) {
            try {
                account.update();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void createTable(Table table) throws RemoteException {
        handler.createTable(table);
        update();
    }

    @Override
    public void updateTable(Table table) throws RemoteException {
        handler.updateTable(table);
        update();
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

    @Override
    public List<Table> getTables() throws RemoteException {
        return handler.getTables();
    }
}