package com.Library.Utils;

import com.Library.App.AppGUI;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * <h1>FileManager</h1>
 * Abstratkní třída pro manipulaci se soubory.
 *
 * @file FileManager.java
 * @brief Manipulace se vstupními a výstupními soubory.
 *
 * @class FileManager
 * @brief Abstratkní třída pro manipulaci se soubory.
 */
public abstract class FileManager {
    /**
     * Secret klíč pro šifrování a dešifrování.
     */
    private static SecretKeySpec secretKey;
    /**
     * Statická cesta k log file.
     */
    private static String pathLog = System.getenv("APPDATA") + "\\BookLibrary\\log.txt";
    /**
     * Statická cesta k přihlášenému uživateli.
     */
    public static String pathToUserData = System.getenv("APPDATA") + "\\BookLibrary\\loggedUser.txt";
    /**
     * Statická cesta ke zkopírovaným informacem.
     */
    public static String pathToClipBoard = System.getenv("APPDATA") + "\\BookLibrary\\clipBoard.txt";

    /**
     * Metoda pro logování aplikace.
     *
     * @param textToLog Text k zalogování.
     *                  Přidá prefix k log textu {@link #prefixData()}
     */
    public static void log(String textToLog) {
        String prefix = FileManager.prefixData();
        FileManager.writeToFile(FileManager.pathLog, prefix + " " + textToLog + "\r\n", true);
    }

    /**
     * Metoda pro zápis do specifikovaného souboru.
     *
     * @param path   cesta k souboru
     * @param data   data k zápisu
     * @param append přidání či přepsání
     */
    public static void writeToFile(String path, String data, boolean append) {
        try {
            File file = new File(path);
            FileManager.checkIfFileExists(file);
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e) {
            FileManager.log(e.toString());
        }
    }

    /**
     * Metoda pro ukládání do clipboardu.
     *
     * @param params data o položce
     */
    public static void saveClipBoard(String[] params) {
        // try with resources
        // finally
        try {
            File file = new File(FileManager.pathToClipBoard);
            FileManager.checkIfFileExists(file);
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            StringBuilder buildWrite = new StringBuilder();
            buildWrite.append("BOOK_FIELD").append("=").append(params[0]).append("\r\n");
            buildWrite.append("BOOK_WRITER").append("=").append(params[1]).append("\r\n");
            buildWrite.append("BOOK_NAME").append("=").append(params[2]).append("\r\n");
            buildWrite.append("BOOK_PUBLISHER").append("=").append(params[3]).append("\r\n");
            buildWrite.append("BOOK_PUBLICATION_YEAR").append("=").append(params[4]).append("\r\n");
            buildWrite.append("BOOK_PUBLICATION_NUMBER").append("=").append(params[5]).append("\r\n");

            bufferedWriter.write(buildWrite.toString());
            bufferedWriter.close();
        } catch (Exception e) {
            FileManager.log(e.toString());
        }
    }

    /**
     * Metoda pro nastavení do clipboardu.
     *
     * @param stringToSave data
     */
    public static void setSystemClipBoard(String stringToSave) {
        StringSelection selection = new StringSelection(stringToSave);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }

    /**
     * Vymaže clipboard.
     */
    public static void clearClipBoard() {
        File file = new File(FileManager.pathToClipBoard);
        if (file.exists()) {
            file.delete();
            FileManager.log("Clip board has been cleared.");
        }
    }

    /**
     * Metoda pro sestavení prefixu do logu.
     *
     * @return vrací prefix typu String
     */
    private static String prefixData() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String username = "";

        if (AppGUI.account != null) {
            username = AppGUI.account.getNICKNAME();
        }

        if (!username.equals("")) {
            return "[" + dtf.format(now) + "," + username + "]";
        } else {
            return "[" + dtf.format(now) + ",System]";
        }
    }

    /**
     * Nastaví klíč šifrování.
     *
     * @param myKey klíč
     */
    public static void setKey(String myKey) {
        MessageDigest sha = null;
        try {
            byte[] key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            FileManager.log(e.toString());
        }
    }

    /**
     * Zašifrování dat podle klíče.
     *
     * @param strToEncrypt text k zašifrování
     * @param secret       klíč
     */
    public static void encrypt(String strToEncrypt, String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            String statement = Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
            FileManager.writeToFile(FileManager.pathToUserData, statement, false);
        } catch (Exception e) {
            FileManager.log(e.toString());
        }
    }

    /**
     * Přečte soubor do stringu.
     *
     * @param filePath cesta k souboru
     * @return vrací přečtený string
     */
    private static String readFileToString(String filePath) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            FileManager.log(e.toString());
        }
        return content;
    }

    /**
     * Dešifruje text.
     *
     * @param secret text
     * @return nešifrovaný text
     */
    public static String decrypt(String secret) {
        String data = FileManager.readFileToString(FileManager.pathToUserData);
        String result = "";
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            result = new String(cipher.doFinal(Base64.getDecoder().decode(data)));
        } catch (Exception e) {
            FileManager.log(e.toString());
        }
        return result;
    }

    /**
     * Smaže soubor s uloženým uživatelem.
     */
    public static void removeCharacterData() {
        File tmpDir = new File(FileManager.pathToUserData);
        if (tmpDir.exists()) {
            tmpDir.delete();
        }
    }

    /**
     * Ověří jestli existuje soubor, pokud ne tak ho vytvoří.
     *
     * @param file cesta k souboru
     */
    public static void checkIfFileExists(File file) {
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
                FileManager.log("File: " + file.getName() + " has been created.");
            }
        } catch (Exception e) {
            FileManager.log(e.toString());
        }
    }
}
