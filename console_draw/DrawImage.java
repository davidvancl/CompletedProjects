package com.emgineer.ConsoleDraw;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawImage {
    private BufferedImage image;
    public DrawImage(String path) throws IOException{
        createImage(path);
    }

    public DrawImage(){

    }

    public void createImage(String path) throws IOException {
        File originalImage = new File(path);

        this.image = convertImage(originalImage);

        for (int i = 0; i < image.getHeight() - 1; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < image.getWidth() -1 ; j++) {
                builder.append(((image.getRGB(j,i) & 0x00FFFFFF) == 0 ) ? "*" : " ");
            }
            System.out.println(builder);
        }
    }
    private int delimeterToResize = 7;
    public BufferedImage convertImage(File input){
        BufferedImage result = null;

        try {
            BufferedImage image = ImageIO.read(input);
            result = new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_BYTE_BINARY);
            Graphics2D graphic = result.createGraphics();
            graphic.drawImage(image, 0, 0, Color.WHITE, null);
            graphic.dispose();

            BufferedImage resized = new BufferedImage(result.getWidth() / (this.delimeterToResize / 2),
                    result.getHeight() / this.delimeterToResize, result.getType());
            Graphics2D g = resized.createGraphics();
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(result, 0, 0, result.getWidth() / (this.delimeterToResize / 2),
                    result.getHeight() / this.delimeterToResize, 0, 0, result.getWidth(),
                    result.getHeight(), null);
            g.dispose();

            return resized;
        }  catch (IOException e) { }
        return result;
    }
}
