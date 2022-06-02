package com.uno.client.view.dineIn;

import com.uno.client.model.MakeOrder;
import com.uno.client.model.MenuItems;
import com.uno.client.model.Tables;
import com.uno.shared.transferobjects.MenuItem;
import com.uno.shared.transferobjects.Order;
import com.uno.shared.transferobjects.Table;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class DineInViewModel {
    private MenuItems menuModel;
    private Tables tableModel;
    private MakeOrder orderModel;

    private StringProperty dietaryNeeds;
    private StringProperty comment;
    private ObservableList<MenuItem> menu;
    private ObservableList<Table> tables;

    public DineInViewModel(MenuItems model, Tables tableModel){
        this.menuModel = model;
        this.tableModel = tableModel;
    }

    public void loadMenu(){
        List<MenuItem> list = menuModel.getMenuItems();
        menu = FXCollections.observableArrayList(list);
    }

    public void loadTables(){
        List<Table> list = tableModel.getTables();
        tables = FXCollections.observableArrayList(list);
    }

    public void createOrder(Order order){
        orderModel.createOrder(order);
    }

    public ObservableList<MenuItem> getMenu(){
        return menu;
    }

    public ObservableList<Table> getTables(){
        return tables;
    }

    public StringProperty commentProperty() {
        return comment;
    }

    public StringProperty dietaryNeedsProperty() {
        return dietaryNeeds;
    }

}
