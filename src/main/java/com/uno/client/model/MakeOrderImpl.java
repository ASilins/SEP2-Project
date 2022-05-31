package com.uno.client.model;

import com.uno.client.networking.Client;
import com.uno.client.networking.OrderClient;
import com.uno.shared.transferobjects.Order;
import com.uno.shared.transferobjects.Reservation;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * An interface of a class for making order
 * @author Ondrej Klimek, Bhupas Gautam
 * @version 0.2.0
 */
public class MakeOrderImpl implements MakeOrder {

    private OrderClient orderClient;

    /**
     * constructor for MakeOrderImpl class
     * @param client takes client as a parameter
     */
    public MakeOrderImpl(Client client) {
        try {
            this.orderClient = client.getOrderClient();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
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

    @Override
    public void createPreOrder(Order order, Reservation reservation) {
        orderClient.createPreOrder(order, reservation);
    }
  
    /**
     * A method to edit order
     * @param newOrder replaces the old order with the new order
     */
    @Override
    public void editOrder(Order newOrder) {
        orderClient.editOrder(newOrder);
    }
}

