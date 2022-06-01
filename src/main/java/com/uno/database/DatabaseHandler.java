package com.uno.database;

import java.util.ArrayList;

/**
 * An interface that has methods that can be used for database queries
 * @author Arturs Silins
 * @version 0.1.0
 */
public interface DatabaseHandler {

  /**
   * A method that takes and object and inserts it into database.
   * @param object The object that will be inserted in to database.
   */
  void sendToDatabase(Object object);

  /**
   * A method that returns one object from the database.
   * @return The object from the database.
   */
  Object getFromDatabase(Object searchParameter);

  /**
   * A method that inserts a list of objects into a database table.
   * @param list That will be inserted.
   */
  void sendListToDatabase(Object list);

  /**
   * A method that returns a whole list of objects from a database table.
   * @return An object that is a list object.
   */
  Object getListFromDatabase();
}
