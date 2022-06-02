package com.uno.client.view.tables.createTable;

import com.uno.client.model.Tables;
import com.uno.shared.transferobjects.Table;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CreateTableViewModel {

  private Tables model;

  private StringProperty tableNr;
  private StringProperty capacity;

  public CreateTableViewModel(Tables model) {
    this.model = model;

    tableNr = new SimpleStringProperty();
    capacity = new SimpleStringProperty();
  }

  public StringProperty tableNrProperty() {
    return tableNr;
  }

  public StringProperty capacityProperty() {
    return capacity;
  }

  public void createTable() {
    model.createTable(new Table(Integer.parseInt(tableNr.get()), Integer.parseInt(capacity.get()), true));
  }
}
