package com.uno.client.networking;

import com.uno.shared.transferobjects.Order;

/**
 * class for order client
 * @author Ondrej Klimek
 * @version 0.1.0
 */
import java.util.ArrayList;


/**
 * class for Order client
 * @author Ondrej,Bhupas Gautam
 * @version 0.2.0
 */

public class OrderClientImpl implements OrderClient{

    private Order order;
    private Order oldOrder;

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

    /**
     * A method to edit order
     * @param oldOrder takes the information from the old order
     * @param newOrder replaces the old order with the new order
     */
    @Override
    public void editOrder(Order oldOrder, Order newOrder) {
        this.oldOrder=oldOrder;
        oldOrder=newOrder;
    }
}
