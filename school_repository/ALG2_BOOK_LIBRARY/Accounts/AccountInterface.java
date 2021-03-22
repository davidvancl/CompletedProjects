package com.Library.Accounts;

/**
 * Interface definující vzhled uživatelů.
 * @see AccountTemplate
 *
 * @file AccountInterface.java
 * @brief Definice nutných metod uživatele.
 *
 * @class AccountInterface
 * @brief Interface pro uživatele.
 */
public interface AccountInterface {
    boolean get_p_showLibrary();
    boolean get_p_createOrder();
    boolean get_p_cart();
    boolean get_p_logOut();
    boolean get_p_exit();
    boolean get_p_createBook();
    boolean get_p_permissions();
    boolean get_p_manage();

    String getPermissions();
    void setPermissions(boolean showLibrary,boolean createOrder,boolean createBook, boolean cart, boolean logOut, boolean exit ,boolean permissions,boolean manage);
    String getDataAsString();
}
