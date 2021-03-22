package com.Library.GUI;

import com.Library.App.AppGUI;
import com.Library.Utils.CartItem;
import com.Library.Utils.DataPanel;
import com.Library.Utils.JPanelTemplate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Collections;

/**
 * Třída Cart GUI poděděná z JPanelTemplate
 *
 * @file Cart.java
 * @brief GUI Cart.
 *
 * @class Cart
 * @brief Třída GUI pro Cart.
 *
 * @see JPanelTemplate
 */
public class Cart extends JPanelTemplate {
    /**
     * Proměnná podle které se sortuje
     */
    public static String comparing = "name";
    /**
     * Hlavní okno
     */
    private AppGUI frame;
    /**
     * Panel s vypsanými daty
     */
    private DataPanel dataPanel;

    /**
     * Tlačítko Name
     */
    private JRadioButton button1;
    /**
     * Tlačítko Writer
     */
    private JRadioButton button2;
    /**
     * Tlačítko Publisher
     */
    private JRadioButton button3;

    public JButton order;

    public Cart(AppGUI frame, boolean isVisible){
        super(frame.getWidth(),frame.getHeight(),isVisible);
        this.frame = frame;
    }

    /**
     * Metoda na načítání Komponents
     */
    @Override
    public void loadCustomComponents() {
        this.loadTitle();
        this.loadDataPanel();
        this.loadBackButton();
        this.loadSaveButton();
        this.loadFromSaveButton();
        this.loadOrderButton();
        this.reloadData();
        this.loadSelectSort();
    }

    /**
     * Title
     */
    private void loadTitle(){
        JLabel label = customJLabel("Cart",30);
        label.setBounds(210,10,100,30);
        this.add(label);
    }

    /**
     * DataPanel
     */
    private void loadDataPanel(){
        this.dataPanel = new DataPanel(this,false,380);
        this.dataPanel.setBounds(this.dataPanel.getX(),50,this.dataPanel.getWidth(),380);
    }

    /**
     * Návrat do menu
     */
    private void loadBackButton(){
        JButton button = new JButton("Menu",loadImageFromPackage("buttonMenu.png",130,40));
        button.setBounds(40,410,130,40);
        button.addActionListener(e -> frame.swapScreen(frame.getCart(),frame.getMenu()));
        this.dynamicUpgrade(button);
        this.setComponentZOrder(button,0);
    }

    /**
     * Tlačítko Save
     */
    private void loadSaveButton(){
        JButton button = new JButton("Save",loadImageFromPackage("buttonSort.png",130,40));
        button.setBounds(50,35,130,40);
        this.dynamicUpgrade(button);
        this.setComponentZOrder(button,0);
        button.addActionListener(e -> {
            if(button1.isSelected()){
                Cart.comparing = "name";
            } else if(button2.isSelected()){
                Cart.comparing = "writer";
            } else {
                Cart.comparing = "publisher";
            }
            Collections.sort(AppGUI.cartList);
            reloadData();
        });
    }

    /**
     * Načte radio tlačítka pro seřazení
     */
    private void loadSelectSort(){
        this.button1 = new JRadioButton("Name");
        this.button1.setMnemonic(KeyEvent.VK_B);
        this.button1.setBounds(0,10,60,20);
        this.button1.setSelected(true);
        this.updateRadios(this.button1);

        this.button2 = new JRadioButton("Writer");
        this.button2.setMnemonic(KeyEvent.VK_C);
        this.button2.setBounds(60,10,60,20);
        this.updateRadios(this.button2);

        this.button3 = new JRadioButton("Publisher");
        this.button3.setMnemonic(KeyEvent.VK_D);
        this.button3.setBounds(120,10,80,20);
        this.updateRadios(this.button3);

        ButtonGroup group = new ButtonGroup();
        group.add(this.button1);
        group.add(this.button2);
        group.add(this.button3);
    }

    /**
     * Dynamicky upraví radioButton
     * @param radioButton radioButton
     */
    private void updateRadios(JRadioButton radioButton){
        radioButton.setOpaque(false);
        radioButton.setForeground(Color.WHITE);
        radioButton.setFocusable(false);
        this.add(radioButton);
    }

    /**
     * Tlačítko na načtení
     */
    private void loadFromSaveButton(){
        JButton button = new JButton("Load",loadImageFromPackage("buttonLoad.png",130,40));
        button.setBounds(300,35,130,40);
        this.dynamicUpgrade(button);
        this.setComponentZOrder(button,0);
        button.addActionListener(e -> reloadData());
    }

    /**
     * Přemaluje data
     */
    public void reloadData(){
        dataPanel.clearItemsC();
        for (CartItem item : AppGUI.cartList){
            dataPanel.addItemC(item);
        }
    }

    /**
     * Button pro odeslání objednávkzy
     */
    private void loadOrderButton(){
        order = new JButton("Order",loadImageFromPackage("buttonOrder.png",130,40));
        order.setBounds(300,410,130,40);
        this.dynamicUpgrade(order);
        this.setComponentZOrder(order,0);
        order.addActionListener(e -> frame.swapScreen(frame.getCart(),frame.getOrder()));
    }
}
