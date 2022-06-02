package com.uno.client.networking;

import com.uno.shared.networking.ReservationClientCallBack;
import com.uno.shared.networking.ReservationServer;
import com.uno.shared.networking.Server;
import com.uno.shared.transferobjects.Reservation;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * class for reservation client
 * @author Arturs Silins
 * @version 1.0.0
 */
public class ReservationClientImpl implements ReservationClient, ReservationClientCallBack {

  private ReservationServer server;

  private PropertyChangeSupport support;
  
 /**
   * Constructor for ReservationClientImpl
   * @param server takes a server as a parameter
   */
  public ReservationClientImpl(Server server) {
    try {
      this.server = server.getReservationServer();
      UnicastRemoteObject.exportObject(this, 0);
    } catch (RemoteException e) {
      e.printStackTrace();
    }

    support = new PropertyChangeSupport(this);
  }

  /**
   * A method that registers client to the server
   */
  public void registerClient() {
    try {
      server.registerClient(this);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }

  /**
   * method to create an order
   * @param reservation takes a reservation as a parameter
   */
  @Override
  public void createReservation(Reservation reservation) {
    try {
      server.createReservation(reservation);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * A method that sends an edited object to the server
   * @param reservation Teh object that will be sent
   */
  @Override
  public void updateReservation(Reservation reservation) {
    try {
      server.updateReservation(reservation);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }

  /**
   * A method that gets a list of Reservation objects from the server
   * @return A list og Reservation objects
   */
  @Override
  public List<Reservation> getReservations() {
    try {
      return server.getReservations();
    } catch (RemoteException e) {
      e.printStackTrace();
    }

    return null;
  }

  /**
   * A method that fires a property change
   */
  @Override
  public void update() {
    support.firePropertyChange("Update", null, getReservations());
  }

  /**
   * A method that adds property change listener
   * @param evtName The name of event it is waiting
   * @param lstnr An object that is listening
   */
  @Override
  public void addListener(String evtName, PropertyChangeListener lstnr) {
    support.addPropertyChangeListener(evtName, lstnr);
  }

  /**
   * A method that removes property change listener
   * @param evtName The name of the event it was waiting
   * @param lstnr An object that was listening
   */
  @Override
  public void removeListener(String evtName, PropertyChangeListener lstnr) {
    support.removePropertyChangeListener(evtName, lstnr);
  }
}
