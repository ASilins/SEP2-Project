package com.uno.client.view.tables.viewTables;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.view.ViewController;
import com.uno.shared.transferobjects.Table;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * A class that controls view table fxml and manager view table
 * @author Arturs Silins
 * @version 1.0.0
 */
public class ViewTablesController implements ViewController {

  private ViewHandler viewHandler;
  private ViewTablesViewModel viewModel;

  @FXML
  private TableView<Table> table;
  public TableColumn<String, Table> tableNr;
  public TableColumn<String, Table> capacity;
  public TableColumn<String, Table> availability;

  /**
   * A method that sets instance of view handler and view model
   * @param viewHandler the instance of view handler
   * @param vmf Object that will give instance of view model
   */
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

  /**
   * Changes the view
   */
  public void back() {
    viewHandler.openStaffMainMenu();
  }

  /**
   * Changes the view
   */
  public void managerBack() {
    viewHandler.openManagerMainMenu();
  }

  /**
   * Changes the view
   */
  public void createTable() {
    viewHandler.openCreateTable();
  }

  /**
   * Changes the view and sends the selected object from the table
   */
  public void editTable() {
    viewModel.tableToEdit(table.getSelectionModel().getSelectedItem());
    viewHandler.openEditTable();
  }
}
