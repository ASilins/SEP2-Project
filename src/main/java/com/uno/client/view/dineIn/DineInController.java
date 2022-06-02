package com.uno.client.view.dineIn;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.view.ViewController;
import com.uno.shared.transferobjects.MenuItem;
import com.uno.shared.transferobjects.Table;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Controller for Dine in order views
 * @version 1.0.0
 * @author Ondrej Klimek
 */

public class DineInController implements ViewController {

    @FXML private Button backBtn;
    @FXML private Button orderBtn;
    @FXML private Button addToOrderBtn;
    @FXML private Button removeFromOrderBtn;
    @FXML private TextArea dietaryNeeds;
    @FXML private TextArea comment;
    @FXML private TableView<MenuItem> menuTable;
    @FXML private TableColumn<MenuItem, String> itemNameMenu;
    @FXML private TableColumn<MenuItem, Integer> priceMenu;
    @FXML private TableView<MenuItem> orderTable;
    @FXML private TableColumn<MenuItem, String> itemNameOrder;
    @FXML private TableColumn<MenuItem, Integer> priceOrder;
    @FXML private ChoiceBox<Table> tableBox;

    private ViewHandler viewHandler;
    private DineInViewModel viewModel;

    /**
     * method initializing the controller
     * @param viewHandler takes a ViewHandler as a parameter
     * @param vmf takes a ViewModelFactory as a parameter
     */

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory vmf) {

        viewModel = vmf.getDineInViewModel();
        this.viewHandler = viewHandler;

        dietaryNeeds.textProperty().bindBidirectional(viewModel.dietaryNeedsProperty());
        comment.textProperty().bindBidirectional(viewModel.commentProperty());
        menuTable.setItems(viewModel.getMenu());
        itemNameMenu.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceMenu.setCellValueFactory(new PropertyValueFactory<>("price"));
        itemNameOrder.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceOrder.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableBox.setItems(viewModel.getTables());
    }

    /**
     * a method to add an item to an order
     */

    public void addToOrder(){
        orderTable.getItems().add(menuTable.getSelectionModel().getSelectedItem());
        orderTable.refresh();
    }

    /**
     * a method to remove an item from an order
     */

    public void removeFromOrder(){
        orderTable.getItems().remove(orderTable.getSelectionModel().getSelectedItem());
        orderTable.refresh();
    }

    /**
     * an onAction method to go to the previous window
     */

    public void back(){
        //open staffView
    }

    /**
     * an onAction method to finish an order
     */

    public void order(){
        //send order
    }

}
