package com.Library.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

/**
 * <h1>ItemTemplate</h1>
 * Třída ItemTemplate je poděděna z JPanel
 * @see JPanel
 * a implentuje Interface MouseListener
 * @see MouseListener
 *
 * @file ItemTemplate.java
 * @brief Je šablona pro itemy.
 *
 * @class ItemTemplate
 * @brief Třída definující itemy.
 *
 * Obsahuje jednotlivé pole a labely.
 */
public abstract class ItemTemplate extends JPanel implements MouseListener {
    /**
     * Pole pro spisovatele.
     */
    protected JTextField writer;
    /**
     * Pole pro jméno knihy.
     */
    protected JTextField name;
    /**
     * Pole, obor.
     */
    protected JTextField field;
    /**
     * Pole, vydavatele knihy.
     */
    protected JTextField publisher;
    /**
     * Pole, rok vydání knihy.
     */
    protected JTextField publisherYear;
    /**
     * Pole, číslo vydání.
     */
    protected JTextField publisherNumber;
    /**
     * Parametry knihy.
     */
    protected String[] params;

    /**
     * Konstruktor třídy.
     * Nastaví vzhled Tabu.
     */
    public ItemTemplate(){
        this.setLayout(null);
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        this.setOpaque(false);
        this.setBackground(Color.WHITE);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.loadComponents();
    }

    /**
     * Načtení komponent.
     */
    private void loadComponents(){
        this.loadWriterField();
        this.loadNameField();
        this.loadBookField();
        this.loadPublisher();
        this.loadPublicationYear();
        this.loadPublicationNumber();
    }

    /**
     * Přiřazení dat k položkám.
     * @param params data
     */
    protected void loadParams(String[] params){
        this.params = params;
        this.field.setText(this.params[0]);
        this.writer.setText(this.params[1]);
        this.name.setText(this.params[2]);
        this.publisher.setText(this.params[3]);
        this.publisherYear.setText(this.params[4]);
        this.publisherNumber.setText(this.params[5]);
    }

    /**
     * Pole, spisovatel.
     */
    private void loadWriterField(){
        this.writer = this.getCustomJTextField();
        this.writer.setBounds(30,0,170,20);
    }
    /**
     * Pole, jméno knihy.
     */
    private void loadNameField(){
        this.name = this.getCustomJTextField();
        this.name.setHorizontalAlignment(SwingConstants.RIGHT);
        this.name.setBounds(200,0,180,20);
    }
    /**
     * Pole, obor knihy.
     */
    private void loadBookField(){
        this.field = this.getCustomJTextField();
        this.field.setBounds(0,0,30,20);
    }
    /**
     * Pole, vydavatel knihy.
     */
    private void loadPublisher(){
        this.publisher = this.getCustomJTextField();
        this.publisher.setBounds(80,20,200,20);
    }
    /**
     * Pole, rok vydání.
     */
    private void loadPublicationYear(){
        this.publisherYear = this.getCustomJTextField();
        this.publisherYear.setBounds(0,20,80,20);
    }
    /**
     * Pole, číslo vydání.
     */
    private void loadPublicationNumber(){
        this.publisherNumber = this.getCustomJTextField();
        this.publisherNumber.setHorizontalAlignment(SwingConstants.RIGHT);
        this.publisherNumber.setBounds(320,20,60,20);
    }


    /**
     * Dynamicky upraví inputy a jejich vzhled.
     * @return vrací upravená JTextField
     * @see JTextField
     */
    private JTextField getCustomJTextField(){
        JTextField item = new JTextField();
        item.setOpaque(false);
        item.setBorder(null);
        item.addMouseListener(this);
        item.setEditable(false);
        item.setCursor(new Cursor(Cursor.HAND_CURSOR));
        item.setHorizontalAlignment(SwingConstants.LEFT);
        this.add(item);
        return item;
    }

    /**
     * @return spisovatel knihy
     */
    public String getBookWriter() {
        return writer.getText();
    }

    /**
     * @return jméno knihy
     */
    public String getBookName() {
        return name.getText();
    }
}
