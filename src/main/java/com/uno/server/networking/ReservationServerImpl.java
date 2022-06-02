package com.uno.server.networking;

import com.uno.server.model.ReservationHandler;
import com.uno.shared.networking.AccountClientCallBack;
import com.uno.shared.networking.ReservationClientCallBack;
import com.uno.shared.networking.ReservationServer;
import com.uno.shared.transferobjects.Reservation;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a class with reservation server interface. This server object handles
 * sending and receiving Reservation objects from client and server.
 * @author Arturs Silins
 * @version 1.0.0
 */

public class ReservationServerImpl implements ReservationServer {

  private ReservationHandler handler;
  private List<ReservationClientCallBack> clients;

  /**
   * A constructor that sets the instance of the handler
   * @param handler The instance of the handler
   * @throws RemoteException If connection failed
   */
  public ReservationServerImpl(ReservationHandler handler) throws RemoteException{
    UnicastRemoteObject.exportObject(this, 0);
    this.handler = handler;
    clients = new ArrayList<>();
  }

  /**
   * A method that registers the client in the server
   * @param client The object that is registered
   * @throws RemoteException If connection failed
   */
  public void registerClient(ReservationClientCallBack client) throws RemoteException {
    clients.add(client);
  }

  /**
   * A method that sends an update to all clients
   */
  private void update() {
    for (ReservationClientCallBack account : clients) {
      try {
        account.update();
      } catch (RemoteException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * A method that send reservation to the model
   * @param reservation The object that will be sent
   * @throws RemoteException If connection failed
   */
  @Override
  public void createReservation(Reservation reservation) throws RemoteException {

  }

  /**
   * A method that send an edited reservation object to the model
   * @param reservation The object that will be sent
   * @throws RemoteException If connection failed
   */
  @Override
  public void updateReservation(Reservation reservation) throws RemoteException {
    handler.updateReservation(reservation);
    update();
  }

  /**
   * Return a list of reservations
   * @return A list of reservations
   * @throws RemoteException If connection failed
   */
  @Override
  public List<Reservation> getReservations() throws RemoteException {
    return handler.getReservations();
  }
}
