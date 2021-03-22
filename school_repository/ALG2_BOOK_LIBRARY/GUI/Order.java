package com.Library.GUI;

import com.Library.App.AppGUI;
import com.Library.App.OrderLogic;
import com.Library.Utils.JPanelTemplate;

import javax.swing.*;

/**
 * <h1>Order</h1>
 * Třída Order je okno pro dovyplnění objednávky a následně její stvrzení.
 * Třída je poděděna z JPanelTemplate
 *
 * @file Order.java
 * @brief GUI Order.
 *
 * @class Order
 * @brief Třída GUI pro Order.
 * @see JPanelTemplate
 */
public class Order extends JPanelTemplate {
    /**
     * Nadřazené okno
     */
    private AppGUI frame;
    /**
     * Input na kontakt.
     */
    private JTextField contact;
    /**
     * Input na adresu.
     */
    private JTextField address;
    /**
     * Input na heslo.
     */
    private JTextField password;

    public JButton menu;
    public JButton order;

    /**
     * Konstruktor třídy.
     *
     * @param frame     nadřazené okno
     * @param isVisible viditelnost
     */
    public Order(AppGUI frame, boolean isVisible) {
        super(frame.getWidth(), frame.getHeight(), isVisible);
        this.frame = frame;
    }

    /**
     * Načtení jednotlivých komponent.
     */
    @Override
    public void loadCustomComponents() {
        this.checkCartButton();
        this.loadTitleContact();
        this.loadContactForm();
        this.loadMenuButton();
        this.loadAddressTitle();
        this.loadAddressForm();
        this.loadPasswordConf();
        this.loadPasswordTitle();
        this.loadButtonCreateOrder();
    }

    /**
     * Tlačítko na přechod do košíku.
     */
    private void checkCartButton() {
        JButton button = new JButton("Check", loadImageFromPackage("buttonCart.png"));
        button.setBounds(240, 30, this.buttonsWidth, this.buttonsHeight);
        this.dynamicUpgrade(button);
        button.addActionListener(e -> frame.swapScreen(frame.getOrder(), frame.getCart()));
    }

    /**
     * Nadpis, kontakt.
     */
    private void loadTitleContact() {
        JLabel label = customJLabel("Contact", 20);
        label.setBounds(105, 70, 300, 50);
    }

    /**
     * Input, kontakt.
     */
    private void loadContactForm() {
        this.contact = customJTextField();
        this.contact.setBounds(90, 110, 300, 50);
    }

    /**
     * Nadpis, adresa.
     */
    private void loadAddressTitle() {
        JLabel label = customJLabel("Address", 20);
        label.setBounds(105, 150, 300, 50);
    }

    /**
     * Input, adresa.
     */
    private void loadAddressForm() {
        this.address = customJTextField();
        this.address.setBounds(90, 190, 300, 50);
    }

    /**
     * Nadpis, heslo.
     */
    private void loadPasswordTitle() {
        JLabel label = customJLabel("Password", 20);
        label.setBounds(105, 230, 300, 50);
    }

    /**
     * Input, heslo.
     */
    private void loadPasswordConf() {
        this.password = customJPasswordField();
        this.password.setBounds(90, 270, 300, 50);
    }

    /**
     * Tlačítko na zapsání objednávky.
     * Ověření nutných parametrů.
     */
    private void loadButtonCreateOrder() {
        order = new JButton("Order", loadImageFromPackage("buttonOrder.png"));
        order.setBounds(148, 340, this.buttonsWidth, this.buttonsHeight);
        this.dynamicUpgrade(order);
        order.addActionListener(e -> {
            boolean placeOrder = true;
            StringBuilder message = new StringBuilder();

            if (contact.getText().equals("")) {
                message.append("contact,");
                placeOrder = false;
            }
            if (password.getText().equals("")) {
                message.append("password,");
                placeOrder = false;
            }
            if (address.getText().equals("")) {
                message.append("address,");
                placeOrder = false;
            }

            if (AppGUI.cartList.isEmpty()) {
                message.append("empty cart");
                placeOrder = false;
            }

            if (!placeOrder) {
                message.append(" ERROR");
                showDangerAlert(message.toString());
            } else {
                boolean res = OrderLogic.checkPassword(AppGUI.account.getNICKNAME(), password.getText());
                if (res) {
                    boolean statement = OrderLogic.writeOrder(AppGUI.account.getNICKNAME(), contact.getText(), address.getText());
                    if (statement) {
                        clearForm();
                        showSuccessAlert("Order confirmed.");
                    }
                } else {
                    showDangerAlert("Incorrect password.");
                }
            }
        });
    }

    /**
     * Metoda na vyčištění formuláře.
     */
    private void clearForm() {
        this.contact.setText("");
        this.address.setText("");
        this.password.setText("");
    }

    public void insertData(String contact,String address,String password){
        this.contact.setText(contact);
        this.address.setText(address);
        this.password.setText(password);
    }

    /**
     * Tlačítko na návrat do menu.
     */
    private void loadMenuButton() {
        menu = new JButton("Menu", loadImageFromPackage("buttonMenu.png"));
        menu.setBounds(60, 30, this.buttonsWidth, this.buttonsHeight);
        menu.addActionListener(e -> frame.swapScreen(frame.getOrder(), frame.getMenu()));
        this.dynamicUpgrade(menu);
        this.setComponentZOrder(menu, 0);
    }
}