package com.uno.shared.transferobjects;

import java.io.Serializable;

/**
 * A class that is used to send account objects from the client to the server
 * and database and back.
 * @author Arturs Silins
 * @version 0.2.0
 */
public class Account implements Serializable {

  private String phoneNumber;
  private String name;
  private String position;
  private String password;

  /**
   * Constructor that sets information for the object.
   * @param phoneNumber String that will be set for the object
   * @param name String that will be set for the object
   * @param position String that will be set for the object
   * @param password String that will be set for the object
   */
  public Account(String phoneNumber, String name, String position, String password) {
    this.phoneNumber = phoneNumber;
    this.name = name;
    this.position = position;
    this.password = password;
  }

  /**
   * Returns account phone number
   * @return String of the account phone number
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * Returns account name
   * @return String of the account name
   */
  public String getName() {
    return name;
  }

  /**
   * Returns account position
   * @return String of the account position
   */
  public String getPosition() {
    return position;
  }

  /**
   * Returns account password
   * @return String of the account password
   */
  public String getPassword() {
    return password;
  }
}
