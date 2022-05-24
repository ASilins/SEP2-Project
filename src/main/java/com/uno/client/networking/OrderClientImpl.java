package com.uno.client.networking;

import com.uno.shared.transferobjects.Order;

/**
 * class for order client
 * @author Ondrej Klimek
 * @version 0.1.0
 */

public class OrderClientImpl implements OrderClient{

    private Order order;

    /**
     * constructor for OrderClientImpl
     * @param order takes an order as a parameter
     */

    public OrderClientImpl(Order order){
        this.order = order;
    }

    /**
     * method to create an order
     * @param order takes an order as a parameter
     */

    @Override
    public void createOrder(Order order) {
        server.createOrder(order);
    }
}
