package com.Library.Accounts;

import com.Library.Database.DatabaseManager;
import com.Library.Utils.FileManager;
import java.sql.ResultSet;

/**
 * <h1>AccountTemplate</h1>
 * Abstraktní třída AccountTemplate
 * Šablona pro jednotlivé uživatele bez ohledu na oprávnění.
 * Implementuje interface AccountInterface
 *
 * @see AccountInterface
 *
 * @file AccountTemplate.java
 * @brief Šablona pro uživatele.
 *
 * @class AccountTemplate
 * @brief Třída definující šablonu uživatele.
 */
public abstract class AccountTemplate implements AccountInterface {
    /**
     * ID uživatele
     */
    protected String ID = "";
    /**
     * NAME uživatele
     */
    protected String NAME = "";
    /**
     * NICKNAME uživatele
     */
    protected String NICKNAME = "";
    /**
     * CREATION_TIME uživatele
     */
    protected String CREATION_TIME = "";
    /**
     * MODIFICATION_DATE uživatele
     */
    protected String MODIFICATION_DATE = "";
    /**
     * BORN uživatele
     */
    protected String BORN = "";
    /**
     * successLoad uživatele
     */
    protected boolean successLoad;
    /**
     * Oprávnění: p_showLibrary
     */
    protected boolean p_showLibrary = true;
    /**
     * Oprávnění: p_createOrder
     */
    protected boolean p_createOrder = true;
    /**
     * Oprávnění: p_createBook
     */
    protected boolean p_createBook = true;
    /**
     * Oprávnění: p_cart
     */
    protected boolean p_cart = true;
    /**
     * Oprávnění: p_logOut
     */
    protected boolean p_logOut = true;
    /**
     * Oprávnění: p_exit
     */
    protected boolean p_exit = true;
    /**
     * Oprávnění: p_permissions
     */
    protected boolean p_permissions = false;
    /**
     * Oprávnění: p_manage
     */
    protected boolean p_manage = false;

    /**
     * Kontruktor Šablony
     *
     * @param nickname Nickname parametr
     */
    public AccountTemplate(String nickname) {
        this.successLoad = this.loadDataFromDB(nickname);
    }

    /**
     * Metoda pro načtená dat o uživateli z databáze.
     *
     * @param nickname Nickname
     * @return vrací true/false
     */
    private boolean loadDataFromDB(String nickname) {
        String query = "SELECT * FROM accounts WHERE nickname=?";
        DatabaseManager databaseManager = new DatabaseManager();
        ResultSet set = databaseManager.getUserExistsSafe(query, nickname);
        boolean exists;
        try {
            exists = set.next();
            if (exists) {
                this.ID = set.getString("id");
                this.NAME = set.getString("name");
                this.NICKNAME = set.getString("nickname");
                this.CREATION_TIME = set.getString("creation_time");
                this.MODIFICATION_DATE = set.getString("modification_time");
                this.BORN = set.getString("borndate");
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            FileManager.log(e.toString());
            return false;
        }
    }

    /**
     * @return NICKNAME
     */
    public String getNICKNAME() {
        return this.NICKNAME;
    }

    /**
     * @return ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @return NAME
     */
    public String getNAME() {
        return NAME;
    }

    /**
     * @return CREATION_TIME
     */
    public String getCREATION_TIME() {
        return CREATION_TIME;
    }

    /**
     * @return MODIFICATION_DATE
     */
    public String getMODIFICATION_DATE() {
        return MODIFICATION_DATE;
    }

    /**
     * @return BORN
     */
    public String getBORN() {
        return BORN;
    }

    /**
     * @return Oprávnění uživatele
     */
    @Override
    public String getPermissions() {
        return "p_showLibrary: " + get_p_showLibrary() + "\r\n" +
                "p_createOrder: " + get_p_createOrder() + "\r\n" +
                "p_createBook: " + get_p_createBook() + "\r\n" +
                "p_search: " + get_p_cart() + "\r\n" +
                "p_logOut: " + get_p_logOut() + "\r\n" +
                "p_exit: " + get_p_exit() + "\r\n" +
                "p_permissions: " + get_p_permissions() + "\r\n" +
                "p_manage: " + get_p_manage() + "\r\n";
    }

    /**
     * @return p_showLibrary
     */
    @Override
    public boolean get_p_showLibrary() {
        return this.p_showLibrary;
    }

    /**
     * @return p_createOrder
     */
    @Override
    public boolean get_p_createOrder() {
        return this.p_createOrder;
    }

    /**
     * @return p_createBook
     */
    @Override
    public boolean get_p_createBook() {
        return this.p_createBook;
    }

    /**
     * @return p_cart
     */
    @Override
    public boolean get_p_cart() {
        return this.p_cart;
    }

    /**
     * @return p_logOut
     */
    @Override
    public boolean get_p_logOut() {
        return this.p_logOut;
    }

    /**
     * @return p_exit
     */
    @Override
    public boolean get_p_exit() {
        return this.p_exit;
    }

    /**
     * @return p_permissions
     */
    @Override
    public boolean get_p_permissions() {
        return this.p_permissions;
    }

    /**
     * @return p_manage
     */
    @Override
    public boolean get_p_manage() {
        return this.p_manage;
    }
}
