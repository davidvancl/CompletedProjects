package com.Library.Utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

/**
 * <h1>JPanelTemplate</h1>
 * Třída JPanelTemplate slouží jako podklad do záložek:
 *
 * @file JPanelTemplate.java
 * @brief Třída JPanelTemplate slouží jako podklad do záložek.
 *
 * @class JPanelTemplate
 * @brief Třída JPanelTemplate slouží jako podklad do záložek.
 *
 * @see com.Library.GUI.Menu
 * @see com.Library.GUI.Cart
 * @see com.Library.GUI.Register
 * @see com.Library.GUI.Order
 * @see com.Library.GUI.Login
 * @see com.Library.GUI.ListLibrary
 * <p>
 * Implementuje JPanelInterface
 * @see JPanelInterface
 * <p>
 * Dědí z třídy JPanel
 * @see JPanel
 */
public abstract class JPanelTemplate extends JPanel implements JPanelInterface {
    /**
     * Šířka tlačítka.
     */
    protected int buttonsWidth = 190;
    /**
     * Výška tlačítka.
     */
    protected int buttonsHeight = 50;
    /**
     * Obrázek na pozadí.
     */
    protected Image test;
    /**
     * Šířka okna.
     */
    protected int width;
    /**
     * Výška okna.
     */
    protected int height;
    /**
     * Viditelnost okna.
     */
    protected boolean isVisible;
    /**
     * Pozadí do inputů.
     */
    protected Image inputImage = null;
    /**
     * ERROR ALERT
     */
    private JLabel dangerAlert;
    /**
     * SUCCESS ALERT
     */
    private JLabel successAlert;

    /**
     * Konstruktor třídy JPanelTemplate
     * Nastaví základní parametry panelu.
     *
     * @param width     šířka okna
     * @param height    výška okna
     * @param isVisible viditelnost okna
     */
    public JPanelTemplate(int width, int height, boolean isVisible) {
        this.height = height - 20;
        this.width = width - 15;
        this.isVisible = isVisible;

        this.setLayout(null);
        this.setSize(this.width, this.height);
        this.setVisible(isVisible);
    }

    /**
     * @return šířku aplikace
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * @return výšku aplikace
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Nastaví novou šířku okna
     *
     * @param newWidth šířka
     */
    public void setWidth(int newWidth) {
        this.setBounds(0, 0, newWidth, this.height);
        this.width = newWidth;
    }

    /**
     * Nastaví novou výšku aplikace.
     *
     * @param newHeight výška
     */
    public void setHeight(int newHeight) {
        this.setBounds(0, 0, this.width, newHeight);
        this.height = newHeight;
    }

    /**
     * Proměnná pro načtení obrázku.
     */
    private boolean load = true;

    /**
     * Metoda na vykreslení pozadí.
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        if (this.load) {
            try {
                this.test = ImageIO.read(getClass().getResourceAsStream("/com/Library/Images/menuBackground.png"));
            } catch (Exception e) {
                FileManager.log(e.toString());
            }

            //load components
            this.loadCustomComponents();
            //load alerts
            this.createSuccessAlert();
            this.createDanderAlert();
            this.load = false;
        }
        super.paintComponent(g);
        g.drawImage(this.test.getScaledInstance(this.width, this.height, Image.SCALE_DEFAULT), 0, 0, null);
    }

    /**
     * Přetížená metoda na načtení obrázku.
     *
     * @param packageImage Cesta k obrázku.
     * @return ImageIcon
     */
    protected ImageIcon loadImageFromPackage(String packageImage) {
        return loadImageFromPackage(packageImage, this.buttonsWidth, this.buttonsHeight);
    }

    /**
     * Metoda na načtení obrázku.
     *
     * @param packageImage cesta
     * @param x            šířka
     * @param y            výška
     * @return ImageIcon
     */
    protected ImageIcon loadImageFromPackage(String packageImage, int x, int y) {
        Image img = null;
        try {
            img = ImageIO.read(getClass().getResourceAsStream("/com/Library/Images/" + packageImage));
        } catch (Exception e) {
            FileManager.log(e.toString());
        }
        return new ImageIcon(img.getScaledInstance(x - 10, y, Image.SCALE_DEFAULT));
    }

    /**
     * Metoda na grafickou úpravu tlačítka.
     *
     * @param button tlačítko na úpravu
     */
    protected void dynamicUpgrade(JButton button) {
        button.setBorderPainted(false);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setText("");
        button.setFocusable(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.add(button);
    }

    protected JTextField customJTextField(){
        return customJTextField(300,50);
    }

    /**
     * Vytvoří graficky upravený JTextField
     *
     * @return vrátí předpřipravený input
     */
    protected JTextField customJTextField(int width1,int height1) {
        JTextField textField = new JTextField() {
            private boolean load = true;
            public void paintComponent(Graphics g) {
                if (load) {
                    try {
                        inputImage = ImageIO.read(getClass().getResourceAsStream("/com/Library/Images/inputBackground.png")).getScaledInstance(width1, height1, Image.SCALE_DEFAULT);
                    } catch (Exception e) {
                        FileManager.log(e.toString());
                    }
                    load = false;
                }
                g.drawImage(inputImage, 0, 0, null);
                super.paintComponent(g);
            }
        };
        textField.setOpaque(false);
        textField.setBorder(null);
        textField.setHorizontalAlignment(JTextField.CENTER);
        Font tmp = new Font("TimesRoman", Font.PLAIN, 15);
        textField.setFont(tmp.deriveFont(tmp.getStyle() | Font.BOLD));
        textField.setForeground(Color.BLACK);
        this.add(textField);
        return textField;
    }

    /**
     * Vytvoří graficky upravený JPasswordField
     *
     * @return vrátí předpřipravený password input
     */
    protected JPasswordField customJPasswordField() {
        JPasswordField passwordField = new JPasswordField() {
            private boolean load = true;

            public void paintComponent(Graphics g) {
                if (load) {
                    try {
                        inputImage = ImageIO.read(getClass().getResourceAsStream("/com/Library/Images/inputBackground.png")).getScaledInstance(300, 50, Image.SCALE_DEFAULT);
                    } catch (Exception e) {
                        FileManager.log(e.toString());
                    }
                    load = false;
                }
                g.drawImage(inputImage, 0, 0, null);
                super.paintComponent(g);
            }
        };
        passwordField.setOpaque(false);
        passwordField.setBorder(null);
        passwordField.setHorizontalAlignment(JTextField.CENTER);
        this.add(passwordField);
        return passwordField;
    }

    /**
     * Funkce připravující label na nadpisy.
     *
     * @param text text do nadpisu
     * @param size velikost textu
     * @return vrátí nadpis, JLabel
     */
    protected JLabel customJLabel(String text, int size) {
        JLabel label = new JLabel(text);
        Font tmp = new Font("TimesRoman", Font.PLAIN, size);
        label.setFont(tmp.deriveFont(tmp.getStyle() | Font.BOLD));
        label.setForeground(Color.WHITE);
        this.add(label);
        return label;
    }

    /**
     * Vytvoří sdílený alert upravený pro pozitivní zprávy.
     */
    private void createSuccessAlert() {
        this.successAlert = customJLabel("Success alert", 20);
        this.successAlert.setBackground(Color.GREEN);
        this.setComponentZOrder(this.successAlert, 0);
        customizeAlert(this.successAlert);
    }

    /**
     * Vytvoří sdílený alert upravený pro negativní zprávy.
     */
    private void createDanderAlert() {
        this.dangerAlert = customJLabel("Dander alert", 20);
        this.dangerAlert.setBackground(Color.RED);
        this.setComponentZOrder(this.dangerAlert, 0);
        customizeAlert(this.dangerAlert);
    }


    /**
     * Upraví alert a naformátuje do správné grafické parametry.
     *
     * @param label alert
     */
    private void customizeAlert(JLabel label) {
        label.setBounds(0, 0, this.width, 40);
        label.setOpaque(true);
        label.setHorizontalAlignment(JTextField.CENTER);
        label.setForeground(Color.BLACK);
        label.setVisible(false);
    }

    /**
     * Metoda automaticky skrývající pozitivní alert po intervalu.
     *
     * @param text Zpráva
     */
    protected void showSuccessAlert(String text) {
        this.successAlert.setText(text);
        this.successAlert.setVisible(true);
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        successAlert.setVisible(false);
                    }
                },
                2000
        );
    }

    /**
     * Metoda automaticky skrývající negativní alert po intervalu.
     *
     * @param text Zpráva
     */
    protected void showDangerAlert(String text) {
        this.dangerAlert.setText(text);
        this.dangerAlert.setVisible(true);
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        dangerAlert.setVisible(false);
                    }
                },
                2000
        );
    }
}
