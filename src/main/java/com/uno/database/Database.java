package com.uno.database;

import com.uno.shared.transferobjects.*;

import java.util.ArrayList;
import java.util.List;

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

  /**
   * a method that edits an order in the database
   * @param newOrder takes the new version of the order as a parameter
   */

  void editOrder(Order newOrder);

  /**
   * A method that takes account object and send it to the database.
   * @param account An account object that will be sent.
   */
  void createAccount(Account account);

  /**
   * method that creates a new entry in the database
   * @param reservation takes a reservation as a parameter
   */

  void createReservation(Reservation reservation);

  /**
   * a method for logging in
   * @param phoneNumber takes phone number as a parameter
   * @param password takes password as a parameter
   * @return returns an account
   */

  Account login(String phoneNumber, String password);

  /**
   * a method that retrieves orders from the database
   * @return returns an ArrayList of orders
   */

  ArrayList<Order> getOrders();

  /**
   * a method that updates a reservation
   * @param reservation takes a reservation as a parameter
   */

  void updateReservation(Reservation reservation);

  /**
   * a method that gets reservations
   * @return returns a list of reservations
   */

  List<Reservation> getReservations();

  /**
   * a method that gets tables
   * @return returns a list of tables
   */

  List<Table> getTables();

  /**
   * a method that creates a new table
   * @param table takes a table as a parameter
   */

  void createTable(Table table);

  /**
   * a method that edits a table
   * @param table takes a table as a parameter
   */

  void updateTable(Table table);

  /**
   * a method that retrieves a list of users
   * @return returns a list of accounts
   */

  List<Account> getUsers();

  /**
   * a method that edits a user
   * @param account takes an updated version of account as a parameter
   */

  void editUser(Account account);
}
