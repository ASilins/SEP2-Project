package com.uno.client.view.takeout.guest;

import com.uno.client.core.ViewHandler;
import com.uno.client.core.ViewModelFactory;
import com.uno.client.view.ViewController;
import com.uno.client.view.dineIn.DineInViewModel;
import com.uno.shared.transferobjects.MenuItem;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class TakeOutGuestController implements ViewController {

    @FXML private TextField phoneTextField;
    @FXML private DatePicker datePicker;
    @FXML private TableView<MenuItem> menuTableView;
    @FXML private TableColumn<MenuItem, String> nameMenu;
    @FXML private TableColumn<MenuItem, Integer> priceMenu;
    @FXML private TableView<MenuItem> orderTableView;
    @FXML private TableColumn<MenuItem, String> nameOrder;
    @FXML private TableColumn<MenuItem, Integer> priceOrder;
    @FXML private TextField dietaryNeedsText;
    @FXML private TextField commentText;

    private ViewHandler viewHandler;
    private TakeOutViewModel viewModel;

    @Override
    public void init(ViewHandler viewHandler, ViewModelFactory vmf) {
        viewModel = vmf.getTakeOutViewModel();
        this.viewHandler = viewHandler;

        phoneTextField.textProperty().bindBidirectional(viewModel.phoneProperty());
        datePicker.valueProperty().bindBidirectional(viewModel.dateProperty());
        menuTableView.setItems(viewModel.getMenu());
        nameMenu.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceMenu.setCellValueFactory(new PropertyValueFactory<>("price"));
        nameOrder.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceOrder.setCellValueFactory(new PropertyValueFactory<>("price"));
        dietaryNeedsText.textProperty().bindBidirectional(viewModel.dietaryNeedsProperty());
        commentText.textProperty().bindBidirectional(viewModel.commentProperty());
    }

    public void addToOrder(){
        orderTableView.getItems().add(menuTableView.getSelectionModel().getSelectedItem());
        orderTableView.refresh();
    }

    public void removeFromOrder(){
        orderTableView.getItems().remove(orderTableView.getSelectionModel().getSelectedItem());
        orderTableView.refresh();
    }

}
