package com.uno.client.model;

import com.uno.client.networking.Client;
import com.uno.client.networking.OrderClient;
import com.uno.shared.transferobjects.Order;
import com.uno.shared.transferobjects.Reservation;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * An interface of a class for making order
 * @author Ondrej Klimek, Bhupas Gautam
 * @version 1.0.0
 */
public class MakeOrderImpl implements MakeOrder {

    private PropertyChangeSupport support;

    private OrderClient orderClient;

    /**
     * constructor for MakeOrderImpl class
     * @param client takes client as a parameter
     */
    public MakeOrderImpl(Client client) {
        try {
            this.orderClient = client.getOrderClient();
            orderClient.registerClient();
            orderClient.addListener("Update", this::update);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        support = new PropertyChangeSupport(this);
    }

    private void update(PropertyChangeEvent event) {
        support.firePropertyChange("Update", null, event.getNewValue());
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

    /**
     * A method that stores and then fires property change listener with the
     * order object
     * @param order The order object that is fired
     */
    @Override
    public void OrderToEdit(Order order) {
        new Thread(() -> {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            support.firePropertyChange("OrderToEdit", null, order);
        }).start();
    }

    /**
     * A method for adding a listener
     */
    @Override
    public void addListener(String evtName, PropertyChangeListener lstnr) {
        support.addPropertyChangeListener(evtName, lstnr);
    }

    /**
     * A method for removing a listener
     */
    @Override
    public void removeListener(String evtName, PropertyChangeListener lstnr) {
        support.removePropertyChangeListener(evtName, lstnr);
    }
}

