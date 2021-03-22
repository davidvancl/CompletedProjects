package com.Library.Database;

/**
 * <h1>DatabaseData</h1>
 * Abstraktní třída DatabaseData
 * Obsahuje data připojení k databázi.
 *
 * @file DatabaseData.java
 * @brief Data k DB.
 *
 * @class DatabaseData
 * @brief Třída s daty k DB.
 *
 */
public abstract class DatabaseData {

    /**
     * Aktuálně nepoužívaný driver k DB.
     */
    protected static String driver = "com.mysql.jdbc.Driver";
    /**
     * Url adresa k databázi.
     */
    protected static String databaseURL = "jdbc:mysql://localhost:3306/library";
    /**
     * Jméno uživatele pro přístup do databáze.
     */
    protected static String user = "root";
    /**
     * Heslo uživatele pro přístup do databáze.
     */
    protected static String password = "";
}
