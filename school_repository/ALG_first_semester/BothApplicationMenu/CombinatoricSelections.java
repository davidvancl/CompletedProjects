package com.bothApplicationMenu;

import java.math.BigInteger;

/**
 * 1. Combinatoric Selections
 * 2. Project Euler problem 53
 * 3. 1 <= n <= 100, find greater number then one-million
 *
 * @author davvan
 * @version 1.0 13/01/20
 */
public class CombinatoricSelections {
    private static int numbers = 100;
    private static BigInteger find = new BigInteger("1000000");

    /**
     * Start point of application
     * Method count possible factorial from interval (1 <= n <= 100)
     * compare if is greater then one-million
     * Print result to console
     */
    public CombinatoricSelections() {
        int found = 0;
        for (int i = 0; i <= numbers; i++) {
            for (int j = 0; j <= i; j++) {
                int statement = combinationNumber(i, j).compareTo(find);
                if (statement == 1) {
                    found++;
                }
            }
        }
        System.out.println("Numbers greater then one-million: " + found);
    }

    /**
     * Method count factorial of number n
     *
     * @param n Integer, input number
     * @return BigInteger factorial
     */
    private BigInteger factorial(int n) {
        BigInteger number = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            number = number.multiply(new BigInteger(String.valueOf(i)));
        }
        return number;
    }

    /**
     * Method count combination number by params
     *
     * @param n Integer,upper parameter of combination number
     * @param r Integer,lower parameter of combination number
     * @return BigInteger counted by { formula = (n)! / (r)! * (n - r)! }
     */
    private BigInteger combinationNumber(int n, int r) {
        return factorial(n).divide(factorial(r).multiply(factorial(n - r)));
    }
}