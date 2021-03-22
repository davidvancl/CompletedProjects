package com.Library.GUI;

import com.Library.App.ListLibraryLogic;
import com.Library.App.AppGUI;
import com.Library.Database.DatabaseManager;
import com.Library.Utils.*;

import javax.swing.*;
import java.sql.ResultSet;

/**
 * <h1>ListLibrary</h1>
 * Třída ListLibrary poděděná z třídy JPanelTemplate
 * Grafické rozhraní pro vyhledávání v databázi.
 *
 *
 * @file ListLibrary.java
 * @brief GUI ListLibrary.
 *
 * @class ListLibrary
 * @brief Třída GUI pro ListLibrary.
 *
 * @see JPanelTemplate
 */
public class ListLibrary extends JPanelTemplate {
    /**
     * Panel s daty
     */
    public DataPanel dataPanel;
    /**
     * Filter aplikovaný na DB.
     */
    public BookFilter bookFilter;
    /**
     * Hlavní grafické okno.
     */
    private AppGUI frame;
    /**
     * Stránkování
     */
    private int actualPage = 1;
    /**
     * Poslední použitý SQL code
     */
    private String usedSQL = "";
    /**
     * Maximální hodnota do counteru
     */
    private int maxValue = 0;

    public JButton refresh;
    public JButton menu;


    /**
     * Konstruktor ListLibrary
     * Složí GUI
     *
     * @param frame     nadřazený frame
     * @param isVisible viditelnost
     */
    public ListLibrary(AppGUI frame, boolean isVisible) {
        super(frame.getWidth(), frame.getHeight(), isVisible);
        this.frame = frame;
    }

    /**
     * Načtení komponent a dat
     *
     * @see ListLibraryLogic
     */
    @Override
    public void loadCustomComponents() {
        this.loadBorderTab();
        this.loadFilter();
        this.loadRefreshButton();
        this.loadMenuButton();
        this.loadClearClipBoard();

        ListLibraryLogic.concatenateData(this, this.bookFilter, this.dataPanel, true);
    }

    /**
     * Načtení DataPanelu
     */
    private void loadBorderTab() {
        this.dataPanel = new DataPanel(this, true, 320);
        this.setComponentZOrder(this.dataPanel, 0);
        this.dataPanel.spinner.addChangeListener(e -> {
            if ((actualPage + 1) == (Integer) dataPanel.spinner.getValue()) {
                increasePage();
            } else if ((actualPage - 1) == (Integer) dataPanel.spinner.getValue()) {
                decreasePage();
            } else {
                setPage((Integer) dataPanel.spinner.getValue());
            }
        });
    }

    /**
     * @return Cart page
     */
    public Cart getCart() {
        return this.frame.getCart();
    }

    /**
     * Načtení filteru
     */
    private void loadFilter() {
        this.bookFilter = new BookFilter(this, "books");
        this.bookFilter.setBounds(35, 10, bookFilter.getWidth(), bookFilter.getHeight());
    }

    /**
     * Tlačítko pro vyčištění bordu.
     */
    private void loadClearClipBoard() {
        JButton button = new JButton("clear", loadImageFromPackage("buttonClearCB.png", 130, 40));
        button.setBounds(180, 130, 130, 40);
        this.dynamicUpgrade(button);
        this.setComponentZOrder(button, 0);
        button.addActionListener(e -> {
            FileManager.clearClipBoard();
            FileManager.setSystemClipBoard("");
        });
    }

    /**
     * Tlačítko pro obnovení.
     */
    private void loadRefreshButton() {
        refresh = new JButton("Refresh", loadImageFromPackage("buttonRefresh.png", 130, 40));
        refresh.setBounds(320, 130, 130, 40);
        refresh.addActionListener(e -> {
            dataPanel.clearItems();
            bookFilter.collectData();
            ListLibraryLogic.concatenateData(this, this.bookFilter, this.dataPanel, false);
        });
        this.dynamicUpgrade(refresh);
        this.setComponentZOrder(refresh, 0);
    }

    /**
     * Nastaví se poslední použité SQL
     *
     * @param sql nové SQL
     */
    public void setUsedSQL(String sql) {
        this.usedSQL = sql;
    }

    /**
     * Nastaví se maximální hodnota counteru.
     *
     * @param maxValue nová hodnota
     */
    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    /**
     * Metoda pro obnovení, načtení dat z databáze.
     *
     * @param page stránka
     * @see com.Library.Database.DatabaseManager
     * Načtení do pole jednotlivých itemů.
     * @see ListedItem
     */
    public void reloadItemsByPage(int page) {
        String query = this.usedSQL.replaceAll("\\s(\\w+)$", " " + ((page - 1) * 5));
        dataPanel.clearItems();
        bookFilter.collectData();
        try {
            DatabaseManager databaseManager = new DatabaseManager();
            this.usedSQL = query;
            ResultSet set = databaseManager.getDynamicData(query, bookFilter.getParams());
            while (set.next()) {
                dataPanel.addItem(new ListedItem(this, new String[]{
                        set.getString("BOOK_FIELD"), set.getString("BOOK_WRITER"),
                        set.getString("BOOK_NAME"), set.getString("BOOK_PUBLISHER"),
                        set.getString("BOOK_PUBLICATION_YEAR"), set.getString("BOOK_PUBLICATION_NUMBER")
                }));
                dataPanel.setPagesNumber(page, maxValue);
            }
        } catch (Exception exe) {
            FileManager.log(exe.toString());
            System.out.println(exe.toString());
        }

    }

    /**
     * Překlopí se na další stránku.
     */
    public void increasePage() {
        this.actualPage++;
        this.reloadItemsByPage(this.actualPage);
    }

    /**
     * Nastaví se na aktuální stránku.
     *
     * @param page stránka.
     */
    public void setPage(int page) {
        this.actualPage = page;
        this.reloadItemsByPage(this.actualPage);
    }

    /**
     * Překlopí se o stránku níže.
     */
    public void decreasePage() {
        if (this.actualPage - 1 >= 0) {
            this.actualPage--;
            this.reloadItemsByPage(this.actualPage);
        }
    }

    /**
     * Načte se tlačítko do Menu.
     */
    private void loadMenuButton() {
        menu = new JButton("Menu", loadImageFromPackage("buttonMenu.png", 130, 40));
        menu.setBounds(40, 130, 130, 40);
        menu.addActionListener(e -> frame.swapScreen(frame.getListLibrary(), frame.getMenu()));
        this.dynamicUpgrade(menu);
        this.setComponentZOrder(menu, 0);
    }
}
