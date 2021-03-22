package com.Library.GUI;

import com.Library.App.AppGUI;
import com.Library.App.RegisterLogic;
import com.Library.Utils.FileManager;
import com.Library.Utils.FormUtils;
import com.Library.Utils.JPanelTemplate;
import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.*;
import java.awt.*;

/**
 * <h1>Register</h1>
 * Třída vytvářející formulář k registraci.
 * Dědí ze třídy JPanelTemplate.
 *
 * @file Register.java
 * @brief GUI Register.
 *
 * @class Register
 * @brief Třída GUI pro Register.
 *
 * @see JPanelTemplate
 */
public final class Register extends JPanelTemplate {
    /**
     * Input, nickname.
     */
    private JTextField nicknameTextField;
    /**
     * Input, jméno.
     */
    private JTextField nameTextField;
    /**
     * Input, příjmení.
     */
    private JTextField surnameTextField;
    /**
     * Input, heslo.
     */
    private JPasswordField passwordTextField;
    /**
     * Input, potvrzení hesla.
     */
    private JPasswordField confirmPasswordTextField;
    /**
     * Input, výber datumu.
     */
    private DatePicker datePicker;
    /**
     * Nadřazené okno.
     */
    private AppGUI frame;

    public JButton register;
    public JButton login;

    /**
     * Konstruktor třídy Register
     *
     * @param frame     nadřazené okno
     * @param isVisible viditelnost
     */
    public Register(AppGUI frame, boolean isVisible) {
        super(frame.getWidth(), frame.getHeight(), isVisible);
        this.frame = frame;
    }

    /**
     * Načtení jednotlivých komponent.
     */
    @Override
    public void loadCustomComponents() {
        this.registerButton();
        this.nicknameTextField();
        this.passwordTextField();
        this.confirmPasswordTextField();
        this.nickNameLabel();
        this.passwordLabel();
        this.nameTextField();
        this.nameLabel();
        this.hrefToLogin();
        this.bornDatePicker();
        this.bornLabel();
        this.surnameJTextField();
        this.surnameLabel();
    }

    public void insertData(String nickname,String name,String surname,String born,String password){
        this.nicknameTextField.setText(nickname);
        this.nameTextField.setText(name);
        this.surnameTextField.setText(surname);
        this.datePicker.setText(born);
        this.passwordTextField.setText(password);
        this.confirmPasswordTextField.setText(password);
    }

    /**
     * Tlačítko na registraci.
     */
    private void registerButton() {
        this.register = new JButton("Button", loadImageFromPackage("buttonRegister.png"));
        this.register.setBounds(148, 410, this.buttonsWidth, this.buttonsHeight);
        this.dynamicUpgrade(this.register);
        this.register.addActionListener(e -> collectAndEvaluate());
    }

    /**
     * Nadpis, nickname.
     */
    private void nickNameLabel() {
        JLabel nameLabel = customJLabel("Login ID:", 20);
        nameLabel.setBounds(100, 0, 300, 50);
    }

    /**
     * Imput, nickname.
     */
    private void nicknameTextField() {
        this.nicknameTextField = customJTextField();
        this.nicknameTextField.setBounds(90, 35, 300, 50);
    }

    /**
     * Nadpis, jméno.
     */
    private void nameLabel() {
        JLabel nameLabel = customJLabel("Name:", 20);
        nameLabel.setBounds(100, 70, 300, 50);
    }

    /**
     * Input, jméno.
     */
    private void nameTextField() {
        this.nameTextField = customJTextField();
        this.nameTextField.setBounds(90, 105, 300, 50);
    }

    /**
     * Nadpis, přijmení.
     */
    private void surnameLabel() {
        JLabel label = customJLabel("Surname:", 20);
        label.setBounds(100, 140, 300, 50);
    }

    /**
     * Input, přijmení.
     */
    private void surnameJTextField() {
        this.surnameTextField = customJTextField();
        this.surnameTextField.setBounds(90, 175, 300, 50);
    }

    /**
     * Nadpis, narození.
     */
    private void bornLabel() {
        JLabel bornLabel = customJLabel("Born date:", 20);
        bornLabel.setBounds(100, 210, 300, 50);
    }

    /**
     * Input, narození.
     */
    private void bornDatePicker() {
        this.datePicker = new DatePicker();
        this.datePicker.setBorder(null);
        this.datePicker.setBounds(95, 245, 290, 50);
        JTextField textField = this.datePicker.getComponentDateTextField();
        textField.setOpaque(false);
        this.datePicker.setSettings(null);
        textField.setVisible(true);
        textField.setBorder(null);
        textField.setBounds(textField.getX(), textField.getY(), 110, 50);
        textField.setEditable(false);
        this.add(this.datePicker);
    }

    /**
     * Nadpis, heslo.
     */
    private void passwordLabel() {
        JLabel passwdLabel = customJLabel("Password match:", 20);
        passwdLabel.setBounds(100, 280, 300, 50);
    }

    /**
     * Input, heslo.
     */
    private void passwordTextField() {
        this.passwordTextField = customJPasswordField();
        this.passwordTextField.setBounds(90, 315, 300, 50);
    }

    /**
     * Input, potvrzení hesla.
     */
    private void confirmPasswordTextField() {
        this.confirmPasswordTextField = customJPasswordField();
        this.confirmPasswordTextField.setBounds(90, 360, 300, 50);
    }

    /**
     * Odkaz na přihlášení.
     */
    private void hrefToLogin() {
        this.login = new JButton("login");
        this.login.setBounds(350, 0, this.buttonsWidth - 20, this.buttonsHeight - 20);
        this.dynamicUpgrade(this.login);
        this.login.setText("login");
        Font tmp = new Font("TimesRoman", Font.PLAIN, 15);
        this.login.setFont(tmp.deriveFont(tmp.getStyle() | Font.BOLD));
        this.login.setForeground(Color.WHITE);
        this.login.addActionListener(e -> frame.swapScreen(frame.getRegister(), frame.getLogin()));
    }

    /**
     * Sezbírá a vyhodnotí data z registrace.
     * Pokud budou platná zapíše je do databáze.
     *
     * @see RegisterLogic
     */
    private void collectAndEvaluate() {
        StringBuilder errorMessage = new StringBuilder();
        boolean showAlert = false;

        if (!FormUtils.nicknameCorrection(this.nicknameTextField.getText())) {
            errorMessage.append("Nickname, ");
            showAlert = true;
        }

        if (!FormUtils.nameCorrection(this.nameTextField.getText())) {
            errorMessage.append("Name, ");
            showAlert = true;
        }
        if (!FormUtils.nameCorrection(this.surnameTextField.getText())) {
            errorMessage.append("Surname, ");
            showAlert = true;
        }

        if (!FormUtils.passwordCorrection(new String(this.passwordTextField.getPassword()))) {
            errorMessage.append("Password, ");
            showAlert = true;
        }

        if (!FormUtils.matchTwoStrings(new String(this.passwordTextField.getPassword()), new String(this.confirmPasswordTextField.getPassword()))) {
            errorMessage.append("Password not same, ");
            showAlert = true;
        }

        if (this.datePicker.getText().trim().equals("")) {
            errorMessage.append("Date, ");
            showAlert = true;
        }

        errorMessage.append("incorrect");

        if (showAlert) {
            showDangerAlert(errorMessage.toString());
        } else {
            boolean result = RegisterLogic.registerUser(this.nameTextField.getText().trim(), this.surnameTextField.getText().trim(), this.nicknameTextField.getText().trim(), this.passwordTextField.getPassword(), this.datePicker.getText());
            if (result) {
                this.clearForm();
                showSuccessAlert("Registered.");
                FileManager.log("User: " + this.nicknameTextField.getText().trim() + " has been registered.");
            } else {
                showDangerAlert("Nickname is already used.");
                FileManager.log("Registration failed for nickname: " + this.nicknameTextField.getText().trim());
            }
        }
    }

    /**
     * Vyčištění formuláře.
     */
    private void clearForm() {
        this.nameTextField.setText("");
        this.nicknameTextField.setText("");
        this.passwordTextField.setText("");
        this.confirmPasswordTextField.setText("");
        this.datePicker.setText("");
        this.surnameTextField.setText("");
    }
}
