package com.uno.client.view.tables.editTable;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * A class that controls edit table fxml
 * @author Arturs Silins
 * @version 1.0.0
 */
public class EditTableController implements ViewController {

  private ViewHandler viewHandler;
  private EditTableViewModel viewModel;

  @FXML
  private TextField tableNr;
  @FXML
  private TextField capacity;

  /**
   * A constructor that sets the insctance of view handler and view model
   * @param viewHandler The instance of view handler
   * @param vmf Object that will give the instance
   */
  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
    viewModel = vmf.getEditTableViewModel();
    this.viewHandler = viewHandler;

    tableNr.textProperty().bindBidirectional(viewModel.tableNrProperty());
    capacity.textProperty().bindBidirectional(viewModel.capacityProperty());
  }

  /**
   * A method that changes the view
   */
  public void cancel() {
    viewHandler.openManagerViewTables();
  }

  /**
   * A method that calls for an update and changes the view
   */
  public void updateTable() {
    viewModel.updateTable();
    tableNr.clear();
    capacity.clear();
    viewHandler.openManagerViewTables();
  }
}
