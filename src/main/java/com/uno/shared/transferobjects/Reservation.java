package com.uno.shared.transferobjects;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * A class for an object that will be transferred between the server and the database
 * @author Arturs Silins
 * @version 1.0.0
 */
public class Reservation implements Serializable {

  private int reservationNumber;
  private String customerNumber;
  private Timestamp date;
  private int amountOfPeople;
  private String comment;
  private String dietaryNeeds;
  private int table;

  public Reservation(int reservationNumber, String customerNumber, Timestamp date, int amountOfPeople, String comment, String dietaryNeeds, int table) {
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

  public int getTable() {
    return table;
  }
}
