package com.uno.client.view.tables.viewTables;

import com.uno.client.model.Tables;
import com.uno.shared.transferobjects.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class ViewTablesViewModel {

  private Tables model;

  private ObservableList<Table> tables;

  public ViewTablesViewModel(Tables model) {
    this.model = model;
    model.addListener("Update", this::update);
  }

  private void update(PropertyChangeEvent event) {
    tables.clear();
    tables.addAll((List<Table>)event.getNewValue());
  }

  public void loadTables() {
    List<Table> list = model.getTables();
    tables = FXCollections.observableArrayList(list);
  }

  public ObservableList<Table> getTables() {
    return tables;
  }

  public void tableToEdit(Table table) {
    model.tableToEdit(table);
  }
}
