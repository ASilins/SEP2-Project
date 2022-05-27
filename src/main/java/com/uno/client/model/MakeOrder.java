package com.uno.client.model;

import com.uno.shared.transferobjects.Order;

/**
 * An interface of a class for making orders
 * @author Ondrej Klimek, Arturs Silins
 * @version 0.1.0
 */

import java.rmi.RemoteException;
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

    /**
     * a method for creating a pre-order
     * @param order takes order as the first of the two parameters
     * @param reservation takes reservation as the second of the two parameters
     */
    void createPreOrder(Order order, Reservation reservation);
}
