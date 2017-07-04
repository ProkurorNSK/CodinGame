package PuzzleCommunity.GameOfLife;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();
        int height = in.nextInt();
        byte[][] field = new byte[height][width];

        for (int i = 0; i < height; i++) {
            String line = in.next();
            for (int j = 0; j < width; j++) {
                field[i][j] = (byte) line.charAt(j);
            }
        }

        print(field);
    }

    private static void print(byte[][] field) {
        for (byte[] line : field) {
            for (byte cell : line) {
                System.out.print((char) cell);
            }
            System.out.println();
        }
    }
}