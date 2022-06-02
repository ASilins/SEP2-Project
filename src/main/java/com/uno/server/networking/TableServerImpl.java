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
 * @author Siddhartha Grasse, Arturs Silins
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

    /**
     * A method that registers the client in the server
     * @param client The object that is registered
     * @throws RemoteException If connection failed
     */
    public void registerClient(TableClientCallBack client) throws RemoteException {
        clients.add(client);
    }

    /**
     * A method that sends an update to all clients
     */
    private void update() {
        for (TableClientCallBack account : clients) {
            try {
                account.update();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * A method that sends table object to the server model
     * @param table The object that will be sent
     * @throws RemoteException If connection failed
     */
    @Override
    public void createTable(Table table) throws RemoteException {
        handler.createTable(table);
        update();
    }

    /**
     * A method that sends an edited table object
     * @param table The object that will be sent
     * @throws RemoteException If connection failed
     */
    @Override
    public void updateTable(Table table) throws RemoteException {
        handler.updateTable(table);
        update();
    }

    /**
     * Method that gets a list of tables from the server model
     * @return A list of table objects
     * @throws RemoteException If connection failed
     */
    @Override
    public List<Table> getTables() throws RemoteException {
        return handler.getTables();
    }
}