package com.uno.shared.transferobjects;

import java.io.Serializable;

/**
 * A class for an object that will be transferred between the server and the database
 * @author Ondrej Klimek
 * @version 0.2.0
 */

public class PreOrder implements Serializable {

    private int orderNumber;
    private int reservationNumber;

    /**
     * constructor to initialize new object
     * @param orderNumber order number from Order
     * @param reservationNumber reservation number from Reservation
     */

    public PreOrder(int orderNumber, int reservationNumber){
        this.orderNumber = orderNumber;
        this.reservationNumber = reservationNumber;
    }

    public void setOrderNumber(int orderNumber){
        this.orderNumber = orderNumber;
    }

    public void setReservationNumber(int reservationNumber){
        this.reservationNumber = reservationNumber;
    }

    /**
     * gets the order number from PreOrder object
     * @return returns order number as an int
     */

    public int getOrderNumber() {
        return this.orderNumber;
    }

    /**
     * gets the reservation number from PreOrder object
     * @return returns reservation number as an int
     */

    public int getReservationNumber() {
        return this.reservationNumber;
    }

}
