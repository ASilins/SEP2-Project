package com.uno.client.core;

import com.uno.client.view.bookings.ViewBookingsViewModel;
import com.uno.client.view.account.createaccount.CreateAccountViewModel;
import com.uno.client.view.dineIn.DineInViewModel;
import com.uno.client.view.order.editOrder.EditOrderViewModel;
import com.uno.client.view.account.login.LoginViewModel;
import com.uno.client.view.menuItem.MenuItemViewModel;
import com.uno.client.view.order.MakeOrderViewModel;
import com.uno.client.view.order.viewOrders.ViewOrdersViewModel;

public class ViewModelFactory {

  private final ModelFactory modelFactory;

  private MenuItemViewModel menuItemViewModel;
  private MakeOrderViewModel makeOrderViewModel;
  private CreateAccountViewModel createAccountViewModel;
  private LoginViewModel loginViewModel;
  private ViewOrdersViewModel viewOrdersViewModel;
  private EditOrderViewModel editOrderViewModel;
  private ViewBookingsViewModel viewBookingsViewModel;
  private DineInViewModel dineInViewModel;

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

  public DineInViewModel getDineInViewModel(){
    if (dineInViewModel == null){
      dineInViewModel = new DineInViewModel(modelFactory.getMenuItems());
    }

    return dineInViewModel;
  }
}
