package com.Shapes;

public class Square extends GeomObj {
    private double a;

    public Square(double a){
        this.a = a;
    }

    protected double countContent(){
        return this.a * this.a;
    }

    protected double countCircuit(){
        return 4 * this.a;
    }
}
