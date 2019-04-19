package com.skibin.lab6;

import java.util.Random;

public class Matrix {

    private int[][] matrixArray;

    public Matrix(int rows, int columns) {
        matrixArray = new int[rows][columns];
    }

    public int[][] getMatrixArray() {
        return matrixArray;
    }

    public void setMatrixArray(int[][] matrixArray) {
        this.matrixArray = matrixArray;
    }

    public int getRowsNum() {
        return matrixArray.length;
    }

    public int getColumnsNum() {
        return matrixArray[0].length;
    }

    public int[][] fillMatrixRandomly() {
        Random rand = new Random();
        for(int i = 0; i < matrixArray.length; i++) {
            for(int j = 0; j < matrixArray[i].length; j++) {
                matrixArray[i][j] = rand.nextInt(100);
            }
        }
        return matrixArray;
    }

    public double getAverage() {
        double sum = 0;
        for(int i = 0; i < matrixArray.length; i++) {
            for(int j = 0; j < matrixArray[i].length; j++) {
                sum += matrixArray[i][j];
            }
        }
        return sum / (getRowsNum() * getColumnsNum());
    }
}
