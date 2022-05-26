package com.uno.client.model;

import com.uno.client.networking.Client;
import com.uno.client.networking.OrderClient;
import com.uno.shared.transferobjects.Order;

/**
 * A class for making orders
 * @author Ondrej Klimek
 * @version 0.1.0
 */
import java.util.ArrayList;

public class MakeOrderImpl implements MakeOrder {

    private OrderClient orderClient;
    private Order oldOrder;

    /**
     * constructor for MakeOrderImpl class
     * @param client takes client as a parameter
     */

    public MakeOrderImpl(Client client) {
        this.orderClient = client.getOrderClient();
    }

    /**
     * method for creating an order
     * @param order takes order as a parameter
     */

    public void createOrder(Order order){
        orderClient.createOrder(order);
    }

    /**
     * A method that takes a list of order items from the
     * server and returns them.
     * @return A list of order objects.
     */
    @Override
    public ArrayList<Order> getOrders() {
        return orderClient.getOrders();
    }

    public void editOrder(Order oldOrder, Order newOrder) {
        this.oldOrder=oldOrder;
        oldOrder=newOrder;


}
