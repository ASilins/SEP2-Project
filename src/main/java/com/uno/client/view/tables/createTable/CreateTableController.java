package com.uno.client.view.tables.createTable;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * A class that controls create table fxml
 * @author Arturs Silins
 * @version 1.0.0
 */
public class CreateTableController implements ViewController {

  private ViewHandler viewHandler;
  private CreateTableViewModel viewModel;

  @FXML
  private TextField tableNr;
  @FXML
  private TextField capacity;

  /**
   * A method that sets instance of view handler and view model
   * @param viewHandler The instance of view handler
   * @param vmf Object that gives the insctace of view model
   */
  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
    viewModel = vmf.getCreateTableViewModel();
    this.viewHandler = viewHandler;

    tableNr.textProperty().bindBidirectional(viewModel.tableNrProperty());
    capacity.textProperty().bindBidirectional(viewModel.capacityProperty());
  }

  /**
   * A method that changes the view to manager view tables
   */
  public void cancel() {
    viewHandler.openManagerViewTables();
  }

  /**
   * A method that creates a table and changes the scene
   */
  public void createTable() {
    viewModel.createTable();
    tableNr.clear();
    capacity.clear();
    viewHandler.openManagerViewTables();
  }
}
