package com.uno.shared.transferobjects;

import java.io.Serializable;

public class MenuItem implements Serializable {

    private int itemID;
    private String name;
    private int price;

    public MenuItem(int itemID, String name, int price) {
        this.itemID = itemID;
        this.name = name;
        this.price = price;
    }

    public int getItemID() {
        return itemID;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
