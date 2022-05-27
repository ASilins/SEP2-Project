package com.uno.shared.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * A class that is used to hash password. For hashing the code
 * uses MD5 algorithm.
 * @author Arturs Silins
 * @version 1.0.0
 */
public class PasswordHasher {

  /**
   * Method that hashes a password and returns String of the hash code.
   * @param password The password that will be hashed
   * @return A String of the hash code.
   */
  public static String hashPassword(String password) {
    StringBuilder sb;
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(password.getBytes());
      byte[] result = messageDigest.digest();

      sb = new StringBuilder();
      for (byte b : result) {
        sb.append(String.format("%02x", b));
      }


    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
      return null;
    }

    return sb.toString();
  }
}
