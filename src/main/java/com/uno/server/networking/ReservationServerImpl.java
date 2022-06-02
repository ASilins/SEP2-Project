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

public class ReservationServerImpl implements ReservationServer {

  private ReservationHandler handler;
  private List<ReservationClientCallBack> clients;

  public ReservationServerImpl(ReservationHandler handler) throws RemoteException{
    UnicastRemoteObject.exportObject(this, 0);
    this.handler = handler;
    clients = new ArrayList<>();
  }

  public void registerClient(ReservationClientCallBack client) throws RemoteException {
    clients.add(client);
  }

  private void update() {
    for (ReservationClientCallBack account : clients) {
      try {
        account.update();
      } catch (RemoteException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void createReservation(Reservation reservation) throws RemoteException {

  }

  @Override
  public void updateReservation(Reservation reservation) throws RemoteException {
    handler.updateReservation(reservation);
    update();
  }

  @Override
  public List<Reservation> getReservations() throws RemoteException {
    return handler.getReservations();
  }
}
