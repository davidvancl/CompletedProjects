package com.Library.App;

import com.Library.Database.DatabaseManager;
import com.Library.Utils.CartItem;
import com.Library.Utils.FileManager;
import com.Library.Utils.FormUtils;
import java.sql.ResultSet;

/**
 * <h1>OrderLogic</h1>
 * Abstraktní třída OrderLogic.
 * Vychází z Order tabu.
 * @see com.Library.GUI.Order
 *
 * @file OrderLogic.java
 * @brief Logika aplikovaná v Order.
 *
 * @class OrderLogic
 * @brief Logika objednávky.
 */
public abstract class OrderLogic {
    /**
     * Metoda na ověření uživatele.
     *
     * @param nickname Nickname přihlášeného uživatele.
     * @param password Heslo přihlášeného uživatele.
     * @return vrací true/false
     */
    public static boolean checkPassword(String nickname,String password){
        String hashedPassword = FormUtils.bytesToHex(FormUtils.hashToSha256(new String(password)));
        DatabaseManager databaseManager = new DatabaseManager();
        String query = "SELECT * FROM accounts WHERE nickname=? AND passwd=? ";
        ResultSet set = databaseManager.loginDataCheck(query,nickname,hashedPassword);
        boolean exists = false;
        try {
            exists = set.next();
        } catch (Exception e) {
            FileManager.log(e.toString());
        }
        return exists;
    }

    /**
     * Metoda pro zápis obědnávky
     *
     * @param nickname Nickanme uživatele.
     * @param contact Kontakt na uživatele.
     * @param address Adresa uživatele.
     * @return vrátí true/false podle toho zda byla objednávka zapsána nebo ne.
     */
    public static boolean writeOrder(String nickname,String contact,String address){
        String query = "INSERT INTO orders VALUES (0,?,?,?,?,CURRENT_TIME())";
        DatabaseManager databaseManager = new DatabaseManager();
        StringBuilder list = new StringBuilder();
        for(CartItem item : AppGUI.cartList){
            list.append("[").append(item.getBookName()).append(':').append(item.getBookWriter()).append("]").append("\r\n");
        }
        databaseManager.setOrderSafe(query,nickname,contact,address,list.toString());
        AppGUI.cartList.clear();
        return true;
    }
}
