package com.Library.Utils;

import com.Library.App.AppGUI;
import com.Library.GUI.ListLibrary;

import java.awt.event.MouseEvent;

/**
 * <h1>ListedItem</h1>
 * Třída ListedItem poděděna z ItemTemplate
 *
 * @file ListedItem.java
 * @brief Je item vypisující se ve vyhledávání.
 *
 * @class ListedItem
 * @brief Třída vykreslující item ve vyhledávání.
 *
 * @see ItemTemplate
 */
public class ListedItem extends ItemTemplate {
    /**
     * Nadřazené okno
     */
    private ListLibrary library;

    /**
     * Konstruktor ListedItem.
     * Sestaví item do prohlížeče.
     *
     * @param library nadřazené okno
     * @param params  data o itemu
     */
    public ListedItem(ListLibrary library, String[] params) {
        this.library = library;
        this.loadParams(params);
        this.addMouseListener(this);
    }

    /**
     * Click na item, zkopíruje data a přidá položku do košíku.
     *
     * @param e click parameter
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        clickEvent();
    }

    public void clickEvent(){
        FileManager.saveClipBoard(this.params);
        FileManager.setSystemClipBoard(this.params[1] + " " + this.params[2]);
        AppGUI.cartList.add(new CartItem(library.getCart(), this.params));
        library.showSuccessAlert("Book added to cart.");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Přebarvení při najetí na objekt.
     *
     * @param e mouse event
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        this.setOpaque(true);
        this.repaint();
    }

    /**
     * Přebarvení při odjetí na objekt.
     *
     * @param e mouse event
     */
    @Override
    public void mouseExited(MouseEvent e) {
        this.setOpaque(false);
        this.repaint();
    }
}
