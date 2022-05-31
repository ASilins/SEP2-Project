package com.uno.server;

import com.uno.database.DatabaseConnection;
import com.uno.server.networking.ServerImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RunServer {
  public static void main(String[] args) {
    try {
      ServerImpl server = new ServerImpl();
      Scanner in = new Scanner(System.in);

      System.out.print("\nDatabase connection: \nurl: ");
      String url = in.nextLine();
      System.out.print("user: ");
      String user = in.nextLine();
      System.out.print("password: ");
      String password = in.nextLine();
      DatabaseConnection.getInstance(url, user, password);

      System.out.println("Starting server...");
      server.startServer();
    } catch (RemoteException | AlreadyBoundException e) {
      e.printStackTrace();
    }
  }
}
