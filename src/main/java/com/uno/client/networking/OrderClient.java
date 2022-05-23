package com.uno.client.networking;

import com.uno.shared.transferobjects.Order;

import java.util.ArrayList;

public interface OrderClient {

    /**
     * method to create an order
     * @param order takes an order as a parameter
     */
    void createOrder(Order order);

    /**
     * A method that takes order objects from the server.
     * @return A list of order objects.
     */
    ArrayList<Order> getOrders();
}
