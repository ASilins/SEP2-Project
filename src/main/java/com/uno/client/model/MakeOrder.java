package com.uno.client.model;

import com.uno.shared.transferobjects.Order;

/**
 * An interface of a class for making orders
 * @author Ondrej Klimek
 * @version 0.1.0
 */

public interface MakeOrder {

    /**
     * a method for creating an order
     * @param order takes order as a parameter
     */
    void createOrder(Order order);

}
