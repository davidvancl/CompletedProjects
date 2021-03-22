package com.Shapes;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<GeomObj> objs = new ArrayList<>();
        objs.add(new Ellipse(2,8));
        objs.add(new Rectangle(5,3));
        objs.add(new Square(4));
        objs.add(new Ring(7));

        System.out.println("Content is: " + countContentOfAll(objs));
    }

    private static double countContentOfAll(ArrayList<GeomObj> objs){
        double sum = 0;
        for (GeomObj obj : objs){
            sum += obj.countContent();
        }
        return sum;
    }
}
