package com.uno.client.view.tables.editTable;

import com.uno.client.model.Tables;
import com.uno.shared.transferobjects.Table;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

/**
 * A class that controls edit table controller and model
 */
public class EditTableViewModel {

  private Tables model;

  private StringProperty tableNr;
  private StringProperty capacity;

  /**
   * A method that sets the instance of model
   * @param model the instance of model
   */
  public EditTableViewModel(Tables model) {
    this.model = model;

    tableNr = new SimpleStringProperty();
    capacity = new SimpleStringProperty();
    model.addListener("TableToEdit", this::tableToEdit);
  }

  /**
   * A method that sets the info to edit
   * @param event The table info
   */
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

  /**
   * Returns a string property for tableNr
   * @return String property for tableNr
   */
  public StringProperty tableNrProperty() {
    return tableNr;
  }

  /**
   * Returns a String property for capacity
   * @return String property for cpacity
   */
  public StringProperty capacityProperty() {
    return capacity;
  }

  /**
   * A method that creates a table and sends it to the model
   */
  public void updateTable() {
    model.updateTable(new Table(Integer.parseInt(tableNr.get()), Integer.parseInt(capacity.get()), true));
  }
}
