package com.Shapes;

public class Rectangle extends GeomObj{
    private double a;
    private double b;

    public Rectangle(double a,double b){
        this.a = a;
        this.b = b;
    }

    protected double countContent(){
        return this.a * this.b;
    }

    protected double countCircuit(){
        return 2 * this.a + 2* this.b;
    }
}
