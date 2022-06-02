package com.uno.client.view.tables.viewTables;

import com.uno.client.model.Tables;
import com.uno.shared.transferobjects.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.util.List;

/**
 * A class that controls view table controler and view model
 * @author Arturs Silins
 * @version 1.0.0
 */
public class ViewTablesViewModel {

  private Tables model;

  private ObservableList<Table> tables;

  /**
   * A constructor that sets instance of model
   * @param model the instance of model
   */
  public ViewTablesViewModel(Tables model) {
    this.model = model;
    model.addListener("Update", this::update);
  }

  /**
   * A method that resets the table info
   * @param event
   */
  private void update(PropertyChangeEvent event) {
    tables.clear();
    tables.addAll((List<Table>)event.getNewValue());
  }

  /**
   * A method that load table info
   */
  public void loadTables() {
    List<Table> list = model.getTables();
    tables = FXCollections.observableArrayList(list);
  }

  /**
   * A method that returns observable list of Table
   * @return
   */
  public ObservableList<Table> getTables() {
    return tables;
  }

  /**
   * Sends table object to the model
   * @param table the object that is sent
   */
  public void tableToEdit(Table table) {
    model.tableToEdit(table);
  }
}
