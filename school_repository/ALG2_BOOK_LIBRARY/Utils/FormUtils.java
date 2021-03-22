package com.Library.Utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * <h1>FormUtils</h1>
 * Abstraktní třída FormUtils.
 * Doplňuje formůláře o některé detaily.
 *
 * @file FormUtils.java
 * @brief Doplňuje formůláře o některé detaily.
 *
 * @class FormUtils
 * @brief Abstraktní třída s utility pro formulář.
 */
public abstract class FormUtils {

    /**
     * Metoda kontrolující korekci jména.
     *
     * @param name jméno
     * @return true/false
     */
    public static boolean nameCorrection(String name) {
        return name.length() > 3 && name.length() < 51 && !Arrays.asList(BannedWords.bannedWords).contains(name);
    }

    /**
     * Metoda kontrolující nickname
     *
     * @param nickname nickname
     * @return true/false
     */
    public static boolean nicknameCorrection(String nickname) {
        return nickname.length() > 3 && nickname.length() < 51 && !Arrays.asList(BannedWords.bannedWords).contains(nickname) && !nickname.contains(" ");
    }

    /**
     * Požadavky na zadané heslo.
     *
     * @param password heslo
     * @return true/false
     */
    public static boolean passwordCorrection(String password) {
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (Character.isDigit(ch)) {
                numberFlag = true;
            } else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }
            if (numberFlag && capitalFlag && lowerCaseFlag) {
                return true;
            }
        }
        return false;
    }

    /**
     * Porovnání dvou stringů.
     *
     * @param string1 text1
     * @param string2 text2
     * @return true/false
     */
    public static boolean matchTwoStrings(String string1, String string2) {
        return string1.equals(string2);
    }

    /**
     * Konvertuje byte pole hashe do stringu.
     *
     * @param hash pole hash
     * @return zahashovaný string
     */
    public static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    /**
     * Zašufruje data do sha256.
     *
     * @param text data
     * @return byte pole
     */
    public static byte[] hashToSha256(String text) {
        byte[] encodedhash = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            encodedhash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            FileManager.log(e.toString());
        }
        assert encodedhash != null;
        return encodedhash;
    }

}
