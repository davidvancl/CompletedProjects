package com.Library.GUI;

import com.Library.App.AppGUI;
import com.Library.Utils.FileManager;
import com.Library.Utils.JPanelTemplate;
import javax.swing.*;

/**
 * <h1>Menu</h1>
 * Hlavní rozcestí aplikace.
 * Třída Menu poděděná ze třídy JPanelTemplate
 *
 * @file Menu.java
 * @brief GUI Menu.
 *
 * @class Menu
 * @brief Třída GUI pro Menu.
 *
 * @see JPanelTemplate
 */
public final class Menu extends JPanelTemplate {
    /**
     * Nadřazené okno.
     */
    private AppGUI frame;

    public JButton listDirectory;
    public JButton cart;
    public JButton exit;

    /**
     * Konstruktor Menu.
     * Sestaví se menu na základě uživatelského oprávnění.
     *
     * @param frame     nadřazené okno
     * @param isVisible viditelnost
     */
    public Menu(AppGUI frame, boolean isVisible) {
        super(frame.getWidth(), frame.getHeight(), isVisible);
        this.frame = frame;
    }

    /**
     * Vzkreslení tlačítek na základě oprávnění.
     */
    @Override
    public void loadCustomComponents() {
        if (AppGUI.account.get_p_showLibrary())
            this.listDirectoryButton();
        if (AppGUI.account.get_p_exit())
            this.exitApplication();
        if (AppGUI.account.get_p_cart())
            this.cartButton();
        if (AppGUI.account.get_p_createOrder())
            this.orderButton();
        if (AppGUI.account.get_p_createBook())
            this.bookButton();
        if (AppGUI.account.get_p_logOut())
            this.logOutButton();
        if (AppGUI.account.get_p_permissions())
            this.manageUserPermissions();
        if (AppGUI.account.get_p_manage())
            this.changeUserData();
    }

    /**
     * Tlačítko na vyhledávání v databázi.
     */
    private void listDirectoryButton() {
        listDirectory = new JButton("listDirectory", loadImageFromPackage("buttonLibrary.png"));
        listDirectory.setBounds(148, 50, this.buttonsWidth, this.buttonsHeight);
        this.dynamicUpgrade(listDirectory);
        listDirectory.addActionListener(e -> frame.swapScreen(frame.getMenu(), frame.getListLibrary()));
    }

    /**
     * Tlačítko na vypnutí aplikace.
     */
    private void exitApplication() {
        exit = new JButton("exitApp", loadImageFromPackage("buttonExit.png"));
        exit.setBounds(240, 405, this.buttonsWidth, this.buttonsHeight);
        this.dynamicUpgrade(exit);
        exit.addActionListener(e -> {
            FileManager.log("Shutting down application.");
            Runtime.getRuntime().exit(0);
        });
    }

    /**
     * Tlačítko na přechod do košíku.
     */
    private void cartButton() {
        cart = new JButton("search", loadImageFromPackage("buttonCart.png"));
        cart.setBounds(148, 110, this.buttonsWidth, this.buttonsHeight);
        this.dynamicUpgrade(cart);
        cart.addActionListener(e -> frame.swapScreen(frame.getMenu(), frame.getCart()));
    }

    /**
     * Tlačítko k objednávce.
     */
    private void orderButton() {
        JButton button = new JButton("order", loadImageFromPackage("buttonOrder.png"));
        button.setBounds(148, 170, this.buttonsWidth, this.buttonsHeight);
        this.dynamicUpgrade(button);
        button.addActionListener(e -> frame.swapScreen(frame.getMenu(), frame.getOrder()));
    }

    /**
     * Tlačítko na rezervaci knihy.
     */
    private void bookButton() {
        JButton button = new JButton("book", loadImageFromPackage("buttonBook.png"));
        button.setBounds(148, 230, this.buttonsWidth, this.buttonsHeight);
        this.dynamicUpgrade(button);
        //TODO: EventHandler
    }

    /**
     * Tlačítko k úpravě oprávnění uživatelů.
     */
    private void manageUserPermissions() {
        JButton button = new JButton("managePermissions", loadImageFromPackage("buttonPermissions.png"));
        button.setBounds(148, 290, this.buttonsWidth, this.buttonsHeight);
        this.dynamicUpgrade(button);
        button.addActionListener(e -> frame.swapScreen(frame.getMenu(),frame.getMyOrders()));
    }

    /**
     * Tlačítko ke změně dat uživatele.
     */
    private void changeUserData() {
        JButton button = new JButton("manageUserData", loadImageFromPackage("buttonManage.png"));
        button.setBounds(148, 350, this.buttonsWidth, this.buttonsHeight);
        this.dynamicUpgrade(button);
        button.addActionListener(e -> frame.swapScreen(frame.getMenu(),frame.getManage()));
    }

    /**
     * Tlačítko na odhlášení.
     */
    private void logOutButton() {
        JButton button = new JButton("logOut", loadImageFromPackage("buttonLogout.png"));
        button.setBounds(50, 405, this.buttonsWidth, this.buttonsHeight);
        this.dynamicUpgrade(button);
        button.addActionListener(e -> {
            FileManager.log(AppGUI.account.getNICKNAME() + " logged out.");
            AppGUI.account = null;
            frame.swapScreen(frame.getMenu(), frame.getLogin());
            FileManager.removeCharacterData();
            frame.resetMenu();
        });
    }
}
