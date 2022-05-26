package com.uno.client.model;

import com.uno.shared.transferobjects.Order;

/**
 * An interface of a class for making orders
 * @author Ondrej Klimek
 * @version 0.1.0
 */

import java.util.ArrayList;
/**
 * An interface of a class for handling make order
 * @author Ondrej Klimek, Bhupas
 * @version 0.2.0
 */
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

    /**
     * A method for editing order
     * @param oldOrder takes the old order
     * @param newOrder replaces the old order with the new one
     */
    void editOrder( Order oldOrder, Order newOrder);

}
