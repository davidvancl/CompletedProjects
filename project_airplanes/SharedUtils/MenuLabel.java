package com.projectAirlines.SharedUtils;

import com.projectAirlines.Main;
import com.projectAirlines.MenuInterface.GameMenu;
import com.projectAirlines.Tools.ConfigFile;
import com.projectAirlines.Tools.GraphicUtils;
import com.projectAirlines.Tools.ProjectPath;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class which specialize bar in menu
 *
 * @see GameMenu
 */
public class MenuLabel extends JPanel {
    private String border = ProjectPath.getGraphicPath("menuBorder.png");
    private ButtonGroup airplanesSelection = new ButtonGroup();
    private List<JRadioButton> buttonList = new ArrayList<JRadioButton>();
    private InetAddress inetAddress = InetAddress.getLocalHost();
    private int widthOfMenuPanel = 400;
    private int heightOfMenuPanel = 400;
    private JTextField nameField;
    private JButton joinButton;
    private JButton saveButton;
    private JTextField ipField;
    private JFrame frame;


    /**
     * Constructor of JLabel and load components
     *
     * @param widthScreen  Integer, X size of screen
     * @param heightScreen Integer, Y size of screen
     * @param frame        JFrame, main window of menu
     * @throws UnknownHostException exception used when app try find IP address
     */
    public MenuLabel(int widthScreen, int heightScreen, JFrame frame) throws IOException {
        this.frame = frame;

        //load panel
        setBounds((widthScreen / 2) - (this.widthOfMenuPanel / 2), (heightScreen / 2) - (this.heightOfMenuPanel / 2) - 25, this.widthOfMenuPanel, this.heightOfMenuPanel);
        setLayout(null);

        //load components
        loadIPTextField();
        loadJoinButton();
        loadNameTextField();
        loadExitButton();
        loadAirplaneSelection();
        loadSaveNameButton();

        //add to main frame
        frame.add(this);

        //test inputs validation
        updateStatus();
    }

    /**
     * Method setting visibility of Label
     *
     * @param statement boolean,(true/false)
     */
    public void setBarVisibility(boolean statement) {
        setVisible(statement);
    }

    /**
     * Draws images in JLabel
     *
     * @param g Graphic, drawing images
     */
    protected void paintComponent(Graphics g) {
        try {
            g.drawImage(GraphicUtils.resize(ImageIO.read(new File(this.border)), this.heightOfMenuPanel, this.widthOfMenuPanel), 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Special method which load IP TextBox
     */
    private void loadIPTextField() {
        ipField = new JTextField();
        ipField.setText(this.inetAddress.getHostAddress());
        ipField.setLayout(null);
        ipField.setBounds(80, 30, 250, 30);
        ipField.setHorizontalAlignment(SwingConstants.CENTER);
        ipField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                updateStatus();
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                updateStatus();
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                updateStatus();
            }
        });
        this.add(ipField);
    }

    /**
     * Method which updates status of joinButton by setting
     * 1- RegExp of IP address
     * 2- Name length > 3
     */
    private void updateStatus() {
        Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
        Matcher matcher = pattern.matcher(this.ipField.getText());
        if (matcher.find() && this.nameField.getDocument().getLength() > 4) {
            this.joinButton.setEnabled(true);
            this.saveButton.setEnabled(true);
        } else {
            this.joinButton.setEnabled(false);
            this.saveButton.setEnabled(false);
        }
    }

    /**
     * Special method which load name TextBox
     */
    private void loadNameTextField() throws IOException {
        this.nameField = new JTextField();
        this.nameField.setBounds(80, 80, 200, 30);
        this.nameField.setText(ConfigFile.loadData("userName"));
        this.nameField.setHorizontalAlignment(SwingConstants.CENTER);
        this.nameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                updateStatus();
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                updateStatus();
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                updateStatus();
            }
        });
        this.add(this.nameField);
    }

    /**
     * Method which loads name saveButton
     * save to config file
     */
    private void loadSaveNameButton() throws IOException {
        this.saveButton = new JButton("", new ImageIcon(GraphicUtils.resize(ImageIO.read(new File(ProjectPath.getIconsPath("save.png"))), 20, 20)));
        this.saveButton.setBounds(285, 80, 45, 30);
        this.saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ConfigFile.saveConfig("userName", nameField.getText());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        this.saveButton.setEnabled(false);
        add(this.saveButton);
    }

    /**
     * Special method which load join Button
     */
    private void loadJoinButton() {
        this.joinButton = new JButton("JOIN GAME");
        this.joinButton.setBounds(80, 120, 250, 30);
        this.joinButton.setEnabled(false);
        this.joinButton.addActionListener(actionEvent -> {
            //TODO: start application
            String name = nameField.getText();
            try {
                Main.joinToTheGame();
            } catch (IOException e) {
                e.printStackTrace();
            }
            frame.dispose();
        });
        this.add(this.joinButton);
    }

    /**
     * Special method which determinate all running processes (EXIT)
     */
    private void loadExitButton() {
        JButton exitButton = new JButton("EXIT GAME");
        exitButton.setBounds(80, 350, 250, 30);
        exitButton.addActionListener(actionEvent -> Runtime.getRuntime().halt(0));
        this.add(exitButton);
    }


    /**
     * Loads button selection (6 airplanes) and save to config file
     */
    private void loadAirplaneSelection() throws IOException {
        int down = 0;
        int left = 0;
        int airplanesCount = 6;
        for (int i = 0; i < airplanesCount; i++) {
            int finalI = i;
            JRadioButton radioButton = new JRadioButton("") {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    try {
                        g.drawImage(GraphicUtils.resize(ImageIO.read(new File(ProjectPath.getAirplanesPath("option" + (finalI + 1) + ".png"))), 54, 54), 20, 8, null);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            radioButton.setActionCommand("option" + (i + 1));
            radioButton.setBounds((left * 85) + 80, (down * 80) + 190, 80, 70);
            radioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ConfigFile.saveConfig("selectedAirplane", airplanesSelection.getSelection().getActionCommand());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            if (i == 2) {
                down = 1;
                left = 0;
            } else {
                left++;
            }
            this.airplanesSelection.add(radioButton);
            add(radioButton);
            this.buttonList.add(radioButton);
        }
        loadSelection(ConfigFile.loadData("selectedAirplane"));
    }

    /**
     * Loads actual selections from file
     */
    private void loadSelection(String selectedAirplane) {
        for (AbstractButton btn : this.buttonList) {
            if (selectedAirplane.equals(btn.getActionCommand())) {
                btn.setSelected(true);
            }
        }
    }
}
