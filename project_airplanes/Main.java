package com.projectAirlines;

import com.projectAirlines.GameInterface.GameLayout;
import com.projectAirlines.MenuInterface.GameMenu;
import com.projectAirlines.Tools.MusicThread;
import com.projectAirlines.Tools.WindowTools;
import java.io.IOException;

/**
 * <h1>Game Menu</h1>
 * Game menu startup after run application
 * Used to setup application and run the menu
 * <p>
 *
 * @author  David Vancl
 * @version 1.0
 * @since   2020-01-12
 */
public class Main {
    private static int mainWidth = 800;
    private static int mainHeight = 600;
    private static MusicThread musicThread;

    public static void main(String[] args) throws IOException {
        //new music thread
        musicThread = new MusicThread();
        new Thread(musicThread).start();
        //setup window
        WindowTools.setWidthAndHeightScreen(mainWidth,mainHeight);
//        openMenu();
        joinToTheGame();
    }

    public static void joinToTheGame() throws IOException {
        WindowTools.setupGameWindow(new GameLayout(mainWidth,mainHeight));
    }

    public static void openMenu() throws IOException {
        WindowTools.setupMenuWindow(new GameMenu(mainWidth,mainHeight));
    }

    public static MusicThread getMusicThread(){
        return musicThread;
    }
}
