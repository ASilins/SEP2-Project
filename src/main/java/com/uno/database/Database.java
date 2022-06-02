package com.uno.database;

import com.uno.shared.transferobjects.*;

import java.util.ArrayList;

/**
 * An interface that has all methods for getting items from and to the database.
 * @author Arturs Silins, Siddhartha Grasse
 * @version 1.0.0
 */
public interface Database {

  /**
   * Method that returns a list of menu item object from the database.
   * @return A list of menuItem objects.
   */
  ArrayList<MenuItem> getMenuItems();

  /**
   * Method that creates a new Order entry in the database.
   * @param order The entry that will be inserted in the database.
   */
  void createOrder(Order order);

  /**
   * a method for creating a pre-order
   * @param orderNum number of the corresponding order
   * @param reservationNum number of the corresponding reservation
   */

  void createPreOrder(int orderNum, int reservationNum);
  
  
   /** Method that creates a new Table entry in the database.
   * @param table The entry that will be inserted in the database.
   */
  void bookTable(Table table);

  void editTableBooking(Table oldBooking, Table newBooking);

  void editOrder(Order newOrder);

  /**
   * A method that takes account object and send it to the database.
   * @param account An account object that will be sent.
   */
  void createAccount(Account account);

  void createReservation(Reservation reservation);

  Account login(String phoneNumber, String password);

  ArrayList<Order> getOrders();
}
