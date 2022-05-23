package com.uno.database;

import com.uno.shared.transferobjects.MenuItem;

import java.util.ArrayList;

public class DatabaseImpl implements Database {

  private DatabaseHandler currentState;
  private DatabaseHandler handler;

  public DatabaseImpl() {

  }

  @Override
  public ArrayList<MenuItem> getMenuItems() {
    setState(new MenuItemsState());
    return null;
  }

  private void setState(DatabaseHandler state) {
    this.currentState = state;
  }
}
