package com.Library.Accounts;

/**
 * <h1>SuperUser</h1>
 * Třída SuperUser pro uživatele s daným opravněním
 * Dědí z abstraktní třídy AccountTemplate
 * @see SuperUser
 *
 * @file SuperUser.java
 * @brief Definice SuperUser
 *
 * @class SuperUser
 * @brief Třída definující Super uživatele.
 */
public class SuperUser extends AccountTemplate {

    /**
     * Konstruktor pro SuperUser
     * @param nickname Nickanme
     * Přepíše nutná oprávnění
     */
    public SuperUser(String nickname){
        super(nickname);
        p_permissions = true;
        p_manage = true;
    }

    /**
     * Metoda pro nastavení oprávění pro zobrazení.
     *
     * @param showLibrary (true/false) showLibrary
     * @param createOrder (true/false) createOrder
     * @param createBook (true/false) createBook
     * @param cart (true/false) cart
     * @param logOut (true/false) logOut
     * @param exit (true/false) exit
     * @param permissions (true/false) permissions
     * @param manage (true/false) manage
     */
    @Override
    public void setPermissions(boolean showLibrary,boolean createOrder,boolean createBook, boolean cart, boolean logOut, boolean exit ,boolean permissions,boolean manage) {
        p_showLibrary = showLibrary;
        p_createOrder = createOrder;
        p_createBook = createBook;
        p_cart = cart;
        p_logOut = logOut;
        p_exit = exit;
        p_permissions = permissions;
        p_manage = manage;
    }

    /**
     * Metoda pro výpis dat o uživately.
     * @return String dat.
     */
    @Override
    public String getDataAsString() {
        return "SuperUser{" +
                "ID='" + ID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", NICKNAME='" + NICKNAME + '\'' +
                ", CREATION_TIME='" + CREATION_TIME + '\'' +
                ", MODIFICATION_DATE='" + MODIFICATION_DATE + '\'' +
                ", BORN='" + BORN + '\'' +
                ", successLoad=" + successLoad +
                ", p_showLibrary=" + p_showLibrary +
                ", p_createOrder=" + p_createOrder +
                ", p_createBook=" + p_createBook +
                ", p_search=" + p_cart +
                ", p_logOut=" + p_logOut +
                ", p_exit=" + p_exit +
                ", p_permissions=" + p_permissions +
                ", p_manage=" + p_manage +
                '}';
    }
}
