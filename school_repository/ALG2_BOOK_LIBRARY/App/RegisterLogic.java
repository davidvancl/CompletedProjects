package com.Library.App;

import com.Library.Database.DatabaseManager;
import com.Library.Utils.FileManager;
import com.Library.Utils.FormUtils;
import java.sql.ResultSet;

/**
 * <h1>RegisterLogic</h1>
 * Abstraktní třída RegisterLogic
 * Vychází z tabu Register
 *
 * @file RegisterLogic.java
 * @brief Logika aplikovaná v Register.
 *
 * @class RegisterLogic
 * @brief Logika registrace.
 *
 * @see com.Library.GUI.Register
 *
 * Balíček:
 * @see com.Library.App
 */
public abstract class RegisterLogic {

    /**
     * Metoda, která zaregistuje uživatele.
     *
     * @param name Jméno uživatele.
     * @param surname Přijmení uživatele.
     * @param nickname nickname uživatele.
     * @param password Heslo uživatele.
     * @param date Datum narození uživatele.
     * @return Vrací true/false, pokud byl nebo nebyl zaregistrován.
     */
    public static boolean registerUser(String name,String surname, String nickname, char[] password,String date) {
        DatabaseManager databaseManager = new DatabaseManager();
        String testQuery = "SELECT nickname FROM `accounts` WHERE nickname=?";

        ResultSet set = databaseManager.getUserExistsSafe(testQuery,nickname);
        boolean exists = false;
        try {
            exists = set.next();
        } catch (Exception e) {
            FileManager.log(e.toString());
        }

        if (!exists) {
            String encodedhash = FormUtils.bytesToHex(FormUtils.hashToSha256(new String(password)));
            String query = "INSERT INTO accounts VALUES (0,?,?,?,?,CURRENT_TIME(),CURRENT_TIME(),?)";
            databaseManager.registerUserSafe(query,name,surname,nickname,encodedhash,date);
            String query_permissions = "INSERT INTO acc_permissions VALUES (0,?,?,CURRENT_TIME())";
            databaseManager.setUserPermissions(query_permissions,nickname,"User");
            return true;
        }
        return false;
    }
}
