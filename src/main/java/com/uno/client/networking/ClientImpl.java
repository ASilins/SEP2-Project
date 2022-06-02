package com.uno.client.networking;

import com.uno.shared.networking.Server;
import com.uno.shared.transferobjects.Order;
import com.uno.shared.transferobjects.Reservation;

import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * A class that handles clients
 * @author Ondrej Klimek, Siddhartha Grasse, Arturs Silins
 * @version 1.0.0
 */

public class ClientImpl implements Client {

    private Server server;
    private PropertyChangeSupport support;

    private MenuItemsClient mic;
    private OrderClient oc;
    private TableClient tc;
    private AccountClient ac;
    private ReservationClient rc;

    /**
     * constructor for ClientImpl
     */
    public ClientImpl(){
        try {
            UnicastRemoteObject.exportObject(this, 0);
            startClient();
            support = new PropertyChangeSupport(this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * A method that finds the server on the registery
     */
    public void startClient() {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 22222);
            server = (Server) registry.lookup("Server");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * get method to retrieve an OrderClient
     * @return order client
     */
    @Override
    public OrderClient getOrderClient() {
        if (oc == null) {
            oc = new OrderClientImpl(server);
        }
        
        return oc;
    }

    /**
     * get method to retrieve a MenuItemsClient
     * @return menu item client
     */
    @Override
    public MenuItemsClient getMenuItemsClient() {
        if (mic == null) {
            mic = new MenuItemsClientImpl(server);
        }

        return mic;
    }

    /**
     * get method to retrieve a TableClient
     * @return a tableClient
     */
    @Override
    public TableClient getTableClient() {
        if (tc == null) {
            tc = new TableClientImpl(server);
        }

        return tc;
    }

     /**
      * A method that returns and/or creates account client object.
     * @return An account client object
     */
    @Override
    public AccountClient getAccountClient() {
        if (ac == null) {
            ac = new AccountClientImpl(server);
        }

        return ac;
    }

    /**
     * A method that returns and/or creates reservation client object.
     * @return reservation client object
     */
    @Override
    public ReservationClient getReservationClient() {
        if (rc == null) {
            rc = new ReservationClientImpl(server);
        }

        return rc;
    }
}
