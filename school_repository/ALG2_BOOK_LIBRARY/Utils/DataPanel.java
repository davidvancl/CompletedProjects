package com.Library.Utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

/**
 * <h1>DataPanel</h1>
 * Třída DataPanel je pole pro načítání jednotlivých položek.
 * Dědí ze třídy JPanel
 *
 * @file DataPanel.java
 * @brief Třída DataPanel je pole pro načítání jednotlivých položek.
 *
 * @class DataPanel
 * @brief Třída zobrazující itemy.
 *
 * @see JPanel
 */
public class DataPanel extends JPanel {
    /**
     * Obrázek v pozadí.
     */
    private Image test;
    /**
     * Status o načtení.
     */
    private boolean load = true;
    /**
     * Stránky.
     */
    private JTextField pages;
    /**
     * Pozice načítání itemů.
     */
    private int positionItem = 0;
    /**
     * Upravená výška.
     */
    private int customHeight;

    /**
     * Stránkovač.
     */
    public JSpinner spinner;

    /**
     * Konstruktor třídy
     * Sestavý DataPanel
     *
     * @param upper        nadřazený panel
     * @param pages        aktuální stránka
     * @param customHeight upravená výška panelu
     */
    public DataPanel(JPanel upper, boolean pages, int customHeight) {
        this.customHeight = customHeight;
        this.setLayout(null);
        this.setBounds(15, 140, 450, this.customHeight);
        this.setOpaque(false);
        this.loadTitleName();
        this.loadTitleWriter();
        if (pages) {
            this.loadPages();
            this.loadPager();
        }
        upper.add(this);
    }

    /**
     * Metoda pro překreslování pozadí panelu.
     *
     * @param g graphic
     */
    @Override
    public void paintComponent(Graphics g) {
        if (this.load) {
            try {
                this.test = ImageIO.read(getClass().getResourceAsStream("/com/Library/Images/dataBorder.png"));
            } catch (Exception e) {
                FileManager.log(e.toString());
            }
            this.load = false;
            super.paintComponent(g);
        }
        g.drawImage(this.test.getScaledInstance(450, this.customHeight, Image.SCALE_DEFAULT), 0, 0, null);
    }

    /**
     * Pole, stránky
     */
    private void loadPages() {
        this.pages = new JTextField();
        this.pages.setBounds(330, 275, 80, 20);
        this.pages.setOpaque(false);
        this.pages.setHorizontalAlignment(SwingConstants.CENTER);
        this.pages.setText("1/5");
        this.pages.setBorder(null);
        this.add(this.pages);
    }

    /**
     * Stránkovač.
     */
    private void loadPager() {
        SpinnerModel model = new SpinnerNumberModel(1, 1, 15, 1);
        this.spinner = new JSpinner(model);
        this.spinner.setBounds(280, 275, 50, 20);
        this.add(this.spinner);
    }

    /**
     * Nastaví aktuální stránku.
     */
    public void setPagesNumber(int page, int all) {
        this.pages.setText(page + "/" + all);
    }

    /**
     * Nadpis, writer.
     */
    private void loadTitleWriter() {
        JLabel label = new JLabel("WRITER");
        label.setBounds(65, 30, 100, 20);
        this.add(label);
    }

    /**
     * Nadpis, Jméno.
     */
    private void loadTitleName() {
        JLabel label = new JLabel("NAME");
        label.setBounds(285, 30, 100, 20);
        this.add(label);
    }

    /**
     * Přídání itemu na seznam typu ListedItem
     *
     * @param item vytovřený item
     * @see ListedItem
     */
    public void addItem(ListedItem item) {
        item.setBounds(30, (this.positionItem * 45) + 50, 380, 41);
        this.positionItem++;
        this.add(item);
    }

    /**
     * Přídání itemu na seznam typu CartItem
     *
     * @param item vytovřený item
     * @see CartItem
     */
    public void addItemC(CartItem item) {
        item.setBounds(30, (this.positionItem * 45) + 50, 380, 41);
        this.positionItem++;
        this.add(item);
    }

    public void addItemO(OrderItem item) {
        item.setBounds(30, (this.positionItem * 45) + 50, 380, 41);
        this.positionItem++;
        this.add(item);
    }

    /**
     * Smaže všechny itemy v panelu typu: ListedItem
     *
     * @see ListedItem
     */
    public void clearItems() {
        for (Component c : this.getComponents()) {
            if (c instanceof ListedItem) {
                this.remove(c);
            }
        }

        this.positionItem = 0;
        this.revalidate();
        this.repaint();
    }

    /**
     * Smaže všechny itemy v panelu typu: CartItem
     *
     * @see CartItem
     */
    public void clearItemsC() {
        for (Component c : this.getComponents()) {
            if (c instanceof CartItem) {
                this.remove(c);
            }
        }

        this.positionItem = 0;
        this.revalidate();
        this.repaint();
    }

    public void clearItemsO() {
        for (Component c : this.getComponents()) {
            if (c instanceof OrderItem) {
                this.remove(c);
            }
        }

        this.positionItem = 0;
        this.revalidate();
        this.repaint();
    }
}
