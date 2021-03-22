package com.Library.App;

import com.Library.Database.DatabaseManager;
import com.Library.GUI.MyOrders;
import com.Library.Utils.FileManager;
import com.Library.Utils.OrderItem;

import java.sql.ResultSet;

public abstract class MyOrderLogic {

    public static void getOrderByUser(MyOrders myOrders,String nickname) {
        String SQL = "SELECT * FROM orders WHERE nickname=?";
        DatabaseManager databaseManager = new DatabaseManager();
        ResultSet set = databaseManager.getDynamicData(SQL, nickname);
        try {
            while (set.next()) {
                myOrders.dataPanel.addItemO(new OrderItem(new String[]{set.getString("contact"),set.getString("address"),set.getString("books"),set.getString("creation_time")}));
            }
        } catch (Exception e){
            FileManager.log(e.toString());
        }
    }
}
