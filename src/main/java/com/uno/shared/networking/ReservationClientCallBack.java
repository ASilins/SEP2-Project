package com.uno.shared.networking;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ReservationClientCallBack extends Remote {

  void update() throws RemoteException;
}
