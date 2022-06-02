package com.uno.client.core;

import com.uno.client.view.account.editUser.EditUserViewModel;
import com.uno.client.view.account.viewUsers.ViewUsersViewModel;
import com.uno.client.view.bookings.ViewBookingsViewModel;
import com.uno.client.view.account.createaccount.CreateAccountViewModel;
import com.uno.client.view.bookings.editBookings.EditBookingViewModel;
import com.uno.client.view.order.editOrder.EditOrderViewModel;
import com.uno.client.view.account.login.LoginViewModel;
import com.uno.client.view.menuItem.MenuItemViewModel;
import com.uno.client.view.order.MakeOrderViewModel;
import com.uno.client.view.order.viewOrders.ViewOrdersViewModel;
import com.uno.client.view.tables.createTable.CreateTableViewModel;
import com.uno.client.view.tables.editTable.EditTableViewModel;
import com.uno.client.view.tables.viewTables.ViewTablesViewModel;

public class ViewModelFactory {

  private final ModelFactory modelFactory;

  private MenuItemViewModel menuItemViewModel;
  private MakeOrderViewModel makeOrderViewModel;
  private CreateAccountViewModel createAccountViewModel;
  private LoginViewModel loginViewModel;
  private ViewOrdersViewModel viewOrdersViewModel;
  private EditOrderViewModel editOrderViewModel;
  private ViewBookingsViewModel viewBookingsViewModel;
  private EditBookingViewModel editBookingViewModel;
  private ViewTablesViewModel viewTablesViewModel;
  private EditTableViewModel editTableViewModel;
  private CreateTableViewModel createTableViewModel;
  private EditUserViewModel editUserViewModel;
  private ViewUsersViewModel viewUsersViewModel;

  public ViewModelFactory(ModelFactory modelFactory) {
    this.modelFactory = modelFactory;
  }

  public MenuItemViewModel getMenuItemViewModel(){
    if(menuItemViewModel == null){
      menuItemViewModel = new MenuItemViewModel(modelFactory.getMenuItems());
    }

    return menuItemViewModel;
  }

  public MakeOrderViewModel getMakeOrderViewModel(){
    if(makeOrderViewModel == null){
      makeOrderViewModel = new MakeOrderViewModel(modelFactory.getMakeOrder());
    }

    return makeOrderViewModel;
  }

  public CreateAccountViewModel getCreateAccountViewModel() {
    if (createAccountViewModel == null) {
      createAccountViewModel = new CreateAccountViewModel(modelFactory.getAccountModel());
    }

    return createAccountViewModel;
  }

  public LoginViewModel getLoginViewModel() {
    if (loginViewModel == null) {
      loginViewModel = new LoginViewModel(modelFactory.getAccountModel());
    }

    return loginViewModel;
  }

  public ViewOrdersViewModel getViewOrdersViewModel() {
    if (viewOrdersViewModel == null) {
      viewOrdersViewModel = new ViewOrdersViewModel(modelFactory.getMakeOrder());
    }

    return viewOrdersViewModel;
  }

  public EditOrderViewModel getEditOrderViewModel() {
    if (editOrderViewModel == null) {
      editOrderViewModel = new EditOrderViewModel(modelFactory.getMakeOrder());
    }

    return editOrderViewModel;
  }

  public ViewBookingsViewModel getViewBookingsViewModel() {
    if (viewBookingsViewModel == null) {
      viewBookingsViewModel = new ViewBookingsViewModel(modelFactory.getReservationModel());
    }

    return viewBookingsViewModel;
  }

  public EditBookingViewModel getEditBookingViewModel() {
    if (editBookingViewModel == null) {
      editBookingViewModel = new EditBookingViewModel(modelFactory.getReservationModel());
    }

    return editBookingViewModel;
  }

  public ViewTablesViewModel getViewTablesViewModel() {
    if (viewTablesViewModel == null) {
      viewTablesViewModel = new ViewTablesViewModel(modelFactory.getTables());
    }

    return viewTablesViewModel;
  }

  public EditTableViewModel getEditTableViewModel() {
    if (editTableViewModel == null) {
      editTableViewModel = new EditTableViewModel(modelFactory.getTables());
    }

    return editTableViewModel;
  }

  public CreateTableViewModel getCreateTableViewModel() {
    if (createTableViewModel == null) {
      createTableViewModel = new CreateTableViewModel(modelFactory.getTables());
    }

    return createTableViewModel;
  }

  public ViewUsersViewModel getViewUsersViewModel() {
    if (viewUsersViewModel == null) {
      viewUsersViewModel = new ViewUsersViewModel(modelFactory.getAccountModel());
    }

    return viewUsersViewModel;
  }

  public EditUserViewModel getEditUserViewModel() {
    if (editUserViewModel == null) {
      editUserViewModel = new EditUserViewModel(modelFactory.getAccountModel());
    }

    return editUserViewModel;
  }
}
