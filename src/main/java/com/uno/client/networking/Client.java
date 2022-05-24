package com.uno.client.networking;

/**
 * An interface of a class for handling clients
 * @author Ondrej Klimek
 * @version 0.1.0
 */

public interface Client {

    /**
     * a method that creates an order
     */

    OrderClient getOrderClient();

    /**
     * a method to retrieve menu items from the server
     * @return returns an arrayList of menuItems
     */

    MenuItemsClient getMenuItemsClient();

}
