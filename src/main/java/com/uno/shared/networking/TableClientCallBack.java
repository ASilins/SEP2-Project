package com.uno.shared.networking;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TableClientCallBack extends Remote {

  void update() throws RemoteException;
}
