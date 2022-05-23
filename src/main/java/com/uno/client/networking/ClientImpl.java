package com.uno.client.networking;

import com.uno.shared.transferobjects.Order;

import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientImpl implements Client{

    private Server server;
    private PropertyChangeSupport support;
    private MenuItemsClient mic;
    private OrderClient oc;

    /**
     * constructor for ClientImpl
     */

    public ClientImpl(){
        try {
            UnicastRemoteObject.exportObject(this, 0);
            support = new PropertyChangeSupport(this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * get method to retrieve an OrderClient
     * @return
     */

    @Override
    public OrderClient getOrderClient() {
        return this.oc;
    }

    /**
     * get method to retrieve a MenuItemsClient
     * @return
     */

    @Override
    public MenuItemsClient getMenuItemsClient() {
        return this.mic;
    }
}
