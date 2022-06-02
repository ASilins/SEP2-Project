package com.uno.database;

import com.uno.database.states.*;
import com.uno.database.states.ordersstates.EditOrderState;
import com.uno.database.states.ordersstates.OrderState;
import com.uno.database.states.ordersstates.PreOrderState;
import com.uno.shared.transferobjects.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that implements Database interface. The class handles sending the
 * objects from database to the server or back.
 * @author Arturs Silins
 * @version 1.0.0
 */
public class DatabaseImpl implements Database {

  private DatabaseHandler currentState;
  private DatabaseHandler handler;

  /**
   * No-Argument constructor that initializes the handler
   */
  public DatabaseImpl() {
    handler = new OrderState();
  }

  /**
   * Method that returns a list of menu item object from the database.
   * @return A list of menuItem objects.
   */
  @Override
  public ArrayList<MenuItem> getMenuItems() {
    setState(new MenuItemsState());
    return (ArrayList<MenuItem>) currentState.getListFromDatabase();
  }

  /**
   * Method that creates a new Order entry in the database.
   * @param order The entry that will be inserted in the database.
   */
  @Override
  public void createOrder(Order order) {
    setState(new OrderState());
    currentState.sendToDatabase(order);
  }


  @Override
  public void editOrder(Order newOrder) {
    setState(new EditOrderState());
  }

  /**
   *a method for creating a pre-order
   * @param orderNumber number of the corresponding order
   * @param reservationNumber number of the corresponding reservation
   */

  @Override
  public void createPreOrder(int orderNumber, int reservationNumber) {

    PreOrder preOrder = new PreOrder(orderNumber, reservationNumber);

    setState(new PreOrderState());
    currentState.sendToDatabase(preOrder);
  }

   /** A method that changes database handler state and sends account
   * object to the database.
   * @param account An account object that will be sent.
   */
  @Override
  public void createAccount(Account account) {
    setState(new AccountState());
    currentState.sendToDatabase(account);
  }

  /**
   * method that creates a new entry in the database
   * @param reservation takes a reservation as a parameter
   */

  @Override
  public void createReservation(Reservation reservation) {
    setState(new ReservationState());
    currentState.sendToDatabase(reservation);
  }

  /**
   * a method for logging in
   * @param phoneNumber takes phone number as a parameter
   * @param password takes password as a parameter
   * @return returns an account
   */

  @Override
  public Account login(String phoneNumber, String password) {
    setState(new AccountState());

    if (currentState.getFromDatabase(phoneNumber) == null) {
      return null;
    }
    Account account = (Account) currentState.getFromDatabase(phoneNumber);

    if (!account.getPassword().equals(password)) {
      return null;
    }

    return account;
  }

  /**
   * a method that retrieves orders from the database
   * @return returns an ArrayList of orders
   */

  @Override
  public ArrayList<Order> getOrders() {
    setState(new OrderState());
    return (ArrayList<Order>) currentState.getListFromDatabase();
  }

  /**
   * a method that updates a reservation
   * @param reservation takes a reservation as a parameter
   */

  @Override
  public void updateReservation(Reservation reservation) {
    setState(new EditReservationState());
    currentState.sendToDatabase(reservation);
  }

  /**
   * a method that gets reservations
   * @return returns a list of reservations
   */

  @Override
  public List<Reservation> getReservations() {
    setState(new ReservationState());
    return (List<Reservation>) currentState.getListFromDatabase();
  }

  /**
   * a method that gets tables
   * @return returns a list of tables
   */

  @Override
  public List<Table> getTables() {
    setState(new TableState());
    return (List<Table>) currentState.getListFromDatabase();
  }

  /**
   * a method that creates a new table
   * @param table takes a table as a parameter
   */

  @Override
  public void createTable(Table table) {
    setState(new TableState());
    currentState.sendToDatabase(table);
  }

  /**
   * a method that edits a table
   * @param table takes a table as a parameter
   */

  @Override
  public void updateTable(Table table) {
    setState(new EditTableState());
    currentState.sendToDatabase(table);
  }

  /**
   * a method that retrieves a list of users
   * @return returns a list of accounts
   */

  @Override
  public List<Account> getUsers() {
    setState(new AccountState());
    return (List<Account>) currentState.getListFromDatabase();
  }

  /**
   * a method that edits a user
   * @param account takes an updated version of account as a parameter
   */

  @Override
  public void editUser(Account account) {
    setState(new EditAccountState());
    currentState.sendToDatabase(account);
  }

  /**
   * Changes state of the handler so that the correct methods are used
   * @param state The handler that will be used
   */
  private void setState(DatabaseHandler state) {
    this.currentState = state;
  }
}
