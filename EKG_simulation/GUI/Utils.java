package com.EKG.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Utils {
    public static BufferedImage resizeBufferedImage(BufferedImage image, int newWidth, int newHeight) {
        Image temp = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        BufferedImage newBufferedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = newBufferedImage.createGraphics();
        g2d.drawImage(temp, 0, 0, null);
        g2d.dispose();
        return newBufferedImage;
    }

    public static JLabel loadBufferedImageLabel(String url, int screenWidth, int screenHeight) throws IOException {
        JLabel loadedImageLabel = new JLabel(Utils.getImageIcon(url, screenWidth, screenHeight));
        loadedImageLabel.setBounds(0, 0, screenWidth, screenHeight);
        return loadedImageLabel;
    }

    public static ImageIcon getImageIcon(String url, int screenWidth, int screenHeight) throws IOException {
        BufferedImage loadedImage = ImageIO.read(new File(url));
        return new ImageIcon(Utils.resizeBufferedImage(loadedImage, screenWidth, screenHeight));
    }

    public static JButton createButton(String url, int posX, int posY, int width, int height, boolean specialProperties) throws IOException {
        JButton newButton = new JButton();
        newButton.setBounds(posX, posY, width, height);
        newButton.setIcon(Utils.getImageIcon(url, width, height));
        if (specialProperties) Utils.setSpecialButtonProperties(newButton);
        return newButton;
    }

    private static void setSpecialButtonProperties(JButton newButton) {
        newButton.setBackground(null);
        newButton.setBorder(null);
        newButton.setOpaque(false);
        newButton.setContentAreaFilled(false);
        newButton.setBorderPainted(false);
    }

    public static void setupWindow(JFrame frame, JLabel mainLabel, int screenWidth, int screenHeight) {
        mainLabel.setBounds(0, 0, screenWidth, screenHeight);
        mainLabel.setLayout(null);
        frame.setUndecorated(true);
        frame.setBackground(new Color(0, 0, 0, 0));
        frame.add(mainLabel);
    }

    public static void setupMainJFrame(EkgPage page, int screenWidth, int screenHeight) {
        page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        page.setVisible(true);
        page.setSize(screenWidth, screenHeight);
        page.setLocationRelativeTo(null);
        page.setResizable(false);
    }
}