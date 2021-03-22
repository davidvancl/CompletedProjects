package com.MagicanSquare;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 1. Program for checking matrix lines and columns and both of diagonals.
 * 2. Print result if matrix is magican square or not.
 *
 * @author davvan
 * @version 1.0 03/12/19
 */
public class Main {
    private static Scanner scan = new Scanner(System.in);

    /**
     * Method loading input and find possible way to continue to check validation
     *
     * @param args system information
     * @throws Exception If an input or output exception occurred
     */
    public static void main(String[] args) {
        try {
            int matrixN = 0;
            while ((matrixN = loadInputCustom()) > 0) {
                int[][] matrix = new int[matrixN][matrixN];
                int maxNumber = (matrixN * matrixN);

                boolean permissionsToCheckValidate = true;
                System.out.println("Prvni matice");
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        matrix[i][j] = scan.nextInt();
                        if (matrix[i][j] <= 0) {
                            permissionsToCheckValidate = false;
                        }
                    }
                }

                boolean isMagicMatrix = false;
                if (permissionsToCheckValidate) {
                    isMagicMatrix = getMatrixValidation(matrix, maxNumber);
                }

                System.out.println((isMagicMatrix) ? "Matice tvori magicky ctverec." : "Nejedna se o magicky ctverec.");
            }
        } catch (Exception e) {
            if (e instanceof InputMismatchException) {
                System.out.println("Wrong input!");
            } else {
                System.out.println("Exeption: " + e);
            }
        }
    }

    /**
     * Custom function input function. + message
     *
     * @return number from input
     */
    private static int loadInputCustom() {
        System.out.println("Rozmer matic");
        return scan.nextInt();
    }

    /**
     * Function for checking validation of matrix.
     * Compare sum of lines, columns and both of diagonales.
     * Function {@link #sortOneDimensionalArrayAndCompare(int[])} check if all numbers are contained.
     *
     * @param matrix    matrix array from input
     * @param maxNumber is max number which can be contained in matrix
     * @return true if matrix is valid, otherwise false
     */
    private static boolean getMatrixValidation(int[][] matrix, int maxNumber) {
        int[] oneDimensionArray = new int[maxNumber];
        boolean resultStatement = true;
        int foundRowCount = 0;
        int rowCount = 0;
        int foundColumnCount = 0;
        int columnCount = 0;
        int diagonaleDecreasing = 0;
        int diagonaleIncreasing = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                oneDimensionArray[(matrix.length * i) + j] = matrix[i][j];
                if (j == 0) {
                    rowCount = matrix[i][j];
                    columnCount = matrix[j][i];
                } else if (j == matrix[i].length - 1) {
                    rowCount += matrix[i][j];
                    columnCount += matrix[j][i];
                    if (i == 0) {
                        foundRowCount = rowCount;
                        foundColumnCount = columnCount;
                    } else {
                        if (foundRowCount != rowCount) {
                            resultStatement = false;
                        }
                        if (foundColumnCount != columnCount) {
                            resultStatement = false;
                        }
                    }
                } else {
                    rowCount += matrix[i][j];
                    columnCount += matrix[j][i];
                }

                if (i == j) {
                    if (i == 0) {
                        diagonaleDecreasing = matrix[i][j];
                        diagonaleIncreasing = matrix[i][(matrix[i].length - 1) - j];
                    } else if (j == matrix[i].length - 1) {
                        diagonaleDecreasing += matrix[i][j];
                        diagonaleIncreasing += matrix[i][(matrix[i].length - 1) - j];
                    } else {
                        diagonaleDecreasing += matrix[i][j];
                        diagonaleIncreasing += matrix[i][(matrix[i].length - 1) - j];
                    }
                }
            }
        }
        if (diagonaleDecreasing != diagonaleIncreasing || diagonaleIncreasing != foundColumnCount || foundColumnCount != foundRowCount) {
            resultStatement = false;
        } else {
            resultStatement = (sortOneDimensionalArrayAndCompare(oneDimensionArray)) && resultStatement;
        }
        return resultStatement;
    }

    /**
     * @param array matrix array from input
     * @return true if array contain numbers from 1 to n, otherwise false
     */
    private static boolean sortOneDimensionalArrayAndCompare(int[] array) {
        boolean statement = true;
        for (int i = 0; i < (array.length - 1); i++) {
            for (int j = 0; j < (array.length - i - 1); j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            if ((i + 1) != array[i]) {
                statement = false;
                break;
            }
        }
        return statement;
    }
}