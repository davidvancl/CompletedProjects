package com.Fraction;

public abstract class FractionsCalculator {
    public static Fraction addition(Fraction fraction1, Fraction fraction2) {
        FractionsCalculator.modifyToSameDenominator(fraction1,fraction2);
        int num = fraction1.getNumerator() + fraction2.getNumerator();
        return new Fraction(num, fraction1.getDenominator());
    }

    public static Fraction subtraction(Fraction fraction1, Fraction fraction2) {
       FractionsCalculator.modifyToSameDenominator(fraction1,fraction2);
       int num = fraction1.getNumerator() - fraction2.getNumerator();
       return new Fraction(num,fraction1.getDenominator());
    }

    public static Fraction multiplication(Fraction fraction1,Fraction fraction2){
        return new Fraction(fraction1.getNumerator() * fraction2.getNumerator(),fraction1.getDenominator() * fraction2.getDenominator());
    }

    public static Fraction division(Fraction fraction1,Fraction fraction2){
        int tmp = fraction2.getNumerator();
        fraction2.setNumerator(fraction2.getDenominator());
        fraction2.setDenominator(tmp);
        return new Fraction(fraction1.getNumerator() * fraction2.getNumerator(),fraction1.getDenominator() * fraction2.getDenominator());
    }

    private static void modifyToSameDenominator(Fraction fraction1, Fraction fraction2) {
        if (fraction1.getDenominator() != fraction2.getDenominator()) {
            int tmp = fraction1.getDenominator() * fraction2.getDenominator();
            fraction1.setNumerator(fraction1.getNumerator() * fraction2.getDenominator());
            fraction2.setNumerator(fraction2.getNumerator() * fraction1.getDenominator());
            fraction1.setDenominator(tmp);
            fraction2.setDenominator(tmp);
        }
    }
}
