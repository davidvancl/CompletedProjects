package com.Shapes;

public class Ellipse extends GeomObj {
    private double a;
    private double b;

    public Ellipse(double a,double b){
        this.a = a;
        this.b = b;
    }

    protected double countContent(){
        return Math.PI * this.a * this.b;
    }

    protected double countCircuit(){
        return Math.PI * Math.sqrt(2 * (Math.pow(this.a,2) * Math.pow(this.b,2)));
    }
}
