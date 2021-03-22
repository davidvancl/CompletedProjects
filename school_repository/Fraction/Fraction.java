package com.Fraction;

import java.util.Scanner;

public class Fraction {
    private static Scanner scanner = new Scanner(System.in);
    private int numerator;
    private int denominator;

    public Fraction(int numerator,int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(boolean string){
        if(string){
            String inp = scanner.next();
            String[] tmp = inp.split("/");
            this.numerator = Integer.parseInt(tmp[0]);
            this.denominator = Integer.parseInt(tmp[1]);
        } else {
            this.numerator = scanner.nextInt();
            this.denominator = scanner.nextInt();
        }
    }

    public int getNumerator(){
        return this.numerator;
    }

    public void setNumerator(int numerator){
        this.numerator = numerator;
    }

    public int getDenominator(){
        return this.denominator;
    }

    public void setDenominator(int denominator){
        this.denominator = denominator;
    }

    @Override
    public String toString(){
        return this.numerator + "/" + this.denominator;
    }

    private int getHighestDivisor(){
        int u = this.numerator;
        int v = this.denominator;

        while (v != 0){
            int r = u % v;
            u = v;
            v = r;
        }
        return u;
    }

    public void simplify(){
        int div = getHighestDivisor();
        this.numerator = this.numerator / div;
        this.denominator = this.denominator / div;
    }
}
