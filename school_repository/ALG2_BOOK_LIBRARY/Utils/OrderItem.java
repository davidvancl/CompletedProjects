package com.Library.Utils;

import javax.swing.*;
import java.awt.*;

public class OrderItem extends JPanel {
    private JTextField contact;
    private JTextField address;
    private JTextField date;
    private JTextField books;

    private String[] params;

    public OrderItem(String[] params){
        this.setLayout(null);
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        this.setOpaque(false);
        this.setBackground(Color.WHITE);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.params = params;

        this.loadComponents();
    }

    private void loadComponents(){
        this.loadWriterField();
        this.loadNameField();
        this.loadPublicationYear();
        this.loadPublicationNumber();

        loadData();
    }

    public void loadData(){
        this.contact.setText(params[0]);
        this.address.setText(params[1]);
        this.date.setText(params[3]);
        this.books.setText(params[2]);
    }

    private void loadWriterField(){
        this.contact = this.getCustomJTextField();
        this.contact.setBounds(0,0,100,20);
    }

    private void loadNameField(){
        this.address = this.getCustomJTextField();
        this.address.setHorizontalAlignment(SwingConstants.LEFT);
        this.address.setBounds(100,0,130,20);
    }

    private void loadPublicationYear() {
        this.books = this.getCustomJTextField();
        this.books.setBounds(0, 20, 400, 20);

    }
    private void loadPublicationNumber(){
        this.date = this.getCustomJTextField();
        this.date.setHorizontalAlignment(SwingConstants.RIGHT);
        this.date.setBounds(240,0,130,20);
    }

    private JTextField getCustomJTextField(){
        JTextField item = new JTextField();
        item.setOpaque(false);
        item.setBackground(Color.GREEN);
        item.setBorder(null);
        item.setEditable(false);
        item.setCursor(new Cursor(Cursor.HAND_CURSOR));
        item.setHorizontalAlignment(SwingConstants.LEFT);
        this.add(item);
        return item;
    }
}
