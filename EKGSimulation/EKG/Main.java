package com.EKG;

import com.EKG.GUI.EkgPage;
import com.EKG.GUI.Utils;

import java.io.IOException;

public class Main {
    private static int screenWidth = 700;
    private static int screenHeight = 500;

    public static void main(String[] args) throws IOException {
        EkgPage page = new EkgPage(screenWidth, screenHeight);
        Utils.setupMainJFrame(page, screenWidth, screenWidth);
    }
}
