package com.uno.client.core;

import com.uno.client.view.bookings.ViewBookingsViewModel;
import com.uno.client.view.account.createaccount.CreateAccountViewModel;
import com.uno.client.view.order.editOrder.EditOrderViewModel;
import com.uno.client.view.account.login.LoginViewModel;
import com.uno.client.view.menuItem.MenuItemViewModel;
import com.uno.client.view.order.MakeOrderViewModel;
import com.uno.client.view.order.viewOrders.ViewOrdersViewModel;

/**
 * A model factory class
 * @author Maximillian Wallin, Arturs Silins
 * @version 1.0.0
 */

public class ViewModelFactory {

  private final ModelFactory modelFactory;

  private MenuItemViewModel menuItemViewModel;
  private MakeOrderViewModel makeOrderViewModel;
  private CreateAccountViewModel createAccountViewModel;
  private LoginViewModel loginViewModel;
  private ViewOrdersViewModel viewOrdersViewModel;
  private EditOrderViewModel editOrderViewModel;
  private ViewBookingsViewModel viewBookingsViewModel;

  /**
   * constructor for ViewModelFactory
   * @param modelFactory takes client factory as a parameter
   */

  public ViewModelFactory(ModelFactory modelFactory) {
    this.modelFactory = modelFactory;
  }

  /**
   * getter method for MenuItemViewModel
   * @return returns an instance of MenuItemViewModel
   */

  public MenuItemViewModel getMenuItemViewModel(){
    if(menuItemViewModel == null){
      menuItemViewModel = new MenuItemViewModel(modelFactory.getMenuItems());
    }

    return menuItemViewModel;
  }

  /**
   * getter method for MakeOrderViewModel
   * @return returns an instance of MakeOrderViewModel
   */

  public MakeOrderViewModel getMakeOrderViewModel(){
    if(makeOrderViewModel == null){
      makeOrderViewModel = new MakeOrderViewModel(modelFactory.getMakeOrder());
    }

    return makeOrderViewModel;
  }

  /**
   * getter method for CreateAccountViewModel
   * @return returns an instance of CreateAccountViewModel
   */

  public CreateAccountViewModel getCreateAccountViewModel() {
    if (createAccountViewModel == null) {
      createAccountViewModel = new CreateAccountViewModel(modelFactory.getAccountModel());
    }

    return createAccountViewModel;
  }

  /**
   * getter method for LoginViewModel
   * @return returns an instance of LoginViewModel
   */

  public LoginViewModel getLoginViewModel() {
    if (loginViewModel == null) {
      loginViewModel = new LoginViewModel(modelFactory.getAccountModel());
    }

    return loginViewModel;
  }

  /**
   * getter method for ViewOrdersViewModel
   * @return returns an instance of ViewOrdersViewModel
   */

  public ViewOrdersViewModel getViewOrdersViewModel() {
    if (viewOrdersViewModel == null) {
      viewOrdersViewModel = new ViewOrdersViewModel(modelFactory.getMakeOrder());
    }

    return viewOrdersViewModel;
  }

  /**
   * getter method for EditOrderViewModel
   * @return returns an instance of EditOrderViewModel
   */

  public EditOrderViewModel getEditOrderViewModel() {
    if (editOrderViewModel == null) {
      editOrderViewModel = new EditOrderViewModel(modelFactory.getMakeOrder());
    }

    return editOrderViewModel;
  }

  /**
   * getter method for ViewBookingsViewModel
   * @return returns an instance of ViewBookingsViewModel
   */

  public ViewBookingsViewModel getViewBookingsViewModel() {
    if (viewBookingsViewModel == null) {
      viewBookingsViewModel = new ViewBookingsViewModel(modelFactory.getReservationModel());
    }

    return viewBookingsViewModel;
  }
}
