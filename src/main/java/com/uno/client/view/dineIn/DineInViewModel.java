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

/**
 * ViewModel class for Dine In
 * @version 1.0.0
 * @author Ondrej Klimek
 */

public class DineInViewModel {
    private MenuItems menuModel;
    private Tables tableModel;
    private MakeOrder orderModel;

    private StringProperty dietaryNeeds;
    private StringProperty comment;
    private ObservableList<MenuItem> menu;
    private ObservableList<Table> tables;

    /**
     * Constructor method
     * @param model takes MenuItems as a parameter
     * @param tableModel takes Tables as a parameter
     */

    public DineInViewModel(MenuItems model, Tables tableModel){
        this.menuModel = model;
        this.tableModel = tableModel;
    }

    /**
     * method that loads the menu items
     */

    public void loadMenu(){
        List<MenuItem> list = menuModel.getMenuItems();
        menu = FXCollections.observableArrayList(list);
    }

    /**
     * method that loads the tables
     */

    public void loadTables(){
        List<Table> list = tableModel.getTables();
        tables = FXCollections.observableArrayList(list);
    }

    /**
     * method that creates an order
     * @param order takes an order object as a parameter
     */

    public void createOrder(Order order){
        orderModel.createOrder(order);
    }

    /**
     * method that gets the menu items list
     * @return returns an observable list of menu items
     */

    public ObservableList<MenuItem> getMenu(){
        return menu;
    }

    /**
     * method that gets the tables list
     * @return returns an observable list of tables
     */

    public ObservableList<Table> getTables(){
        return tables;
    }

    /**
     * StringProperty
     * @return returns StringProperty
     */

    public StringProperty commentProperty() {
        return comment;
    }

    /**
     * StringProperty
     * @return returns StringProperty
     */

    public StringProperty dietaryNeedsProperty() {
        return dietaryNeeds;
    }

}
