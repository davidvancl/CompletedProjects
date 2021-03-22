package com.EKG.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class EkgLineLabel extends JLabel implements ActionListener {
    private final LinkedList<Line> lines = new LinkedList<Line>();
    private Timer time = new Timer(6, (ActionListener) this);

    private int actualLine = 0;
    private int linePositionX = 0;
    private int linePositionY = 0;
    private int lastLinePositionX = 0;
    private int lastLinePositionY = 0;

    public EkgLineLabel(int screenWidth, int screenHeight) {
        setBounds(0, 0, screenWidth, screenHeight);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Line line : lines) {
            g.setColor(line.color);
            g.drawLine(line.x1, line.y1, line.x2, line.y2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        boolean add = true;
        for (Line line : lines) {
            if (!line.isCompleted()) {
                if (line.needed_x2 != line.x2)
                    if (line.needed_x2 > line.x2) {
                        line.x2++;
                    } else {
                        line.x2--;
                    }

                for (int i = 0; i < 10; i++) {
                    if (line.needed_y2 != line.y2) {
                        if (line.needed_y2 > line.y2) {
                            line.y2++;
                        } else {
                            line.y2--;
                        }
                    }
                }
                add = false;
            }
        }
        if (add) {
            switch (this.actualLine) {
                case 0:
                    this.setLinePositions(150, 250, 200, 250);
                    break;
                case 1:
                    this.setLinePositions(this.lastLinePositionX, this.lastLinePositionY, 210, 230);
                    break;
                case 2:
                    this.setLinePositions(this.lastLinePositionX, this.lastLinePositionY, 220, 250);
                    break;
                case 3:
                    this.setLinePositions(this.lastLinePositionX, this.lastLinePositionY, 240, 250);
                    break;
                case 4:
                    this.setLinePositions(this.lastLinePositionX, this.lastLinePositionY, 250, 280);
                    break;
                case 5:
                    this.setLinePositions(this.lastLinePositionX, this.lastLinePositionY, 270, 130);
                    break;
                case 6:
                    this.setLinePositions(this.lastLinePositionX, this.lastLinePositionY, 290, 300);
                    break;
                case 7:
                    this.setLinePositions(this.lastLinePositionX, this.lastLinePositionY, 300, 250);
                    break;
                case 8:
                    this.setLinePositions(this.lastLinePositionX, this.lastLinePositionY, 330, 250);
                    break;
                case 9:
                    this.setLinePositions(this.lastLinePositionX, this.lastLinePositionY, 350, 210);
                    break;
                case 10:
                    this.setLinePositions(this.lastLinePositionX, this.lastLinePositionY, 370, 250);
                    break;
                case 11:
                    this.setLinePositions(this.lastLinePositionX, this.lastLinePositionY, 390, 250);
                    break;
                case 12:
                    this.setLinePositions(this.lastLinePositionX, this.lastLinePositionY, 410, 250);
                    break;
                case 13:
                    this.setLinePositions(this.lastLinePositionX, this.lastLinePositionY, 420, 230);
                    break;
                case 14:
                    this.setLinePositions(this.lastLinePositionX, this.lastLinePositionY, 430, 250);
                    break;
                case 15:
                    this.setLinePositions(this.lastLinePositionX, this.lastLinePositionY, 490, 250);
                    break;
                case 16:
                    clearLines();
                    this.actualLine = -1;
                    break;
            }
            if (this.actualLine != -1) {
                addLine(this.linePositionX, this.linePositionY, this.lastLinePositionX, this.lastLinePositionY);
            }
            this.actualLine++;
            add = false;
        } else {
            repaint();
        }
    }

    public void startTimer() {
        time.start();
    }

    public void stopTimer() {
        time.stop();
    }

    private void addLine(int x1, int x2, int x3, int x4) {
        lines.add(new Line(x1, x2, x3, x4, Color.red));
    }

    private void clearLines() {
        lines.clear();
        repaint();
    }

    private void setLinePositions(int linePositionX, int linePositionY, int lastLinePositionX, int lastLinePositionY) {
        this.linePositionX = linePositionX;
        this.linePositionY = linePositionY;
        this.lastLinePositionX = lastLinePositionX;
        this.lastLinePositionY = lastLinePositionY;
    }
}