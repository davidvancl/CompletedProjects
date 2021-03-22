package com.projectAirlines.MenuInterface;

import com.projectAirlines.SharedUtils.MenuLabel;
import com.projectAirlines.SharedUtils.SettingsLabel;
import com.projectAirlines.SharedUtils.SharedButtons;
import com.projectAirlines.Tools.GraphicUtils;
import com.projectAirlines.Tools.ProjectPath;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * <h1>Game Menu</h1>
 * Game menu startup after run application
 * Used to setup application and run the game
 * <p>
 * GraphicUtils used to split code, graphic parts of codes are in this ToolBox
 *
 * @see com.projectAirlines.Tools.GraphicUtils
 */
public class GameMenu extends JFrame {

    /**
     * This is the main method which clear layout and load all components
     *
     * @param widthScreen  Integer, X size of screen
     * @param heightScreen Integer, Y size of screen
     * @throws IOException load background image need IOException
     * @see GraphicUtils loadMenuBar()
     */
    public GameMenu(int widthScreen, int heightScreen) throws IOException {
        super("Game Menu");

        //setup JFrame
        setLayout(null);
        String backgroundImage = ProjectPath.getGraphicPath("background.png");
        setContentPane(new JLabel(new ImageIcon(GraphicUtils.resize(ImageIO.read(new File(backgroundImage)), heightScreen, widthScreen))));

        //loadComponent
        MenuLabel menuLabel = new MenuLabel(widthScreen, heightScreen, this);
        SettingsLabel gameSettings = new SettingsLabel(widthScreen, heightScreen,this);
        loadSettingButton(menuLabel,gameSettings);
    }

    private void loadSettingButton(MenuLabel menuLabel, SettingsLabel gameSettings) throws IOException {
        JButton button = SharedButtons.settingsButton(this,30,30,750,10);
        button.addActionListener(new ActionListener() {
            private boolean shown = false;
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(shown){
                    gameSettings.setGameSettingsVisible(false);
                    menuLabel.setBarVisibility(true);
                    shown = false;
                } else {
                    gameSettings.setGameSettingsVisible(true);
                    menuLabel.setBarVisibility(false);
                    shown = true;
                }
            }
        });
    }
}
