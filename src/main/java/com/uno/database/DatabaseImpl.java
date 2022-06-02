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
 * @version 0.2.0
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

  @Override public void bookTable(Table table)
  {

  }

  @Override
  public void editTableBooking(Table oldBooking, Table newBooking) {

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

  @Override
  public void createReservation(Reservation reservation) {
    setState(new ReservationState());
    currentState.sendToDatabase(reservation);
  }

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

  @Override
  public ArrayList<Order> getOrders() {
    setState(new OrderState());
    return (ArrayList<Order>) currentState.getListFromDatabase();
  }

  @Override
  public void updateReservation(Reservation reservation) {
    setState(new EditReservationState());
    currentState.sendToDatabase(reservation);
  }

  @Override
  public List<Reservation> getReservations() {
    setState(new ReservationState());
    return (List<Reservation>) currentState.getListFromDatabase();
  }

  @Override
  public List<Table> getTables() {
    setState(new TableState());
    return (List<Table>) currentState.getListFromDatabase();
  }

  @Override
  public void createTable(Table table) {
    setState(new TableState());
    currentState.sendToDatabase(table);
  }

  @Override
  public void updateTable(Table table) {
    setState(new EditTableState());
    currentState.sendToDatabase(table);
  }

  @Override
  public List<Account> getUsers() {
    setState(new AccountState());
    return (List<Account>) currentState.getListFromDatabase();
  }

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
