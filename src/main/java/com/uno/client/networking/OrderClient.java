package com.uno.client.networking;

import com.uno.shared.transferobjects.Order;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * An interface for Order client
 * @author Ondrej,Bhupas Gautam
 * @version 0.2.0
 */
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

    /**
     * a method to create a pre-order
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
