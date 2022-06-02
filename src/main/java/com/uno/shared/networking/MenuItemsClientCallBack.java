package com.uno.shared.networking;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MenuItemsClientCallBack extends Remote {

  void update() throws RemoteException;
}
