package com.uno.shared.transferobjects;

import java.io.Serializable;

/**
 * A class for an object that will be transferred between the server and the database
 * @author Arturs Silins
 * @version 1.0.0
 */
public class Order implements Serializable {

    private int orderNumber;
    private int menuItem;
    private String comment;
    private String dietaryNeeds;

    public Order(int orderNumber, int menuItem, String comment, String dietaryNeeds) {
        this.orderNumber = orderNumber;
        this.menuItem = menuItem;
        this.comment = comment;
        this.dietaryNeeds = dietaryNeeds;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getMenuItem() {
        return menuItem;
    }

    public String getComment() {
        return comment;
    }

    public String getDietaryNeeds() {
        return dietaryNeeds;
    }

}
