package com.uno.client.view.tables.editTable;

import com.uno.client.model.Tables;
import com.uno.shared.transferobjects.Table;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class EditTableViewModel {

  private Tables model;

  private StringProperty tableNr;
  private StringProperty capacity;

  public EditTableViewModel(Tables model) {
    this.model = model;

    tableNr = new SimpleStringProperty();
    capacity = new SimpleStringProperty();
    model.addListener("TableToEdit", this::tableToEdit);
  }

  private void tableToEdit(PropertyChangeEvent event) {
    Table table;

    if (event.getNewValue() == null) {
      table = new Table(0, 0, false);
    } else {
      table = (Table) event.getNewValue();
    }

    Platform.runLater(() -> {
      tableNr.set(Integer.toString(table.getTableNumber()));
      capacity.set(Integer.toString(table.getCapacity()));
    });
  }

  public StringProperty tableNrProperty() {
    return tableNr;
  }

  public StringProperty capacityProperty() {
    return capacity;
  }

  public void updateTable() {
    model.updateTable(new Table(Integer.parseInt(tableNr.get()), Integer.parseInt(capacity.get()), true));
  }
}
