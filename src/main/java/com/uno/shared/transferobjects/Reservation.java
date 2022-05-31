package com.uno.shared.transferobjects;

public class Reservation {

    private int name;
    private int capacity;

    public Reservation(int name, int capacity){
        this.name = name;
        this.capacity = capacity;
    }

    public int getName(){
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setName(int name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
