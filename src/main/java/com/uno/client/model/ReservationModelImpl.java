package com.uno.client.model;

import com.uno.client.networking.Client;
import com.uno.client.networking.ReservationClient;
import com.uno.shared.transferobjects.Reservation;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.util.List;

/**
 * A class that sends and receives Reservation objects to client and view
 * @author Arturs Silins
 * @version 1.0.0
 */
public class ReservationModelImpl implements ReservationModel{

  private ReservationClient client;

  private PropertyChangeSupport support;

  /**
   * A constructor that sets the client for the instance
   * @param client The client that gives the instance
   */
  public ReservationModelImpl(Client client) {
    try {
      this.client = client.getReservationClient();
      this.client.registerClient();
      this.client.addListener("Update", this::update);
    } catch (RemoteException e) {
      e.printStackTrace();
    }

    support = new PropertyChangeSupport(this);
  }

  /**
   * A method that fires a property change from a property change
   * @param event The property change event that had been fired
   */
  private void update(PropertyChangeEvent event) {
    support.firePropertyChange("Update", null, event.getNewValue());
  }

  /**
   * A method that send a reservation object to the client
   * @param reservation The Reservation object that will be sent
   */
  @Override
  public void createReservation(Reservation reservation) {
    client.createReservation(reservation);
  }

  /**
   * A method that takes a list of Reservation objects from the client
   * @return A list of Reservation objects
   */
  @Override
  public List<Reservation> getReservations() {
    return client.getReservations();
  }

  /**
   * A method that sends a edit Reservation object to the client
   * @param reservation The object that will be sent
   */
  @Override
  public void updateReservation(Reservation reservation) {
    client.updateReservation(reservation);
  }

  /**
   * A method that holds and fires a property change event with a Reservation object
   * @param reservation The reservation object that will be fired
   */
  @Override
  public void sendSelectedBooking(Reservation reservation) {
    new Thread(() -> {
      try {
        Thread.sleep(250);
        support.firePropertyChange("ReservationToEdit", null, reservation);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();
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
