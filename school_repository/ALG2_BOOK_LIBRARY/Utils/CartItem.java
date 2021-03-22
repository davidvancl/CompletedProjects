package com.Library.Utils;

import com.Library.App.AppGUI;
import com.Library.GUI.Cart;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.Collator;
import java.util.Locale;

/**
 * <h1>CartItem</h1>
 * Třída CartItem, je položka ukládaná do košíku.
 * Obsahuje jednotlivá data.
 * Základ dat je poděděn z ItemTemplate
 * @see ItemTemplate
 *
 * @file CartItem.java
 * @brief Je položka ukládaná do košíku.
 *
 * @class CartItem
 * @brief Třída vytvářející item a zobrazující se v košíku.
 *
 * Pro setřídění výužívána Třída Comparable<CartItem>
 * @see Comparable<CartItem>
 */
public class CartItem extends ItemTemplate implements Comparable<CartItem> {
    /**
     * Nadřazená stránka.
     */
    private Cart cart;

    /**
     * Konstruktor třídy CartItem
     *
     * @param cart Nadřazená stránka.
     * @param params Jednotlivé parametry.
     */
    public CartItem(Cart cart, String[] params){
        this.setBackground(Color.RED);
        this.cart = cart;
        this.loadParams(params);
    }

    /**
     * Metoda implementovaná z MouseListener
     * Metoda volaná po kliknutí.
     * @see MouseListener
     *
     * @param e data po kliku
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        cart.showDangerAlert("Item was removed.");
        AppGUI.cartList.remove(this);
        cart.reloadData();
    }
    /**
     * Metoda implementovaná z MouseListener
     * Metoda volaná po stisku položky.
     * @see MouseListener
     *
     * @param e data po kliku
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }
    /**
     * Metoda implementovaná z MouseListener
     * Metoda volaná po opuštění položky.
     * @see MouseListener
     *
     * @param e data po kliku
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    /**
     * Metoda implementovaná z MouseListener
     * Metoda volaná po najetí na položku.
     * @see MouseListener
     *
     * @param e data po kliku
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        this.setOpaque(true);
        this.repaint();
    }
    /**
     * Metoda implementovaná z MouseListener
     * Metoda volaná po vyjetí na položku.
     * @see MouseListener
     *
     * @param e data po kliku
     */
    @Override
    public void mouseExited(MouseEvent e) {
        this.setOpaque(false);
        this.repaint();
    }

    /**
     * Metoda porovnávající objekty.
     * @param o porovnávaný objekt
     * Porovnání a colání metody compareTo dochází v:
     * @see java.util.Collections
     * @return vrací -1,1,0
     */
    @Override
    public int compareTo(CartItem o) {
        Collator collator = Collator.getInstance(new Locale("cs"));
        switch (Cart.comparing){
            case "writer":
                return collator.compare(this.writer.getText(),o.writer.getText());
            case "publisher":
                return collator.compare(this.publisher.getText(),o.publisher.getText());
            default:
                return collator.compare(this.name.getText(),o.name.getText());
        }
    }
}
