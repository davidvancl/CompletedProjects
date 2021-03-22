package com.Library.App;

import com.Library.Accounts.ClassicUser;
import com.Library.Accounts.SuperUser;
import com.Library.Database.DatabaseManager;
import com.Library.GUI.Login;
import com.Library.Utils.FileManager;
import com.Library.Utils.FormUtils;

import java.sql.ResultSet;

/**
 * <h1>LoginLogic</h1>
 * Abstraktní třída LoginLogic
 * Logika tabu Login
 *
 * @see Login
 *
 * @file LoginLogic.java
 * @brief Logika aplikovaná v Login.
 *
 * @class LoginLogic
 * @brief Logika přihlášení.
 */
public abstract class LoginLogic {
    /**
     * Metoda pro ověření platnosti loginu
     *
     * @param login      Panel Login.
     * @param nickname   Zadaný nickname.
     * @param password   Heslo uživatele.
     * @param isRemember Jesli se má uživatel pamatovat nebo ne.
     * @return 0 - úspěch,500 - error
     */
    public static int checkLogin(Login login, String nickname, char[] password, boolean isRemember) {
        String query = "SELECT accounts.nickname,passwd,acc_type FROM accounts LEFT JOIN acc_permissions ON accounts.nickname = acc_permissions.nickname WHERE accounts.nickname=? AND passwd=?";
        String hashedPassword = FormUtils.bytesToHex(FormUtils.hashToSha256(new String(password)));
        DatabaseManager databaseManager = new DatabaseManager();
        ResultSet set = databaseManager.loginDataCheck(query, nickname, hashedPassword);
        boolean exists = false;

        String type = "";
        try {
            exists = set.next();
            type = set.getString("acc_type");
        } catch (Exception e) {
            FileManager.log(e.toString());
        }

        boolean logSuccess = false;
        if (exists) {
            LoginLogic.logIn(login, nickname, password, isRemember, type);
            logSuccess = true;
        }

        if (logSuccess) {
            return 0; //SUCCESS
        } else {
            return 500;
        }

    }

    /**
     * Metoda překlapne okna z Login na Menu.
     *
     * @param login      Login tab.
     * @param nickname   Nickname uživatele.
     * @param password   Heslo uživatele.
     * @param isSelected Zda je vybrán.
     * @param typeAcc    Typ účtu.
     * @return
     * @see Login
     * @see com.Library.GUI.Menu
     * Nastaví uživatele a zapíše pokud se má pamatovat.
     * @see FileManager
     * @see AppGUI
     */
    private static boolean logIn(Login login, String nickname, char[] password, boolean isSelected, String typeAcc) {
        login.frame.swapScreen(login.frame.getLogin(), login.frame.getMenu());

        if (typeAcc.equals("SuperUser")) {
            AppGUI.account = new SuperUser(nickname);
        } else {
            AppGUI.account = new ClassicUser(nickname);
        }

        if (isSelected) {
            FileManager.encrypt("[" + nickname + "," + new String(password) + "]", login.getKey());
            FileManager.log("User has been encrypted for later login.");
        }
        FileManager.log(nickname + " signed in.");
        login.clearForm();

        return true;
    }
}
