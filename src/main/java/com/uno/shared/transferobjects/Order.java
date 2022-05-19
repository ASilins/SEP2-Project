package com.uno.shared.transferobjects;

public class Order {

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
