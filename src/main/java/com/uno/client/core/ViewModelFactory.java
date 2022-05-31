package com.uno.client.core;

import com.uno.client.view.createaccount.CreateAccountViewModel;
import com.uno.client.view.login.LoginViewModel;
import com.uno.client.view.menuItem.MenuItemViewModel;
import com.uno.client.view.order.MakeOrderViewModel;

public class ViewModelFactory {

  private final ModelFactory modelFactory;

  private MenuItemViewModel menuItemViewModel;
  private MakeOrderViewModel makeOrderViewModel;
  private CreateAccountViewModel createAccountViewModel;
  private LoginViewModel loginViewModel;

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
}
