package com.Library.Accounts;

import com.Library.Utils.FileManager;

/**
 * <h1>ClassicUser</h1>
 * Třída pro normální uživatele.
 * Dědí z abstraktní třídy AccountTemplate
 * @see AccountTemplate
 *
 * Balíček:
 * @see com.Library.Utils.FileManager
 *
 * @file ClassicUser.java
 * @brief Definice ClassicUser
 *
 * @class ClassicUser
 * @brief Třída definující uživatele.
 */
public class ClassicUser extends AccountTemplate{

    /**
     * Konstruktor ClassicUser
     * @param userName Uživatelské jméno
     */
    public ClassicUser(String userName){
        super(userName);
    }

    /**
     * Uživatel nemá oprávnění na změnu.
     * Zaloguje pokus o změnu.
     *
     * @param showLibrary false
     * @param createOrder false
     * @param createBook false
     * @param search false
     * @param logOut false
     * @param exit false
     * @param permissions false
     * @param manage false
     */
    @Override
    public void setPermissions(boolean showLibrary,boolean createOrder,boolean createBook, boolean search, boolean logOut, boolean exit ,boolean permissions,boolean manage) {
        FileManager.log("You don´t have permissions.");
    }
    /**
     * Metoda pro výpis dat o uživately.
     * @return String dat.
     */
    @Override
    public String getDataAsString() {
        return "ClassicUser{" +
                "ID='" + ID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", NICKNAME='" + NICKNAME + '\'' +
                ", CREATION_TIME='" + CREATION_TIME + '\'' +
                ", BORN='" + BORN + '\'' +
                '}';
    }
}
