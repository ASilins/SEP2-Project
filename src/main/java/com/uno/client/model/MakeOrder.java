package com.uno.client.model;

import com.uno.shared.transferobjects.Order;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * An interface of a class for handling make order
 * @author Ondrej Klimek, Bhupas, Arturs Silins
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
     * a method for creating a pre-order
     * @param order takes order as the first of the two parameters
     * @param reservation takes reservation as the second of the two parameters
     */
    void createPreOrder(Order order, Reservation reservation);

     /** A method for editing order
     * @param oldOrder takes the old order
     * @param newOrder replaces the old order with the new one
     */
    void editOrder( Order oldOrder, Order newOrder);
}
