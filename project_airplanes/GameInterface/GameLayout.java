package com.projectAirlines.GameInterface;

import com.projectAirlines.Main;
import com.projectAirlines.SharedUtils.SettingsLabel;
import com.projectAirlines.SharedUtils.SharedButtons;
import com.projectAirlines.Tools.GraphicUtils;
import com.projectAirlines.Tools.ProjectPath;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class GameLayout extends JFrame {
    private SettingsLabel gameSettings;
    private int widthScreen;
    private int heightScreen;

    //TODO: add data list
    public GameLayout(int widthScreen, int heightScreen) throws IOException {
        this.widthScreen = widthScreen;
        this.heightScreen = heightScreen;

        //setting up JFrame
        setLayout(null);
        String layout = ProjectPath.getGraphicPath("gameBackground.png");
        setContentPane(new JLabel(new ImageIcon(GraphicUtils.resize(ImageIO.read(new File(layout)),this.heightScreen,this.widthScreen))));

        //load components
        gameSettings = new SettingsLabel(this.widthScreen,this.heightScreen,this);
        add(gameSettings);
        menuButton();
        loadSettingsButton();
    }

    private void menuButton(){
        JButton button = new JButton("Menu");
        button.setBounds(this.widthScreen - 115,0,100,30);
        button.addActionListener(e -> {
            try {
                Main.openMenu();
                dispose();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        add(button);
    }

    private void loadSettingsButton() throws IOException {
       JButton button = SharedButtons.settingsButton(this,30,30,this.widthScreen - 150,0);
       button.addActionListener(e -> {
           if(gameSettings.isVisible()){
               gameSettings.setVisible(false);
           } else {
               gameSettings.setVisible(true);
           }
       });
    }
}
