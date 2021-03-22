package com.MatrixLibrary;

import java.util.Scanner;

public abstract class MatrixLibrary {
    private static Scanner scan = new Scanner(System.in);

    /**
     * Function to load data to Matrix
     *
     * @return loaded matrix from input
     */
    public static int[][] loadMatrix() {
        System.out.print("X: ");
        int x=scan.nextInt();
        System.out.print("Y: ");
        int y=scan.nextInt();
        System.out.println("Matrix: ");
        int[][] loadedMatrix = new int[x][y];
        for (int i = 0; i < loadedMatrix.length; i++) {
            for (int j = 0; j < loadedMatrix[i].length; j++) {
                loadedMatrix[i][j] = scan.nextInt();
            }
        }
        return loadedMatrix;
    }

    /**
     * Function to check validation of horizontal symmetry
     *
     * @param matrix input matrix
     * @return true or false if is horizontal symmetry
     */
    public static boolean symmetryHorizontal(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix[(matrix.length - 1) - i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Function to check validation of vertical symmetry
     *
     * @param matrix input matrix
     * @return true or false if is vertical symmetry
     */
    public static boolean symmetryVertical(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                if (matrix[i][j] != matrix[i][matrix[i].length - 1 - j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Function to check validation decreasing diagonal symmetry
     *
     * @param matrix input matrix
     * @return true or false if is decreasing diagonal symmetry
     */
    public static boolean symmetryByDecreasingDiagonal(int[][] matrix) {
        if (matrix.length != matrix[0].length) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Function to check validation increasing diagonal symmetry
     *
     * @param matrix input matrix
     * @return true or false if is increasing diagonal symmetry
     */
    public static boolean symmetryByIncreasingDiagonal(int[][] matrix) {
        if (matrix.length != matrix[0].length) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - i; j++) {
                if (matrix[i][j] != matrix[matrix.length - 1 - j][matrix[i].length - 1 - i]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Function to check if decreasing diagonal has constant value
     *
     * @param matrix input matrix
     * @return true or false if is decreasing diagonal has constant value
     */
    public static boolean hasConstantValueDecreasingDiagonal(int[][] matrix) {
        if (matrix.length != matrix[0].length) {
            return false;
        }
        int valueFound = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - i; j++) {
                if (i == 0 && j == 0) {
                    valueFound = matrix[i][j];
                } else {
                    if (i == j && matrix[i][j] != valueFound) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Function to check if increasing diagonal has constant value
     *
     * @param matrix input matrix
     * @return true or false if is increasing diagonal has constant value
     */
    public static boolean hasConstantValueIncreasingDiagonal(int[][] matrix) {
        if (matrix.length != matrix[0].length) {
            return false;
        }
        int valueFound = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length - i; j++) {
                if (i == 0 && j == 0) {
                    valueFound = matrix[matrix.length - 1 - i][j];
                } else {
                    if (i == j && matrix[matrix.length - 1 - i][j] != valueFound) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Function of multiplication two matrix
     *
     * @param matrix1 matrix A
     * @param matrix2 matrix B
     * @return true or false if is vertical symmetry
     */
    public static int[][] multiplicationTwoMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length == matrix2.length) {
            int[][] resultMatrix = new int[matrix1.length][matrix2[0].length];
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix[i].length; j++) {
                    for (int k = 0; k < matrix1[0].length; k++) {
                        resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                    }
                }
            }
            return resultMatrix;
        } else {
            System.out.println("Is not valid.");
            return null;
        }
    }

    /**
     * Function for checking if matrix has numbers from 1 to N*N
     *
     * @param matrix input matrix
     * @return true or false if matrix contains all number from 1 to N*N
     */
    public static boolean hasMatrixAllValue(int[][] matrix){
        int[] oneDimensionalArray = new int[matrix.length * matrix[0].length];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                oneDimensionalArray[index] = matrix[i][j];
                index++;
            }
        }

        for (int i = 0; i < oneDimensionalArray.length - 1; i++) {
            for (int j = 0; j < oneDimensionalArray.length - i - 1; j++) {
                if(oneDimensionalArray[j] > oneDimensionalArray[j+1]){
                    int tmp = oneDimensionalArray[j];
                    oneDimensionalArray[j] = oneDimensionalArray[j+1];
                    oneDimensionalArray[j+1] = tmp;
                }
            }
        }

        for (int i = 0; i < oneDimensionalArray.length; i++) {
            if(oneDimensionalArray[i] != (i + 1)){
                return false;
            }
        }
        return true;
    }
}