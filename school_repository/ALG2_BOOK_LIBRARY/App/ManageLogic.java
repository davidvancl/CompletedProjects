package com.Library.App;

import com.Library.Database.DatabaseManager;
import com.Library.Utils.FileManager;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <h1>ManageLogic</h1>
 * Abstraktní třída ManageLogic.
 * Obsahuje logiku grafické třídy Manage.
 * @see com.Library.GUI.Manage
 */
public abstract class ManageLogic {
    /**
     * Okno s výběrem URL adresy.
     * @return URL typu string / ""
     */
    public static String chooseDirectory(){
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Select directory");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getPath();
        }
        else {
            return "";
        }
    }

    public static String chooseFile(){
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Select file");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getPath();
        }
        else {
            return "";
        }
    }

    public static boolean importUser(String pathToFile){
        String thisLine = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pathToFile)));
            while ((thisLine = br.readLine()) != null) {
                String[] dataArray = thisLine.split("[\\s]([ ]{0,})[\\s]");
                RegisterLogic.registerUser(dataArray[1],dataArray[2],dataArray[0],dataArray[4].toCharArray(),dataArray[3]);
            }
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Metoda na export Objednávek
     * @param path cesta k souboru
     * @return true/false
     */
    public static boolean exportOrdersToTxt(String path){
        File export  = new File(path + "\\exportOrders.txt");
        FileManager.checkIfFileExists(export);

        DatabaseManager databaseManager = new DatabaseManager();
        String query = "SELECT * FROM `orders`";
        ResultSet set = databaseManager.getAllData(query);

        String formatStr = "%-5s %-15s %-15s %-20s %-20s %-900s%n";
        StringBuilder output = new StringBuilder();

        try {
            while (set.next()) {
                output.append(String.format(formatStr, set.getString("id"), set.getString("nickname"), set.getString("contact"),
                        set.getString("address"), set.getString("creation_time"), set.getString("books").replace("\r\n","")));
            }
        }catch (SQLException e){
            FileManager.log(e.toString());
        }

        FileManager.writeToFile(path + "\\exportOrders.txt",output.toString(),false);
        return true;
    }

    /**
     * Metoda pro export Uživatelů
     * @param path cesta
     * @return true/false
     */
    public static boolean exportUsersToTxt(String path){
        File export  = new File(path + "\\exportUsers.txt");
        FileManager.checkIfFileExists(export);

        DatabaseManager databaseManager = new DatabaseManager();
        String query = "SELECT * FROM `accounts`";
        ResultSet set = databaseManager.getAllData(query);

        String formatStr = "%-5s %-10s %-10s %-15s %-30s %-30s %-20s%n";
        StringBuilder output = new StringBuilder();

        try {
            while (set.next()) {
                output.append(String.format(formatStr, set.getString("id"), set.getString("name"), set.getString("surname"),
                        set.getString("nickname"), set.getString("creation_time"), set.getString("modification_time"),set.getString("borndate")));
            }
        }catch (SQLException e){
            FileManager.log(e.toString());
        }

        FileManager.writeToFile(path + "\\exportUsers.txt",output.toString(),false);
        return true;
    }

    /**
     * Metoda na export Knížek
     * @param path cesta
     * @return true/false
     */
    public static boolean exportBooksToTxt(String path){
        File export  = new File(path + "\\exportBooks.txt");
        FileManager.checkIfFileExists(export);

        DatabaseManager databaseManager = new DatabaseManager();
        String query = "SELECT * FROM `books`";
        ResultSet set = databaseManager.getAllData(query);

        String formatStr = "%-5s %-15s %-30s %-50s %-30s %-10s %-5s%n";
        StringBuilder output = new StringBuilder();

        try {
            while (set.next()) {
                output.append(String.format(formatStr, set.getString("id"), set.getString("BOOK_FIELD"), set.getString("BOOK_WRITER"),
                        set.getString("BOOK_NAME"), set.getString("BOOK_PUBLISHER"), set.getString("BOOK_PUBLICATION_YEAR"),set.getString("BOOK_PUBLICATION_NUMBER")));
            }
        }catch (SQLException e){
            FileManager.log(e.toString());
        }

        FileManager.writeToFile(path + "\\exportBooks.txt",output.toString(),false);
        return true;
    }

    /**
     * Metoda na ověření existence uživatele.
     * @param nickname nickname
     * @return true/false
     */
    public static boolean checkIfUserExists(String nickname){
        DatabaseManager databaseManager = new DatabaseManager();
        String testQuery = "SELECT nickname FROM `accounts` WHERE nickname=?";

        ResultSet set = databaseManager.getUserExistsSafe(testQuery,nickname);
        boolean exists = false;
        try {
            exists = set.next();
        } catch (Exception e) {
            FileManager.log(e.toString());
        }

        return exists;
    }

    /**
     * Metoda na nastavení oprávnění.
     * @param nickname nickname uživatele
     * @param permissions nové oprávnění
     */
    public static void setUserPermissions(String nickname,String permissions){
        DatabaseManager databaseManager = new DatabaseManager();
        String query_permissions = "UPDATE acc_permissions SET acc_type=? WHERE nickname=?";
        databaseManager.setUserPermissions(query_permissions,permissions,nickname);
    }
}
