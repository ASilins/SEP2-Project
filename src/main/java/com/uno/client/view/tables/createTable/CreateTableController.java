package com.uno.client.view.tables.createTable;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CreateTableController implements ViewController {

  private ViewHandler viewHandler;
  private CreateTableViewModel viewModel;

  @FXML
  private TextField tableNr;
  @FXML
  private TextField capacity;

  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
    viewModel = vmf.getCreateTableViewModel();
    this.viewHandler = viewHandler;

    tableNr.textProperty().bindBidirectional(viewModel.tableNrProperty());
    capacity.textProperty().bindBidirectional(viewModel.capacityProperty());
  }

  public void cancel() {
    viewHandler.openManagerViewTables();
  }

  public void createTable() {
    viewModel.createTable();
  }
}
