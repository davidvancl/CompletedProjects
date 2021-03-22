package com.projectAirlines.SharedUtils;

import com.projectAirlines.Tools.GraphicUtils;
import com.projectAirlines.Tools.ProjectPath;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class SharedButtons {
    public static JButton settingsButton(JFrame frame, int width, int height, int x, int y) throws IOException {
        String background = ProjectPath.getIconsPath("gear.png");
        JButton button = new JButton();
        button.setIcon(new ImageIcon(GraphicUtils.resize(ImageIO.read(new File(background)), height, width)));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBounds(x, y, width, height);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setBackground(null);
        button.setOpaque(false);
        frame.add(button);
        return button;
    }
}
