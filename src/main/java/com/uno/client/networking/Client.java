package com.uno.client.networking;

import java.rmi.Remote;

/**
 * An interface of a class for handling clients
 * @author Ondrej Klimek, Siddhartha Grasse, Arturs Silins
 * @version 0.2.0
 */

public interface Client extends Remote {

    /**
     * a method that creates an order
     * @return Returns OrderClient
     */
    OrderClient getOrderClient();

    /**
     * a method to retrieve menu items from the server
     * @return returns an arrayList of menuItems
     */
    MenuItemsClient getMenuItemsClient();

    /**
     * a method to retrieve table items from the server
     * @return returns an arrayList of tables
     */
    TableClient getTableClient();

     /** A method that returns and/or creates account client instance.
     * @return An account client object
     */
    AccountClient getAccountClient();
}
