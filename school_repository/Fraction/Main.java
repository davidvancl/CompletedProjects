package com.Fraction;

public class Main {

    public static void main(String[] args) {
//        Fraction fraction1 = new Fraction(100,50);
//        fraction1.simplify();
//        System.out.println(fraction1.toString());
//
//        Fraction fraction2 = new Fraction(true);
//        fraction2.simplify();
//        System.out.println(fraction2.toString());

        Fraction fraction1 = new Fraction(4,3);
        Fraction fraction2 = new Fraction(5,10);

        Fraction addition = FractionsCalculator.addition(fraction1,fraction2);
        addition.simplify();
        System.out.println(addition.toString());

        Fraction subtraction = FractionsCalculator.subtraction(fraction1,fraction2);
        subtraction.simplify();
        System.out.println(subtraction.toString());

        Fraction multiplication = FractionsCalculator.multiplication(fraction1,fraction2);
        multiplication.simplify();
        System.out.println(multiplication.toString());

        Fraction division = FractionsCalculator.division(fraction1,fraction2);
        division.simplify();
        System.out.println(division.toString());
    }
}
