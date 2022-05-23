package com.uno.client.networking;

import com.uno.shared.transferobjects.Order;

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
