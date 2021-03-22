package com.Shapes;

public class Ring extends GeomObj {
    private double r;

    public Ring(double r){
        this.r = r;
    }

    protected double countContent(){
        return Math.PI * Math.pow(this.r,2);
    }

    protected double countCircuit(){
        return 2 * Math.PI * this.r;
    }
}
