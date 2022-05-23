package com.uno.client.model;

import com.uno.client.networking.Client;
import com.uno.client.networking.OrderClient;
import com.uno.shared.transferobjects.Order;

public class MakeOrderImpl implements MakeOrder {

    private OrderClient orderClient;

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

}
