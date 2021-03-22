package com.MatrixLibrary;

public abstract class ArraysLibrary {

    public static void drawArray(int[][] array){
        for (int[] ints : array) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }
}
