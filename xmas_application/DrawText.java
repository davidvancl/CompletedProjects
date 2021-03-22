package com.XmasApplication;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DrawText {
    private BufferedImage image = null;
    private Graphics graph = null;
    private Graphics2D graphics = null;

    private int imageWidth = 220;
    private int imageHeight = 20;
    private String actualFont = "Arial";
    private int textSize = 18;
    private boolean animate = false;

    public DrawText() {
    }

    public DrawText(int imageWidth, int imageHeight, int textSize, boolean animate) {
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.textSize = textSize;
        this.animate = animate;
    }

    public void createTextImage(String textToDraw) throws InterruptedException {
        this.image = new BufferedImage(this.imageWidth, this.imageHeight, BufferedImage.TYPE_INT_BGR);
        this.graph = image.getGraphics();
        this.graph.setFont(new Font(this.actualFont, Font.PLAIN, this.textSize));
        this.graphics = (Graphics2D) this.graph;
        this.graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        this.graphics.drawString(textToDraw, 6, this.textSize);

        for (int i = 0; i < imageHeight; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < imageWidth; j++) {
                if (this.animate) {
                    System.out.print(image.getRGB(j, i) == -16777216 ? " " : "*");
                    TimeUnit.MILLISECONDS.sleep(1);
                } else {
                    builder.append(image.getRGB(j, i) == -16777216 ? " " : "*");
                    if (builder.toString().trim().isEmpty()) continue;
                }
            }
            System.out.println(this.animate ? "" : builder.toString().replaceAll("(?m)^[ \t]*\r?\n", ""));
        }
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public void setAnimate(boolean statement) {
        this.animate = statement;
    }

    public void setActualFont(String actualFont) {
        this.actualFont = actualFont;
    }
}
