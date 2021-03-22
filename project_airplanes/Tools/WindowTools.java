package com.projectAirlines.Tools;

import com.projectAirlines.GameInterface.GameLayout;
import com.projectAirlines.MenuInterface.GameMenu;

import javax.swing.*;

public abstract class WindowTools {
    private static int widthScreen = 0;
    private static int heightScreen = 0;

    public static void setupMenuWindow(GameMenu gameMenu){
        gameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameMenu.setVisible(true);
        gameMenu.setSize(widthScreen, heightScreen);
        gameMenu.setLocationRelativeTo(null);
        gameMenu.setResizable(false);
    }

    public static void setupGameWindow(GameLayout gameLayout){
        gameLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameLayout.setVisible(true);
        gameLayout.setSize(widthScreen,heightScreen);
        gameLayout.setLocationRelativeTo(null);
        gameLayout.setResizable(false);
    }

    public static void setWidthScreen(int width){
        widthScreen = width;
    }
    public static void setHeightScreen(int height){
        heightScreen = height;
    }

    public static void setWidthAndHeightScreen(int width,int height){
        setWidthScreen(width);
        setHeightScreen(height);
    }
}
