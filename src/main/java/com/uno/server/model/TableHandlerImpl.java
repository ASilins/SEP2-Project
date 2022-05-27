package com.uno.server.model;

import com.uno.database.Database;
import com.uno.shared.transferobjects.Table;

/**
 * A class that handles Table objects from the database to the client.
 * @author Siddhartha Grasse, Maximillian Wallin
 * @version 0.2.0
 */
public class TableHandlerImpl implements TableHandler {

  private Database database;
  private Table oldBooking;

  /**
   * A constructor that takes database object and sets it to the instance.
   *
   * @param database The object that will be in the object instance.
   */
  public TableHandlerImpl(Database database)
  {
    this.database = database;
  }

  /**
   * A method that sends table object to the database.
   *
   * @param table The object that will be sent to the database
   */
  @Override 
  public void bookTable(Table table) {
    database.bookTable(table);
  }

  /**
   * Update oldBooking object from database.
   * @param oldBooking The object that will be updated from the database.
   */
  @Override 
  public void editTableBooking(Table oldBooking, Table newBooking) {
    database.editTableBooking(oldBooking, newBooking);
  }
}
