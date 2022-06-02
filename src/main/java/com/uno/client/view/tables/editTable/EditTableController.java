package com.uno.client.view.tables.editTable;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditTableController implements ViewController {

  private ViewHandler viewHandler;
  private EditTableViewModel viewModel;

  @FXML
  private TextField tableNr;
  @FXML
  private TextField capacity;

  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
    viewModel = vmf.getEditTableViewModel();
    this.viewHandler = viewHandler;

    tableNr.textProperty().bindBidirectional(viewModel.tableNrProperty());
    capacity.textProperty().bindBidirectional(viewModel.capacityProperty());
  }

  public void cancel() {
    viewHandler.openManagerViewTables();
  }

  public void updateTable() {
    viewModel.updateTable();
  }
}
