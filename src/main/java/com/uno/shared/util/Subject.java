package com.uno.shared.util;

import java.beans.PropertyChangeListener;

/**
 * An interface that helps adding property change listeners to a class
 * @author Arturs Silins
 * @version 1.0.0
 */
public interface Subject {

  void addListener(String evtName, PropertyChangeListener lstnr);
  void removeListener(String evtName, PropertyChangeListener lstnr);
}
