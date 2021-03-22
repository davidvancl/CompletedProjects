package com.Library.Utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * <h1>BookFilter</h1>
 * Třída BookFilter předdefinovaný template pro filtry na DB.
 * Dědí z JPanel
 *
 * @file BookFilter.java
 * @brief Filtr aplikovaný na vyhledávání.
 *
 * @class BookFilter
 * @brief Třída filter aplikující se na DB.
 *
 * @see JPanel
 */
public class BookFilter extends JPanel {
    /**
     * tableName
     */
    private String tableName;
    /**
     * mainPanel
     */
    private JPanel mainPanel;
    /**
     * checkBoxWidth = 80
     */
    private int checkBoxWidth = 80;
    /**
     * checkBoxHeight = 20
     */
    private int checkBoxHeight = 20;
    /**
     * jTextFieldWidth = 120
     */
    private int jTextFieldWidth = 120;
    /**
     * jTextFieldHeight = 30
     */
    private int jTextFieldHeight = 30;
    /**
     * inputImage
     */
    private Image inputImage;

    /**
     * params
     */
    private ArrayList<String> params = new ArrayList<String>();
    private StringBuilder SQL = new StringBuilder();

    //FILTER ITEMS
    public JCheckBox bookFieldCheck;
    public JCheckBox bookWriterCheck;
    public JCheckBox bookPublisherCheck;
    public JCheckBox bookNameCheck;
    public JCheckBox publicationYearCheck;
    public JCheckBox publicationNumberCheck;

    public JTextField bookFieldText;
    public JTextField bookWriterText;
    public JTextField bookPublisherText;
    public JTextField bookNameText;
    public JTextField bookPubYearText;
    public JTextField bookPubNumberText;

    /**
     * Konstruktor Filtru
     *
     * @param mainPanel nadřazený panel
     * @param tableName název tabulky
     */
    public BookFilter(JPanel mainPanel, String tableName) {
        this.tableName = tableName;
        this.mainPanel = mainPanel;

        this.setBounds(this.getX(), this.getY(), 410, 130);
        this.setOpaque(false);
        this.setLayout(null);
        mainPanel.add(this);

        this.loadComponents();
    }

    /**
     * Načte komponenty
     */
    private void loadComponents() {
        this.loadBookFieldCheckBox();
        this.loadBookWriterCheckBox();
        this.loadBookPublisherCheckBox();
        this.loadBookNameCheckBox();
        this.loadPublicationNumberCheckBox();
        this.loadPublicationYearCheckBox();

        this.loadBookJTextField();
        this.loadWriterJTextField();
        this.loadBookNameJTextField();
        this.loadPublisherJTextField();
        this.loadPubYearJTextField();
        this.loadPubNumberJTextField();

    }

    private void loadBookFieldCheckBox() {
        this.bookFieldCheck = new JCheckBox("Field");
        this.customizeCheckBox(this.bookFieldCheck, 5, 10);
    }

    private void loadBookJTextField() {
        this.bookFieldText = this.customizeJTextField(70, 5);
    }

    private void loadBookWriterCheckBox() {
        this.bookWriterCheck = new JCheckBox("Writer");
        this.customizeCheckBox(this.bookWriterCheck, 5, 50);
    }

    private void loadWriterJTextField() {
        this.bookWriterText = this.customizeJTextField(70, 45);
    }

    private void loadBookNameCheckBox() {
        this.bookNameCheck = new JCheckBox("Name");
        this.customizeCheckBox(this.bookNameCheck, 5, 90);
    }

    private void loadBookNameJTextField() {
        this.bookNameText = this.customizeJTextField(70, 85);
    }

    private void loadBookPublisherCheckBox() {
        this.bookPublisherCheck = new JCheckBox("Publisher");
        this.customizeCheckBox(this.bookPublisherCheck, 200, 10);
    }

    private void loadPublisherJTextField() {
        this.bookPublisherText = this.customizeJTextField(290, 5);
    }

    private void loadPublicationYearCheckBox() {
        this.publicationYearCheck = new JCheckBox("P. year");
        this.customizeCheckBox(this.publicationYearCheck, 200, 50);
    }

    private void loadPubYearJTextField() {
        this.bookPubYearText = this.customizeJTextField(290, 45);
    }

    private void loadPublicationNumberCheckBox() {
        this.publicationNumberCheck = new JCheckBox("P. numb.");
        this.customizeCheckBox(this.publicationNumberCheck, 200, 90);
    }

    private void loadPubNumberJTextField() {
        this.bookPubNumberText = this.customizeJTextField(290, 85);
    }

    private void customizeCheckBox(JCheckBox checkBox, int x, int y) {
        checkBox.setBounds(x, y, this.checkBoxWidth, this.checkBoxHeight);
        checkBox.setForeground(Color.white);
        checkBox.setFocusable(false);
        checkBox.setOpaque(false);
        this.add(checkBox);
    }

    private JTextField customizeJTextField(int x, int y) {
        JTextField textField = new JTextField() {
            private boolean load = true;

            public void paintComponent(Graphics g) {
                if (load) {
                    try {
                        inputImage = ImageIO.read(getClass().getResourceAsStream("/com/Library/Images/inputBackground.png")).getScaledInstance(jTextFieldWidth, jTextFieldHeight, Image.SCALE_DEFAULT);
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
        textField.setBounds(x, y, this.jTextFieldWidth, this.jTextFieldHeight);
        this.add(textField);
        return textField;
    }

    /**
     * Metoda pro sezbírání dat z filtru
     */
    public void collectData() {
        this.params.clear();
        this.SQL = new StringBuilder("SELECT * FROM ");

        if (!bookFieldCheck.isSelected() && !bookWriterCheck.isSelected() && !bookPublisherCheck.isSelected() && !bookNameCheck.isSelected() && !publicationYearCheck.isSelected() && !publicationNumberCheck.isSelected()) {
            this.SQL.append(this.tableName).append(" ");
        } else {
            this.SQL.append(this.tableName).append(" WHERE ");
            if (bookFieldCheck.isSelected()) {
                this.SQL.append("BOOK_FIELD LIKE ? AND ");
                this.params.add(this.bookFieldText.getText());
            }
            if (bookWriterCheck.isSelected()) {
                this.SQL.append("BOOK_WRITER LIKE ? AND ");
                this.params.add(this.bookWriterText.getText());
            }
            if (bookPublisherCheck.isSelected()) {
                this.SQL.append("BOOK_PUBLISHER LIKE ? AND ");
                this.params.add(this.bookPublisherText.getText());
            }
            if (bookNameCheck.isSelected()) {
                this.SQL.append("BOOK_NAME LIKE ? AND ");
                this.params.add(this.bookNameText.getText());
            }
            if (publicationYearCheck.isSelected()) {
                this.SQL.append("BOOK_PUBLICATION_YEAR LIKE ? AND ");
                this.params.add(this.bookPubYearText.getText());
            }
            if (publicationNumberCheck.isSelected()) {
                this.SQL.append("BOOK_PUBLICATION_NUMBER LIKE ? AND ");
                this.params.add(this.bookPubNumberText.getText());
            }
            this.SQL.setLength(SQL.length() - 4);
        }
        this.SQL.append("LIMIT 5 OFFSET 0");
    }

    /**
     * Vrací použité SQL
     *
     * @return SQL
     */
    public String getSQL() {
        return this.SQL.toString();
    }

    /**
     * Použité parametry
     *
     * @return parametry
     */
    public ArrayList<String> getParams() {
        return this.params;
    }
}
