package com.uno.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A class that stores connection information with the database and returns
 * connection to the database.
 * @author Arturs Silins
 * @version 0.1.0
 */
public class DatabaseConnection {

  private static DatabaseConnection instance;
  private static Object lock = new Object();

  private final String URL;
  private final String USER;
  private final String PASSWORD;

  /**
   * Private three argument constructor that sets the url, user
   * and password instance and registers driver.
   * @param URL The URL that it will be set to
   * @param USER The USER that it will be set to
   * @param PASSWORD The PASSWORD that it will be set to
   */
  private DatabaseConnection(String URL, String USER, String PASSWORD) {
    this.URL = URL;
    this.USER = USER;
    this.PASSWORD = PASSWORD;

    try {
      DriverManager.registerDriver(new org.postgresql.Driver());
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * A method that returns an instance of this class
   * @return A DatabaseConnection object
   */
  public static DatabaseConnection getInstance() {
    if (instance == null) {
      synchronized (lock) {
        if (instance == null) {
          return null;
        }
      }
    }

    return instance;
  }

  /**
   * A method that returns an instance of this class. The parameters are used
   * for the first call so that the connection can be established.
   * @param url That will be used to call the constructor
   * @param user That will be used to call the constructor
   * @param password That will be used to call the constructor
   * @return A DatabaseConnection object
   */
  public static DatabaseConnection getInstance(String url, String user, String password) {
    if (instance == null) {
      synchronized (lock) {
        if (instance == null) {
          instance = new DatabaseConnection(url, user, password);
        }
      }
    }

    return instance;
  }

  /**
   * A method that returns a new database connection
   * @return A new database connection
   * @throws SQLException If the connection has failed
   */
  public Connection getConnection() throws SQLException{
    if (instance == null) {
      return null;
    }

    return DriverManager.getConnection(URL, USER, PASSWORD);
  }
}
