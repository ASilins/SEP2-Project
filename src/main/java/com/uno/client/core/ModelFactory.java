package com.uno.client.core;

import com.uno.client.model.MakeOrder;
import com.uno.client.model.MakeOrderImpl;
import com.uno.client.model.MenuItems;
import com.uno.client.core.ClientFactory;
import com.uno.client.model.MenuItemsImpl;
import com.uno.client.model.Tables;
import com.uno.client.model.TablesImpl;

/**
 * A model factory class
 * @author Ondrej Klimek, Siddhartha Grasse
 * @version 0.2.0
 */

public class ModelFactory {

    private final ClientFactory clientFactory;
    private MakeOrder makeOrder;
    private MenuItems menuItems;
    private Tables tables;

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

    /**
     * getter method for Tables
     * @return returns an instance of Tables
     */
    public Tables getTables()
    {
        if(tables == null)
        {
            tables = new TablesImpl(clientFactory.getClient());
        }
        return tables;
    }


}
