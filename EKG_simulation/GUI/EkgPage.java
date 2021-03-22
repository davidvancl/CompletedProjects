package com.EKG.GUI;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class EkgPage extends JFrame implements MouseListener, MouseMotionListener {
    private JLabel mainBackground = null;
    private JLabel status = null;
    private JButton poweroff = null;
    private EkgLineLabel label = null;
    private int mousePositionX = 0;
    private int mousePositionY = 0;
    private boolean isStarted = false;
    private String folder = "Images/";
    private int defaultSizeElement = 20;

    public EkgPage(int screenWidth, int screenHeight) throws IOException {
        this.mainBackground = new JLabel();
        Utils.setupWindow(this, this.mainBackground, screenWidth, screenHeight);

        addMouseListener(this);
        addMouseMotionListener(this);

        //LABEL EKG LINE
        this.label = new EkgLineLabel(screenWidth, screenHeight);
        this.mainBackground.add(this.label);

        //STATUS ICON
        this.status = Utils.loadBufferedImageLabel(this.folder + "red.png", this.defaultSizeElement, this.defaultSizeElement);
        this.status.setBounds(588, 120, 20, 20);
        this.mainBackground.add(this.status);

        //EXIT BUTTON
        this.poweroff = Utils.createButton(this.folder + "poweroff.png", 588, 144, this.defaultSizeElement, this.defaultSizeElement, true);
        this.poweroff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Runtime.getRuntime().exit(0);
            }
        });
        this.mainBackground.add(this.poweroff);

        //GREEN BUTTON: START/STOP
        JButton createdButton = Utils.createButton(this.folder + "button.png", 574, 277, 100, 110, true);
        createdButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                status.setIcon(null);
                try {
                    if (isStarted) {
                        status.setIcon(Utils.getImageIcon(folder + "red.png", defaultSizeElement, defaultSizeElement));
                        label.stopTimer();
                        isStarted = false;
                    } else {
                        status.setIcon(Utils.getImageIcon(folder + "button.png", defaultSizeElement, defaultSizeElement));
                        label.startTimer();
                        isStarted = true;
                    }
                } catch (Exception ignore) {
                }
            }
        });
        this.mainBackground.add(createdButton);

        //BACKGROUND IMAGE
        try {
            this.mainBackground.add(Utils.loadBufferedImageLabel(folder + "background.png", screenWidth, screenHeight));
        } catch (Exception ignore) {
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        this.mousePositionX = mouseEvent.getX();
        this.mousePositionY = mouseEvent.getY();
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        int x = mouseEvent.getXOnScreen();
        int y = mouseEvent.getYOnScreen();
        this.setLocation(x - this.mousePositionX, y - this.mousePositionY);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    }
}
