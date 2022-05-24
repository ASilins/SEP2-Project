package com.uno.client.networking;

import com.uno.shared.transferobjects.Order;

/**
 * An interface for order client
 * @author Ondrej Klimek
 * @version 0.1.0
 */

public interface OrderClient {

    /**
     * method to create an order
     * @param order takes an order as a parameter
     */

    void createOrder(Order order);

}
