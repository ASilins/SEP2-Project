package com.uno.client.networking;

import com.uno.shared.networking.OrderServer;
import com.uno.shared.networking.Server;
import com.uno.shared.transferobjects.Order;
import com.uno.shared.transferobjects.Reservation;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * class for Order client
 * @author Ondrej,Bhupas Gautam
 * @version 0.2.0
 */
public class OrderClientImpl implements OrderClient{

    private OrderServer server;

    /**
     * Constructor for OrderClientImpl
     * @param server takes a server as a parameter
     */

    public OrderClientImpl(Server server) {
        try {
            this.server = server.getOrderServer();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * method to create an order
     * @param order takes an order as a parameter
     */
    @Override
    public void createOrder(Order order) {
        try {
            server.createOrder(order);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * A method that takes from the server a list of order objects.
     * @return A list of order objects.
     */
    @Override
    public ArrayList<Order> getOrders() {
        ArrayList<Order> list = new ArrayList<>();
        try {
            list = server.getOrders();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * a method to create a pre-order
     * @param order takes order as the first of the two parameters
     * @param reservation takes reservation as the second of the two parameters
     */
    @Override
    public void createPreOrder(Order order, Reservation reservation){
        try {
            server.createPreOrder(order, reservation);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * A method to edit order
     * @param newOrder replaces the old order with the new order
     */
    @Override
    public void editOrder(Order newOrder) {
        try {
            server.editOrder(newOrder);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
