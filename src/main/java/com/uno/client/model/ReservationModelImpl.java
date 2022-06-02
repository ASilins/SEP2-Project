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
 *
 * @author Arturs Silins
 * @version 1.0.0
 */
public class ReservationModelImpl implements ReservationModel{

  private ReservationClient client;

  private PropertyChangeSupport support;

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

  private void update(PropertyChangeEvent event) {
    support.firePropertyChange("Update", null, event.getNewValue());
  }

  @Override
  public void createReservation(Reservation reservation) {
    client.createReservation(reservation);
  }

  @Override
  public List<Reservation> getReservations() {
    return client.getReservations();
  }

  @Override
  public void updateReservation(Reservation reservation) {
    client.updateReservation(reservation);
  }

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

  @Override
  public void addListener(String evtName, PropertyChangeListener lstnr) {
    support.addPropertyChangeListener(evtName, lstnr);
  }

  @Override
  public void removeListener(String evtName, PropertyChangeListener lstnr) {
    support.removePropertyChangeListener(evtName, lstnr);
  }
}
