package com.uno.client.core;

import com.uno.client.view.menuItem.MenuItemViewModel;
import com.uno.client.view.order.MakeOrderViewModel;

public class ViewModelFactory {

  private final ModelFactory modelFactory;
  private MenuItemViewModel MenuItemViewModel;
  private MakeOrderViewModel makeOrderViewModel;

  public ViewModelFactory(ModelFactory modelFactory) {
    this.modelFactory = modelFactory;
  }

  public MenuItemViewModel getMenuItemViewModel(){
    if(menuItemViewModel == null){
      menuItemViewModel = new MenuItemViewModel(modelFactory.getMenuItem());
    }
    return menuItemViewModel;
  }

  public MakeOrderViewModel getMakeOrderViewModel(){
    if(makeOrderViewModel == null){
      makeOrderViewModel = new MakeOrderViewModel(modelFactory.getMakeOrder());
    }
    return makeOrderViewModel;
  }
}
