package com.Library.GUI;

import com.Library.App.AppGUI;
import com.Library.App.LoginLogic;
import com.Library.Utils.FileManager;
import com.Library.Utils.JPanelTemplate;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * <h1>Login</h1>
 * Třída s grafickým rozhraním pro přihlášení uživatele.
 * Některé grafické doplňky dědí z JPanelTemplate
 *
 * @file Login.java
 * @brief GUI Login.
 *
 * @class Login
 * @brief Třída GUI pro Login.
 *
 * @see JPanelTemplate
 */
public class Login extends JPanelTemplate {
    /**
     * Pole pro nickname.
     */
    private JTextField nicknameTextField;
    /**
     * Pole pro heslo.
     */
    private JPasswordField passwordTextField;
    /**
     * Checkbox pro zapamatování si uživatele.
     */
    private JCheckBox rememberMe;
    /**
     * Nadřazený frame.
     */
    public AppGUI frame;
    /**
     * Klíč, podle kterého se šifrují data.
     */
    private String key = "Venom";

    public JButton login;
    public JButton register;

    /**
     * Konstruktor aplikace.
     * Dochází zde ke sestavení panelu.
     *
     * @param frame     nadřazený frame
     * @param isVisible viditelnost
     */
    public Login(AppGUI frame, boolean isVisible) {
        super(frame.getWidth(), frame.getHeight(), isVisible);
        this.frame = frame;
    }

    /**
     * Načtení jednotlivých komponent.
     */
    @Override
    public void loadCustomComponents() {
        this.nicknameTextField();
        this.nickNameLabel();
        this.passwordTextField();
        this.passwordLabel();
        this.loginButton();
        this.hrefToRegister();
        this.rememberMe();
        this.exitApplication();
        this.checkRememberUser();
    }

    /**
     * @return klíč šifrování
     */
    public String getKey() {
        return this.key;
    }

    /**
     * Uložení dat o zapamatovaném uživateli.
     *
     * @see FileManager
     * @see File
     */
    private void checkRememberUser() {
        File tmpDir = new File(FileManager.pathToUserData);
        if (tmpDir.exists()) {
            String data = FileManager.decrypt(this.key);
            data = data.replace("[", "").replace("]", "");
            String[] dataArray = data.split(",");
            instantlyLog(dataArray[0], dataArray[1]);
            this.rememberMe.setSelected(true);
        }
    }

    /**
     * Nadpis, Nickname
     */
    private void nickNameLabel() {
        JLabel nameLabel = customJLabel("Nickname:", 20);
        nameLabel.setBounds(100, 65, 300, 50);
    }

    /**
     * Pole, Nickname
     */
    private void nicknameTextField() {
        this.nicknameTextField = customJTextField();
        this.nicknameTextField.setBounds(90, 100, 300, 50);
    }

    /**
     * Nadpis, Heslo
     */
    private void passwordLabel() {
        JLabel passwdLabel = customJLabel("Password:", 20);
        passwdLabel.setBounds(100, 145, 300, 50);
    }

    /**
     * Pole, Heslo
     */
    private void passwordTextField() {
        this.passwordTextField = customJPasswordField();
        this.passwordTextField.setBounds(90, 180, 300, 50);
    }

    /**
     * Odkaz na registraci.
     */
    private void hrefToRegister() {
        this.register = new JButton("register");
        this.register.setBounds(158, 305, this.buttonsWidth - 20, this.buttonsHeight - 20);
        this.dynamicUpgrade(this.register);
        this.register.setText("register");
        Font tmp = new Font("TimesRoman", Font.PLAIN, 15);
        this.register.setFont(tmp.deriveFont(tmp.getStyle() | Font.BOLD));
        this.register.setForeground(Color.WHITE);
        this.register.addActionListener(e -> frame.swapScreen(frame.getLogin(), frame.getRegister()));
    }

    /**
     * Checkbox, zapamatování uživatele.
     */
    private void rememberMe() {
        this.rememberMe = new JCheckBox("Remember me.");
        this.rememberMe.setBounds(100, 215, 300, 50);
        this.rememberMe.setForeground(Color.WHITE);
        this.rememberMe.setFocusable(false);
        this.rememberMe.setOpaque(false);
        this.add(this.rememberMe);
    }

    /**
     * Tlačítko pro přihlášení.
     */
    private void loginButton() {
        this.login = new JButton("Button", loadImageFromPackage("buttonLogin.png"));
        this.login.setBounds(148, 255, this.buttonsWidth, this.buttonsHeight);
        this.login.addActionListener(e -> collectAndEvaluate());
        this.dynamicUpgrade(this.login);
    }

    /**
     * Pozbírá data z formuláře.
     * Vyhodnotí data a ověří na základě DB.
     *
     * @see LoginLogic
     */
    private void collectAndEvaluate() {
        if (AppGUI.account == null) {
            String nickname = this.nicknameTextField.getText();
            char[] password = this.passwordTextField.getPassword();
            boolean isRemember = this.rememberMe.isSelected();

            int statement = LoginLogic.checkLogin(this, nickname, password, isRemember);

            if (statement == 500) {
                showDangerAlert("Incorrect data!");
                FileManager.log("User with nickname: " + nicknameTextField.getText() + " tried to sign in.");
                this.clearForm();
            }
        }
    }

    /**
     * Tlačítko na vypnutí aplikace.
     */
    private void exitApplication() {
        JButton button = new JButton("exitApp", loadImageFromPackage("buttonExit.png"));
        button.setBounds(148, 405, this.buttonsWidth, this.buttonsHeight);
        this.dynamicUpgrade(button);
        button.addActionListener(e -> {
            FileManager.log("Shutting down application.");
            Runtime.getRuntime().exit(0);
        });
    }

    /**
     * Předvyplní formulář daty uživatele.
     *
     * @param name   nickname
     * @param passwd heslo
     */
    public void instantlyLog(String name, String passwd) {
        this.nicknameTextField.setText(name);
        this.passwordTextField.setText(passwd);
    }

    /**
     * Vyčistí formulář.
     */
    public void clearForm() {
        this.passwordTextField.setText("");
        this.nicknameTextField.setText("");
        this.rememberMe.setSelected(false);
    }
}
