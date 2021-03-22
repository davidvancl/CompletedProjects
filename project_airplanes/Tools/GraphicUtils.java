package com.projectAirlines.Tools;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GraphicUtils {
    /**
     * Method to scale image
     *
     * @param img image to scale
     * @param height width of destination image
     * @param width of destination image
     * @return scaled image
     */
    public static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
}