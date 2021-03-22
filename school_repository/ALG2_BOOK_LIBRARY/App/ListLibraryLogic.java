package com.Library.App;

import com.Library.Database.DatabaseManager;
import com.Library.GUI.ListLibrary;
import com.Library.Utils.BookFilter;
import com.Library.Utils.DataPanel;
import com.Library.Utils.FileManager;
import com.Library.Utils.ListedItem;

import javax.swing.*;
import java.sql.ResultSet;

/**
 * <h1>ListLibraryLogic</h1>
 * Abstraktní třída ListLibraryLogic
 * Obsahuje logiku spojenou s oknem ListLibrary
 * @see ListLibrary
 *
 * @file ListLibraryLogic.java
 * @brief Logika aplikovaná v ListLibrary.
 *
 * @class ListLibraryLogic
 * @brief Logika vyhledávání.
 */
public abstract class ListLibraryLogic {
    /**
     * Metoda pro sparcovní dat z ListLibrary
     *
     * @param listLibrary Záložka volání
     * @param bookFilter Filter s předvolenými daty.
     * @param dataPanel Panel s uloženými daty.
     * @param first Parametr, zda se jedná o první SQL command.
     */
    public static void concatenateData(ListLibrary listLibrary, BookFilter bookFilter, DataPanel dataPanel,boolean first){
        try {
            DatabaseManager databaseManager = new DatabaseManager();
            String query = "SELECT * FROM `books` LIMIT 5 OFFSET 0";
            if(!first) {
                query = bookFilter.getSQL();
            }
            listLibrary.setUsedSQL(query);
            ResultSet set;
            if(first) {
                set = databaseManager.getAllData(query);
            } else {
                set = databaseManager.getDynamicData(query, bookFilter.getParams());
            }

            while (set.next()) {
                dataPanel.addItem(new ListedItem(listLibrary, new String[]{
                        set.getString("BOOK_FIELD"), set.getString("BOOK_WRITER"),
                        set.getString("BOOK_NAME"), set.getString("BOOK_PUBLISHER"),
                        set.getString("BOOK_PUBLICATION_YEAR"), set.getString("BOOK_PUBLICATION_NUMBER")
                }));
            }
            String count_query = query.replace("*", "COUNT(ID)");
            ResultSet t;
            if(first){
                t = databaseManager.getAllData(count_query);
            } else {
                t = databaseManager.getDynamicData(count_query, bookFilter.getParams());
            }

            int items_count = 0;
            int item_page = 0;
            if (t.next()) {
                items_count = Integer.parseInt(t.getString("COUNT(ID)"));
            }
            item_page = items_count / 5;

            if(item_page <= 1){
                dataPanel.spinner.setEnabled(false);
                dataPanel.setPagesNumber(1, 1);
            } else {
                dataPanel.spinner.setEnabled(true);
                dataPanel.spinner.setModel(new SpinnerNumberModel(1, 1, item_page, 1));
                dataPanel.setPagesNumber(1, item_page);
            }

            listLibrary.setMaxValue(item_page);
            databaseManager.closeConnection();
        } catch (Exception e){
            FileManager.log(e.toString());
            System.out.println(e.toString());
        }
    }
}
