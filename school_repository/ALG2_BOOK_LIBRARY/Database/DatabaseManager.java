package com.Library.Database;

import com.Library.Utils.FileManager;

import java.sql.*;
import java.util.ArrayList;

/**
 * <h1>DatabaseManager</h1>
 * Třída pro manipulaci s databází.
 * Dědí z třídy DatabaseData, kde jsou data o přístupu k DB.
 *
 * @file DatabaseManager.java
 * @brief Třída pro práci se soubory.
 *
 * @class DatabaseManager
 * @brief Třída manipulující s databází.
 *
 * @see DatabaseData
 */
public class DatabaseManager extends DatabaseData {
    /**
     * Statement informace
     *
     * @see Statement
     */
    private Statement s = null;
    /**
     * Connection Informace
     *
     * @see Connection
     */
    private Connection c = null;

    /**
     * Metoda vztvoří spojení s databází.
     */
    public DatabaseManager() {
        try {
            c = DriverManager.getConnection(databaseURL, user, password);
            c.setAutoCommit(true);
            this.s = c.createStatement();
        } catch (Exception e) {
            FileManager.log(e.toString());
        }
    }

    /**
     * Uzavírá spojení s databaází.
     */
    public void closeConnection() {
        try {
            this.c.close();
        } catch (Exception e) {
            FileManager.log(e.toString());
        }
    }

    /**
     * Metoda vytvoří SQL s opatřením proti SQL injection.
     * Executne command vůči DB.
     *
     * @param query    SQL
     * @param name     Jméno
     * @param surname  Přijmení
     * @param nickname Nickname
     * @param password Heslo
     * @param date     Datum narození
     */
    public void registerUserSafe(String query, String name, String surname, String nickname, String password, String date) {
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, surname);
            stmt.setString(3, nickname);
            stmt.setString(4, password);
            stmt.setString(5, date);
            stmt.executeUpdate();
        } catch (Exception e) {
            FileManager.log(e.toString());
        }
    }

    /**
     * Metoda pro nastavení oprávnění.
     *
     * @param query SQL
     * @param name  Jméno
     * @param type  Nový typ
     */
    public void setUserPermissions(String query, String type, String name) {
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement(query);
            stmt.setString(1, type);
            stmt.setString(2, name);
            stmt.executeUpdate();
        } catch (Exception e) {
            FileManager.log(e.toString());
        }
    }

    /**
     * Metoda vztváří záznam v databázi Order.
     *
     * @param query    SQL
     * @param nickname Nicname
     * @param contact  Kontakt
     * @param address  Adresa
     * @param books    Košík knih
     */
    public void setOrderSafe(String query, String nickname, String contact, String address, String books) {
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement(query);
            stmt.setString(1, nickname);
            stmt.setString(2, contact);
            stmt.setString(3, address);
            stmt.setString(4, books);
            stmt.executeUpdate();
        } catch (Exception e) {
            FileManager.log(e.toString());
        }
    }

    /**
     * Metoda ověří jestli uživatel existuje.
     *
     * @param query    SQL
     * @param nickname Nickname
     * @return data o nalezení
     */
    public ResultSet getUserExistsSafe(String query, String nickname) {
        ResultSet set = null;
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement(query);
            stmt.setString(1, nickname);
            set = stmt.executeQuery();
        } catch (Exception e) {
            FileManager.log(e.toString());
        }
        return set;
    }

    /**
     * Ověří zadané data.
     *
     * @param query    SQL
     * @param nickname Nickname
     * @param password Heslo
     * @return vrací nalezené data.
     */
    public ResultSet loginDataCheck(String query, String nickname, String password) {
        ResultSet set = null;
        try (PreparedStatement stmt = c.prepareStatement(query)) {
            stmt.setString(1, nickname);
            stmt.setString(2, password);
            set = stmt.executeQuery();
        } catch (Exception e) {
            FileManager.log(e.toString());
        }
        return set;
    }

    /**
     * Metoda pro vzhledávání bez omezení
     *
     * @param query SQL
     * @return vrací nalezené data
     */
    public ResultSet getAllData(String query) {
        ResultSet set = null;
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement(query);
            set = stmt.executeQuery();
        } catch (Exception e) {
            FileManager.log(e.toString());
        }
        return set;
    }

    /**
     * Metoda pro dynamické vytváření SQL.
     *
     * @param query  SQL
     * @param params parametry
     * @return vrací nalezené data
     */
    public ResultSet getDynamicData(String query, ArrayList<String> params) {
        ResultSet set = null;
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement(query);
            for (int i = 0; i < params.size(); i++) {
                stmt.setString(i + 1, "%" + params.get(i) + "%");
            }
            set = stmt.executeQuery();
        } catch (Exception e) {
            FileManager.log(e.toString());
            System.out.println(e.toString());
        }
        return set;
    }

    public ResultSet getDynamicData(String query, String param) {
        ResultSet set = null;
        PreparedStatement stmt = null;
        try {
            stmt = c.prepareStatement(query);
            stmt.setString(1, param);
            set = stmt.executeQuery();
        } catch (Exception e) {
            FileManager.log(e.toString());
            System.out.println(e.toString());
        }
        return set;
    }
}
