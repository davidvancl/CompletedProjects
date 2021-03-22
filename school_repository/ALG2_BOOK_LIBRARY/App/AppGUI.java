package com.Library.App;

import com.Library.Accounts.AccountTemplate;
import com.Library.GUI.*;
import com.Library.Utils.CartItem;
import com.Library.Utils.FileManager;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * <h1>AppGUI</h1>
 * Třída skládající hlavní grafické rozhraní
 * Třída je poděděna JFame
 *
 * @see JFrame
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/javax/swing/JFrame.html">Podrobnější info o JFrame</a>
 *
 * @file AppGUI.java
 * @brief Hlavní frame aplikace.
 *
 *
 * @class AppGUI
 * @brief Hlavní frame aplikace.
 */
public class AppGUI extends JFrame {
    /**
     * Paměť s přihášeným uživatelem
     *
     * @see AccountTemplate
     */
    public static AccountTemplate account = null;
    /**
     * Košík přihlášeného uživatele
     * Zde pro pozdější úpravu (Anonymní uživatel)
     *
     * @see CartItem
     */
    public static ArrayList<CartItem> cartList = new ArrayList<>();

    /**
     * Šířka aplikace
     */
    private int width;
    /**
     * Výška aplikace
     */
    private int height;
    /**
     * Změna rozlišení
     */
    private boolean isResizable;
    /**
     * Viditelnost aplikace
     */
    private boolean isVisible = true;
    /**
     * Záložka Menu
     *
     * @see Menu
     */
    private Menu menu = null;
    /**
     * Záložka Register
     *
     * @see Register
     */
    private Register register = null;
    /**
     * Záložka Login
     *
     * @see Login
     */
    private Login login = null;
    /**
     * Záložka ListLibrary
     *
     * @see ListLibrary
     */
    private ListLibrary listLibrary = null;
    /**
     * Záložka Order
     *
     * @see Order
     */
    private Order order = null;
    /**
     * Záložka Cart
     *
     * @see Cart
     */
    private Cart cart = null;
    /**
     * Záložka Manage
     *
     * @see Manage
     */
    private Manage manage = null;

    private MyOrders orders = null;

    /**
     * Konstruktor Třídy
     * <p>
     * Přídá na okno listener pro logování zavření aplikace
     */
    public AppGUI() {
        super("Book App");
        this.isResizable = false;
        this.width = 500;
        this.height = 500;
        this.setLayout(null);
        this.appGuiContinue();

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                FileManager.log("Application has been terminated.");
            }
        });
    }

    /**
     * Metoda pro načítání oken
     * Základní je okno s přihlášením:
     * Okno Login {@link #getLogin()}
     */
    private void appGuiContinue() {
        this.setUpWindow();
        this.getLogin();
//        this.getMyOrders();
    }

    /**
     * Metoda,která nastaví vzhled aplikace
     */
    private void setUpWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(this.isVisible);
        this.setSize(this.width, this.height);
        this.setLocationRelativeTo(null);
        this.setResizable(this.isResizable);
    }

    /**
     * Vrací rozhraní Menu, pokud není tak ho vytvoří
     *
     * @return Menu GUI
     */
    public Menu getMenu() {
        if (this.menu == null) {
            this.menu = new Menu(this, false);
            this.add(this.menu);
        }
        return this.menu;
    }

    public MyOrders getMyOrders(){
        if (this.orders == null) {
            this.orders = new MyOrders(this, false);
            this.add(this.orders);
        }
        return this.orders;
    }

    /**
     * Resetuje Menu
     */
    public void resetMenu() {
        this.menu = null;
    }

    /**
     * Vrací rozhraní Login, pokud není tak ho vytvoří
     *
     * @return Login GUI
     */
    public Login getLogin() {
        if (this.login == null) {
            this.login = new Login(this, true);
            this.add(this.login);
        }
        return this.login;
    }

    /**
     * Vrací rozhraní Order, pokud není tak ho vytvoří
     *
     * @return Order GUI
     */
    public Order getOrder() {
        if (this.order == null) {
            this.order = new Order(this, false);
            this.add(this.order);
        }
        return this.order;
    }

    /**
     * Vrací rozhraní Cart, pokud není tak ho vytvoří
     *
     * @return Cart GUI
     */
    public Cart getCart() {
        if (this.cart == null) {
            this.cart = new Cart(this, false);
            this.add(this.cart);
        }
        return this.cart;
    }

    /**
     * Vrací rozhraní Manage, pokud není tak ho vytvoří
     *
     * @return Manage GUI
     */
    public Manage getManage(){
        if (this.manage == null) {
            this.manage = new Manage(this, false);
            this.add(this.manage);
        }
        return this.manage;
    }

    /**
     * Vrací rozhraní Register, pokud není tak ho vytvoří
     *
     * @return Register GUI
     */
    public Register getRegister() {
        if (this.register == null) {
            this.register = new Register(this, false);
            this.add(this.register);
        }
        return this.register;
    }

    /**
     * Vrací rozhraní ListLibrary, pokud není tak ho vytvoří
     *
     * @return ListLibrary GUI
     */
    public ListLibrary getListLibrary() {
        if (this.listLibrary == null) {
            this.listLibrary = new ListLibrary(this, false);
            this.add(this.listLibrary);
        }
        return this.listLibrary;
    }

    /**
     * @return výška aplikace
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * @return šířka aplikace
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Metoda pro změnu aktivního okna aplikace
     *
     * @param from staré okno
     * @param to   nové okno
     */
    public void swapScreen(JPanel from, JPanel to) {
        from.setVisible(false);
        to.setVisible(true);
    }
}
