package com.uno.client.core;

import com.uno.client.networking.Client;
import com.uno.client.networking.ClientImpl;

/**
 * A client factory class
 * @author Ondrej Klimek
 * @version 0.1.0
 */

public class ClientFactory {

    private Client client;

    /**
     * Constructor ClientFactory
     * @param client client
     */

    public ClientFactory(Client client){
        this.client = client;
    }

    /**
     * getter method
     * @return returns a client
     */

    public Client getClient(){
        if (client == null){
            client = new ClientImpl();
        }

        return client;
    }

}
