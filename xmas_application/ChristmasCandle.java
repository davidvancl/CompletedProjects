package com.XmasApplication;

public class ChristmasCandle {
    private int height = 0;
    private int width = 0;
    private boolean stripes = false;
    private boolean isHollow = false;

    public ChristmasCandle(int height,int width,boolean stripes,boolean isHollow){
        this.height = height;
        this.width = width;
        this.stripes = stripes;
        this.isHollow = isHollow;
        drawCandleByParameters();
    }

    public ChristmasCandle(int height,int width){
        this.height = height;
        this.width = width;
        drawCandleByParameters();
    }
    public ChristmasCandle(){}

    public void drawCandleByParameters(){
        for (int i = 0; i < this.height / 5; i++) {
            for (int j = 0; j < this.width; j++) {
                if(j > (this.width /2 - 2) && j < (this.width / 2 + 1)){
                    System.out.print("#");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        int stripesIndex = 4;
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if (this.stripes){
                    if(stripesIndex == (i + 2)){
                        if(j == this.width - 1){
                            stripesIndex += 3;
                        }
                        if (j < 1 || j > (this.width - 2)) {
                            System.out.print("*");
                        } else {
                            if(i < 1 || i > (this.height - 2))
                            {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                    } else {
                        if (j < 1 || j > (this.width - 2)) {
                            System.out.print("*");
                        } else {
                            if(i < 1 || i > (this.height - 2))
                            {
                                System.out.print("*");
                            } else {
                                System.out.print("#");
                            }
                        }
                    }
                } else if (this.isHollow){
                    if(i < 1 || i > (this.height - 2))
                    {
                        System.out.print("#");
                    } else {
                        if (j < 1 || j > (this.width - 2)) {
                            System.out.print("#");
                        } else {
                            System.out.print(" ");
                        }
                    }
                } else {
                    System.out.print("$");
                }
            }
            System.out.println();
        }
    }

    public void setHeight(int height){
        this.height = height;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setStripes(boolean stripes){
        this.stripes = stripes;
    }

    public void setHollow(boolean isHollow){
        this.isHollow = isHollow;
    }
}
