package com.uno.client.networking;

import com.uno.shared.transferobjects.Order;

import java.util.ArrayList;

public class OrderClientImpl implements OrderClient{

    private Order order;

    public OrderClientImpl(Order order){
        this.order = order;
    }

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
