package com.uno.database;

import java.util.ArrayList;

public interface DatabaseHandler {

  void sendToDatabase(Object object);
  Object getFromDatabase();

  void sendListToDatabase(ArrayList<Object> list);
  ArrayList<Object> GetListFromDatabase();
}
