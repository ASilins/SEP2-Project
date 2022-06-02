package com.uno.client.view.tables.createTable;

import com.uno.client.model.Tables;
import com.uno.shared.transferobjects.Table;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * A method that controls create table controller and model
 * @author Arturs Silins
 * @version 1.0.0
 */
public class CreateTableViewModel {

  private Tables model;

  private StringProperty tableNr;
  private StringProperty capacity;

  /**
   * A constructor that sets the instance of the model
   * @param model the instance of the model
   */
  public CreateTableViewModel(Tables model) {
    this.model = model;

    tableNr = new SimpleStringProperty();
    capacity = new SimpleStringProperty();
  }

  /**
   * Returns string property of tableNr
   * @return String property of tableNr
   */
  public StringProperty tableNrProperty() {
    return tableNr;
  }

  /**
   * Returns String property of capacity
   * @return String property of capacity
   */
  public StringProperty capacityProperty() {
    return capacity;
  }

  /**
   * A method that creates a table and sends it to the model
   */
  public void createTable() {
    model.createTable(new Table(Integer.parseInt(tableNr.get()), Integer.parseInt(capacity.get()), true));
  }
}
