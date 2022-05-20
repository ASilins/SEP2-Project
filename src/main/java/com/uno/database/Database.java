package com.uno.database;

import com.uno.shared.transferobjects.MenuItem;

import java.util.ArrayList;

public interface Database {

  ArrayList<MenuItem> getMenuItems();
}
