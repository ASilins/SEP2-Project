package com.uno.client.model;

import com.uno.shared.transferobjects.Order;

import java.util.ArrayList;

public interface MakeOrder {

    /**
     * a method for creating an order
     * @param order takes order as a parameter
     */
    void createOrder(Order order);

    /**
     * A method that returns a list of order objects.
     * @return A list of order objects
     */
    ArrayList<Order> getOrders();
}
