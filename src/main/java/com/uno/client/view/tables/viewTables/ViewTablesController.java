package com.uno.client.view.tables.viewTables;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.view.ViewController;
import com.uno.shared.transferobjects.Table;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewTablesController implements ViewController {

  private ViewHandler viewHandler;
  private ViewTablesViewModel viewModel;

  @FXML
  private TableView<Table> table;
  public TableColumn<String, Table> tableNr;
  public TableColumn<String, Table> capacity;
  public TableColumn<String, Table> availability;

  @Override
  public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
    viewModel = vmf.getViewTablesViewModel();
    this.viewHandler = viewHandler;

    viewModel.loadTables();
    table.setItems(viewModel.getTables());
    tableNr.setCellValueFactory(new PropertyValueFactory<>("tableNumber"));
    capacity.setCellValueFactory(new PropertyValueFactory<>("capacity"));
    availability.setCellValueFactory(new PropertyValueFactory<>("availability"));
  }

  public void back() {
    viewHandler.openStaffMainMenu();
  }

  public void managerBack() {
    viewHandler.openManagerMainMenu();
  }

  public void createTable() {
    viewHandler.openCreateTable();
  }

  public void editTable() {
    viewModel.tableToEdit(table.getSelectionModel().getSelectedItem());
    viewHandler.openEditTable();
  }
}
