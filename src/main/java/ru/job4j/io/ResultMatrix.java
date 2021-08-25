package ru.job4j.io;

import java.io.FileOutputStream;
import java.util.Arrays;

public class ResultMatrix {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("resultMatrix.txt")) {
            out.write("Matrix Table!".getBytes());
            out.write(System.lineSeparator().getBytes());
            int[][] matrix = new Matrix().multiple(9);
            for (int[] ints : matrix) {
                String strInts = Arrays.toString(ints);
                out.write((strInts + System.lineSeparator()).getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

