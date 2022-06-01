package com.uno.shared.util;

import java.beans.PropertyChangeListener;

public interface Subject {

  void addListener(String evtName, PropertyChangeListener lstnr);
  void removeListener(String evtName, PropertyChangeListener lstnr);
}
