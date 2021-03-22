package com.Library.App;

import com.Library.Robot.RobotNikita;

import java.awt.*;
import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

/**
 * \mainpage Aplikace pro objednávání knížek
 *
 * <h1>Aplikace pro objednávání knížek</h1>
 * \section intro_sec Introduction
 * Do aplikace má přístup pouze uživatelé, kteří jsou registrováni v databázi.
 * Aplikace umožňuje přihlášení manuální, nebo uložení posledního přihlášení.
 * Aplikace předvyplní data, uživatel poze potvrdí přihlášení.
 * <p>
 * Menu aplikace se vytvoří na základě oprávnění uživatele.
 *
 * \section User
 * Uživatele může listovat v databázi knížek na základě nastaveného filtru.
 * Knížky přidané do košíku muže seřadit podle jednotlivých parametrů, nebo odstranit z košíku.
 * <p>
 * V záložce s objednávkou pouze dovyplní data a odešle obejdnávku.
 * Book tab zapíše knížky do zapůjčení a nastaví datum vrácení.
 *
 * \section SuperUser
 * + Může mazat uživatele.
 * + Může upravovat oprávnění jednotlivých uživatelů.
 *
 *
 * @author David Vancl
 * @version 1.0
 * <h3>Aktuální používaný balíček Aplikace</h3>
 * @see com.Library.App
 * <h3>Rozšiřující balíčky</h3>
 * @see com.github.lgooddatepicker
 * @see com.privatejgoodies
 * @since 2020-05-16
 *
 * @file Main.java
 * @brief Vstupní bod aplikace.
 *
 * @class Main
 * @brief Vstupní bod aplikace.
 */
public class Main {
    /**
     * Instance třídy AppGUI
     * Hlavní grafické rozhraní aplikace
     *
     * @see AppGUI
     */
    private static AppGUI mainScreen;

    /**
     * Vstupní metoda aplikace
     * + Uloží instanci hlavního grafického rozhraní AppGUI
     *
     * @see AppGUI
     * @param args parametry aplikace při spuštění
     */
    public static void main(String[] args){
        mainScreen = new AppGUI();
    }
}
