package com.uno.shared.networking;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OrderClientCallBack extends Remote {

  void update() throws RemoteException;
}
