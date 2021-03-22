package com.Library.GUI;

import com.Library.App.AppGUI;
import com.Library.App.ManageLogic;
import com.Library.Utils.JPanelTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * <h1>Manage</h1>
 * Třída určená pro uživatele s oprávněním SuperUser
 * Třída je děděna z JPanelTemplate
 *
 * @see JPanelTemplate
 */
public class Manage extends JPanelTemplate {
    /**
     * Nadřazený frame.
     */
    private AppGUI frame;
    /**
     * Uložení cesty.
     */
    private String selectedPath = "";
    /**
     * Zobrazení cesty.
     */
    private JTextField labelPath;
    /**
     * Radio Users export
     */
    private JTextField nickname;
    /**
     * Radio Users export
     */
    private JRadioButton button1;
    /**
     * Radio Books export
     */
    private JRadioButton button2;
    /**
     * Radio SuperUser
     */
    private JRadioButton superUser;
    /**
     * Radio classicUser
     */
    private JRadioButton classicUser;

    private JRadioButton directory;
    private JRadioButton file;

    /**
     * Konstruktor třídy JPanelTemplate
     * Nastaví základní parametry panelu.
     *
     * @param frame     nadřazené okno
     * @param isVisible viditelnost okna
     */
    public Manage(AppGUI frame, boolean isVisible) {
        super(frame.getWidth(), frame.getHeight(), isVisible);
        this.frame = frame;
    }

    /**
     * Načtení jednotlivých komponent.
     */
    @Override
    public void loadCustomComponents() {
        this.loadPickUrlButton();
        this.loadTitlePath();
        this.loadPathString();
        this.loadExporterButton();
        this.loadSelectExport();
        this.loadExportTitle();
        this.loadMenuButton();
        this.loadPermissionsTitle();
        this.loadPermissionsButton();
        this.loadInputNickname();
        this.loadUserTypeSelection();
        this.loadSelectChoose();
        this.loadImport();
    }

    /**
     * Titulek cesty.
     */
    private void loadTitlePath() {
        JLabel pathLabel = customJLabel("Path:", 20);
        pathLabel.setBounds(100, 35, 300, 50);
    }

    /**
     * Titulek oprávnění.
     */
    private void loadExportTitle() {
        JLabel pathLabel = customJLabel("Export:", 20);
        pathLabel.setBounds(10, 0, 300, 50);
    }

    /**
     * Titulek oprávnění.
     */
    private void loadPermissionsTitle() {
        JLabel pathLabel = customJLabel("Permissions:", 20);
        pathLabel.setBounds(10, 200, 300, 50);
    }

    /**
     * Input cesty k souboru.
     */
    private void loadPathString() {
        this.labelPath = customJTextField();
        this.labelPath.setBounds(90, 75, 300, 50);
        this.labelPath.setEditable(false);
    }

    /**
     * Tlačítko export.
     */
    private void loadExporterButton() {
        JButton button = new JButton("export", loadImageFromPackage("buttonExport.png"));
        button.setBounds(40, 160, this.buttonsWidth, this.buttonsHeight);
        this.dynamicUpgrade(button);
        button.addActionListener(e -> this.export());
    }

    private void loadImport(){
        JButton button = new JButton("import", loadImageFromPackage("buttonImport.png"));
        button.setBounds(260, 160, this.buttonsWidth, this.buttonsHeight);
        this.dynamicUpgrade(button);
        button.addActionListener(e -> this.importUsers());
    }

    private void loadSelectChoose(){
        this.file = new JRadioButton("File");
        this.file.setMnemonic(KeyEvent.VK_B);
        this.file.setBounds(340, 20, 60, 20);
        this.file.setSelected(true);
        this.updateRadios(this.file);

        this.directory = new JRadioButton("Directory");
        this.directory.setMnemonic(KeyEvent.VK_C);
        this.directory.setBounds(340, 40, 70, 20);
        this.updateRadios(this.directory);

        ButtonGroup group = new ButtonGroup();
        group.add(this.file);
        group.add(this.directory);
    }

    /**
     * Tlačítko na výběr URL
     */
    private void loadPickUrlButton() {
        JButton button = new JButton("exitApp", loadImageFromPackage("buttonURL.png"));
        button.setBounds(148, 20, this.buttonsWidth, this.buttonsHeight);
        this.dynamicUpgrade(button);
        button.addActionListener(e -> {
            String tmpPath;
            if(this.file.isSelected()){
                tmpPath = ManageLogic.chooseFile();
            } else {
                tmpPath = ManageLogic.chooseDirectory();
            }
            if (!tmpPath.equals("")) {
                this.selectedPath = tmpPath;
                this.labelPath.setText(tmpPath);
                showSuccessAlert(tmpPath);
            }
        });
    }

    /**
     * Input pro nickname.
     */
    private void loadInputNickname() {
        this.nickname = customJTextField();
        this.nickname.setBounds(90, 240, 300, 50);
    }

    /**
     * Tlačítko na změnu oprávnění
     */
    private void loadPermissionsButton() {
        JButton button = new JButton("permissions", loadImageFromPackage("buttonChange.png"));
        button.setBounds(148, 330, this.buttonsWidth, this.buttonsHeight);
        this.dynamicUpgrade(button);
        button.addActionListener(e -> {
            if (!nickname.getText().trim().equals("")) {
                if (ManageLogic.checkIfUserExists(nickname.getText())) {
                    String permissions;
                    if (superUser.isSelected()) {
                        permissions = "SuperUser";
                    } else {
                        permissions = "User";
                    }
                    ManageLogic.setUserPermissions(nickname.getText(), permissions);
                    showSuccessAlert("Permissions changed.");
                    this.clearForms();
                } else {
                    showDangerAlert("Non existence user.");
                }
            } else {
                showDangerAlert("Set username.");
            }
        });
    }

    /**
     * Vyčistí formulář.
     */
    private void clearForms() {
        this.nickname.setText("");
    }

    /**
     * Výběr mezi druhem exportu.
     */
    private void loadSelectExport() {
        this.button1 = new JRadioButton("Users");
        this.button1.setMnemonic(KeyEvent.VK_B);
        this.button1.setBounds(100, 130, 60, 20);
        this.updateRadios(this.button1);

        this.button2 = new JRadioButton("Books");
        this.button2.setMnemonic(KeyEvent.VK_C);
        this.button2.setBounds(160, 130, 70, 20);
        this.updateRadios(this.button2);

        JRadioButton button3 = new JRadioButton("Orders");
        button3.setMnemonic(KeyEvent.VK_D);
        button3.setSelected(true);
        button3.setBounds(225, 130, 70, 20);
        this.updateRadios(button3);

        ButtonGroup group = new ButtonGroup();
        group.add(this.button1);
        group.add(this.button2);
        group.add(button3);
    }

    /**
     * Výběr mezi SuperUser a User
     */
    private void loadUserTypeSelection() {
        this.classicUser = new JRadioButton("Classic user");
        this.classicUser.setMnemonic(KeyEvent.VK_B);
        this.classicUser.setBounds(100, 300, 120, 20);
        this.classicUser.setSelected(true);
        this.updateRadios(this.classicUser);

        this.superUser = new JRadioButton("Super user");
        this.superUser.setMnemonic(KeyEvent.VK_C);
        this.superUser.setBounds(220, 300, 90, 20);
        this.updateRadios(this.superUser);

        ButtonGroup group = new ButtonGroup();
        group.add(this.superUser);
        group.add(this.classicUser);
    }

    /**
     * Dynamicky upraví radioButton
     *
     * @param radioButton radioButton
     */
    private void updateRadios(JRadioButton radioButton) {
        radioButton.setOpaque(false);
        radioButton.setForeground(Color.WHITE);
        radioButton.setFocusable(false);
        this.add(radioButton);
    }

    /**
     * Metoda exportování dat do textového souboru.
     */
    private void export() {
        if (!this.selectedPath.equals("")) {
            File file = new File(this.selectedPath);
            if(file.isDirectory()) {
                boolean statement;
                if (button1.isSelected()) {
                    statement = ManageLogic.exportUsersToTxt(this.selectedPath);
                } else if (button2.isSelected()) {
                    statement = ManageLogic.exportBooksToTxt(this.selectedPath);
                } else {
                    statement = ManageLogic.exportOrdersToTxt(this.selectedPath);
                }
                if (statement) {
                    showSuccessAlert("Exported");
                } else {
                    showDangerAlert("Something wrong.");
                }
            } else {
                showDangerAlert("Set folder path please.");
            }
        } else {
            showDangerAlert("Set folder path please.");
        }
    }

    private void importUsers(){
        if (!this.selectedPath.equals("")) {
            File file = new File(this.selectedPath);
            if(file.isFile()) {
                ManageLogic.importUser(this.selectedPath);
                showSuccessAlert("Set file path please.");
            } else {
                showDangerAlert("Set file path please.");
            }
        } else {
            showDangerAlert("Set file path please.");
        }
    }

    /**
     * Tlačítko do Menu.
     */
    private void loadMenuButton() {
        JButton button = new JButton("Menu", loadImageFromPackage("buttonMenu.png"));
        button.setBounds(148, 405, this.buttonsWidth, this.buttonsHeight);
        button.addActionListener(e -> frame.swapScreen(frame.getManage(), frame.getMenu()));
        this.dynamicUpgrade(button);
        this.setComponentZOrder(button, 0);
    }
}
