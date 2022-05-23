package com.uno.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

  private static DatabaseConnection instance;
  private static Object lock = new Object();

  private Connection connection;
  private final String URL;
  private final String USER;
  private final String PASSWORD;

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

  public DatabaseConnection getInstance() {
    if (instance == null) {
      synchronized (lock) {
        if (instance == null) {
          return null;
        }
      }
    }

    return instance;
  }

  public DatabaseConnection getInstance(String url, String user, String password) {
    if (instance == null) {
      synchronized (lock) {
        if (instance == null) {
          instance = new DatabaseConnection(url, user, password);
        }
      }
    }

    return instance;
  }

  public Connection getConnection() throws SQLException{
    if (instance == null) {
      return null;
    }

    return DriverManager.getConnection(URL, USER, PASSWORD);
  }
}
