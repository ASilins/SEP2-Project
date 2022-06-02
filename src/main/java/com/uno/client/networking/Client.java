package com.uno.client.networking;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * An interface of a class for handling clients
 * @author Ondrej Klimek, Siddhartha Grasse, Arturs Silins
 * @version 1.0.0
 */

public interface Client extends Remote {

    /**
     * a method that creates an order
     * @return OrderClient
     */
    OrderClient getOrderClient() throws RemoteException;

    /**
     * a method to retrieve menu items from the server
     * @return an arrayList of menuItems
     */
    MenuItemsClient getMenuItemsClient() throws RemoteException;

    /**
     * a method to retrieve table items from the server
     * @return an arrayList of tables
     */
    TableClient getTableClient() throws RemoteException;

     /** A method that returns and/or creates account client instance.
     * @return An account client object
     */
    AccountClient getAccountClient() throws RemoteException;

    /** A method that returns and/or creates reservation client instance.
     * @return reservation client object
     */

    ReservationClient getReservationClient() throws RemoteException;
}
