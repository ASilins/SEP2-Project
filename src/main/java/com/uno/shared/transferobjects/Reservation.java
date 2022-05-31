package com.uno.shared.transferobjects;

import java.io.Serializable;
import java.sql.Timestamp;

public class Reservation implements Serializable {

  private int reservationNumber;
  private String customerNumber;
  private Timestamp date;
  private int amountOfPeople;
  private String comment;
  private String dietaryNeeds;
  private Table table;

  public Reservation(int reservationNumber, String customerNumber, Timestamp date, int amountOfPeople, String comment, String dietaryNeeds, Table table) {
    this.reservationNumber = reservationNumber;
    this.customerNumber = customerNumber;
    this.date = date;
    this.amountOfPeople = amountOfPeople;
    this.comment = comment;
    this.dietaryNeeds = dietaryNeeds;
    this.table = table;
  }

  public int getReservationNumber() {
    return reservationNumber;
  }

  public String getCustomerNumber() {
    return customerNumber;
  }

  public Timestamp getDate() {
    return date;
  }

  public int getAmountOfPeople() {
    return amountOfPeople;
  }

  public String getComment() {
    return comment;
  }

  public String getDietaryNeeds() {
    return dietaryNeeds;
  }

  public Table getTable() {
    return table;
  }
}
