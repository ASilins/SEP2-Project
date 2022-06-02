package com.uno.client;

import com.uno.client.core.ClientFactory;
import com.uno.client.core.ModelFactory;
import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.networking.ClientImpl;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * A class that creates the factories
 * @author Arturs Silins
 * @version 1.0.0
 */
public class BookingApp extends Application {

  /**
   * Start method that creates factories and starts the view handler
   * @param stage the window of the program
   * @throws Exception If error thrown in the program
   */
  @Override
  public void start(Stage stage) throws Exception {
    ClientFactory cf = new ClientFactory(new ClientImpl());
    ModelFactory mf = new ModelFactory(cf);
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(vmf);
    vh.start();
  }
}
