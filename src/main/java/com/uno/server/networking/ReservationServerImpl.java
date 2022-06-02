package com.uno.server.networking;

import com.uno.server.model.ReservationHandler;
import com.uno.shared.networking.ReservationServer;
import com.uno.shared.transferobjects.Reservation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * This is a class with reservation server interface. This server object handles
 * sending and receiving Reservation objects from client and server.
 * @author Arturs Silins
 * @version 1.0.0
 */

public class ReservationServerImpl implements ReservationServer {

  private ReservationHandler handler;

  public ReservationServerImpl(ReservationHandler handler) throws RemoteException{
    UnicastRemoteObject.exportObject(this, 0);
    this.handler = handler;
  }

  @Override
  public void createReservation(Reservation reservation) throws RemoteException {

  }
}
