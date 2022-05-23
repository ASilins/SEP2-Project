package com.uno.client.model;

import com.uno.shared.transferobjects.Order;

public interface MakeOrder {

    /**
     * a method for creating an order
     * @param order takes order as a parameter
     */
    void createOrder(Order order);

}
