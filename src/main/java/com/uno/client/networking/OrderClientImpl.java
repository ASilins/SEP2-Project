package com.uno.client.networking;

import com.uno.shared.transferobjects.Order;

/**
 * class for order client
 * @author Ondrej Klimek
 * @version 0.1.0
 */
import java.util.ArrayList;

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

    /**
     * A method that takes from the server a list of order objects.
     * @return A list of order objects.
     */
    @Override
    public ArrayList<Order> getOrders() {
        return server.getOrders();
    }
}
