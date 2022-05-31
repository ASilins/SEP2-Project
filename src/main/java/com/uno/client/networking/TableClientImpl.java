package com.uno.client.networking;

import com.uno.shared.networking.Server;
import com.uno.shared.networking.TableServer;
import com.uno.shared.transferobjects.Order;
import com.uno.shared.transferobjects.Table;

import java.rmi.RemoteException;

/**
 * class for table client
 * @author Arturs Silins, Siddhartha Grasse, Bhupas Gautam
 * @version 0.2.0
 */

public class TableClientImpl implements TableClient{

    private TableServer server;

    /**
     * constructor for OrderClientImpl
     * @param server takes an order as a parameter
     */
    public TableClientImpl(Server server){
        try {
            this.server = server.getTableServer();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to create a table booking
     * @param table takes a table as a parameter
     * @throws RemoteException If it is not possible to receive the object.
     */
    @Override
    public void bookTable(Table table) throws RemoteException {
        server.bookTable(table);
    }

    /**
     * Method to edit the table booking
     * @param oldBooking takes the information form old booking
     * @param newBooking send out the information for new booking
     */
    @Override
    public void editTableBooking(Table oldBooking, Table newBooking) {
//        The fuk is this???

    }
}
