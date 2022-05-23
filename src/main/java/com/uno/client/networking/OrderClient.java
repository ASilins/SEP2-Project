package com.uno.client.networking;

import com.uno.shared.transferobjects.Order;

public interface OrderClient {

    /**
     * method to create an order
     * @param order takes an order as a parameter
     */

    void createOrder(Order order);

}
