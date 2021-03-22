package com.EKG.GUI;

import java.awt.*;

public class Line {
    public int x1 = 0;
    public int y1 = 0;
    public int x2 = 0;
    public int needed_x2 = 0;
    public int y2 = 0;
    public int needed_y2 = 0;
    public Color color = null;
    public int scalingY = 0;

    public Line(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = this.x1;
        this.y2 = this.y1;
        this.needed_x2 = x2;
        this.needed_y2 = y2;
        this.color = color;
        this.scalingY = linearScalingForY();
    }

    private int linearScalingForY() {
        int scaling = getDifferenceY() / getDifferenceX();
        return (scaling == 0) ? 1 : scaling;
    }

    private int getDifferenceX() {
        return this.needed_x2 - this.x2;
    }

    private int getDifferenceY() {
        int diff = 0;
        if (this.needed_y2 > this.y2) {
            diff = this.needed_y2 - this.y2;
        } else {
            diff = this.y2 - this.needed_y2;
        }
        if (diff < 0) {
            diff *= -1;
        }
        return diff;
    }

    public boolean isCompleted() {
        return this.needed_x2 == this.x2 && this.needed_y2 == this.y2;
    }
}