package com.emgineer.ConsoleDraw;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DrawText {
    private BufferedImage image;
    private Graphics graph;
    private Graphics2D graphics;

    private int imageWidth = 200;
    private int imageHeight = 20;
    private String actualFont = "Arial";
    private int textSize = 18;

    public DrawText(String textToDraw) throws IOException{
        createTextImage(textToDraw);
    }

    public DrawText(){

    }

    public void createTextImage(String textToDraw) throws IOException {
        this.image = new BufferedImage(this.imageWidth,this.imageHeight, BufferedImage.TYPE_INT_BGR);
        this.graph = image.getGraphics();
        this.graph.setFont(new Font(this.actualFont,Font.PLAIN,this.textSize));
        this.graphics = (Graphics2D) this.graph;
        this.graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        this.graphics.drawString(textToDraw,6,this.textSize);


        for (int i = 0; i < imageHeight; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < imageWidth; j++) {
                builder.append(image.getRGB(j,i) == -16777216 ? " " : "*");
                if(builder.toString().trim().isEmpty()) continue;
            }
            System.out.println(builder);
        }
    }
    public void setTextSize(int textSize){
        this.textSize = textSize;
    }
    public void setImageWidth(int imageWidth){
        this.imageWidth = imageWidth;
    }
    public void setImageHeight(int imageHeight){
        this.imageHeight = imageHeight;
    }
}
