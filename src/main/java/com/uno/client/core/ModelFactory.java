package com.uno.client.core;

import com.uno.client.model.MakeOrder;
import com.uno.client.model.MakeOrderImpl;
import com.uno.client.model.MenuItems;
import com.uno.client.core.ClientFactory;
import com.uno.client.model.MenuItemsImpl;

public class ModelFactory {

    private final ClientFactory clientFactory;
    private MakeOrder makeOrder;
    private MenuItems menuItems;

    /**
     * constructor for ModelFactory
     * @param clientFactory takes client factory as a parameter
     */

    public ModelFactory(ClientFactory clientFactory){
        this.clientFactory = clientFactory;
    }

    /**
     * getter method for MakeOrder
     * @return returns an instance of MakeOrder
     */

    public MakeOrder getMakeOrder(){
        if (makeOrder == null){
            makeOrder = new MakeOrderImpl(clientFactory.getClient());
        }

        return makeOrder;
    }

    /**
     * getter method for MenuItems
     * @return returns an instance of MenuItems
     */

    public MenuItems getMenuItems(){
        if (menuItems == null){
            menuItems = new MenuItemsImpl(clientFactory.getClient());
        }

        return menuItems;
    }

}
