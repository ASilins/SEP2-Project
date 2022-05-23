package com.uno.client.networking;

import com.uno.shared.transferobjects.Order;

public class OrderClientImpl implements OrderClient{

    private Order order;

    public OrderClientImpl(Order order){
        this.order = order;
    }

    @Override
    public void createOrder(Order order) {
        server.createOrder(order);
    }
}
