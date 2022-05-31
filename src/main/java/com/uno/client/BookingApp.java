package com.uno.client;

import com.uno.client.core.ClientFactory;
import com.uno.client.core.ModelFactory;
import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.networking.ClientImpl;
import javafx.application.Application;
import javafx.stage.Stage;

public class BookingApp extends Application {

  @Override
  public void start(Stage stage) throws Exception {
    ClientFactory cf = new ClientFactory(new ClientImpl());
    ModelFactory mf = new ModelFactory(cf);
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(vmf);
    vh.start();
  }
}
