package PuzzleCommunity.GameOfLife;

import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();
        int height = in.nextInt();
        int[][] field = new int[height + 2][width + 2];

        for (int i = 0; i < height; i++) {
            String line = in.next();
            for (int j = 0; j < width; j++) {
                field[i + 1][j + 1] = line.charAt(j) == '1' ? 1 : 0;
            }
        }
        makeTurn(field);
        print(field);
    }

    private static void makeTurn(int[][] field) {
        int[][] temp = new int[field.length][field[0].length];

        for (int i = 1; i < field.length - 1; i++) {
            for (int j = 1; j < field[i].length - 1; j++) {
                int countNeighbors = field[i - 1][j - 1] + field[i - 1][j] + field[i - 1][j + 1]
                        + field[i][j - 1] + field[i][j + 1]
                        + field[i + 1][j - 1] + field[i + 1][j] + field[i + 1][j + 1];

                if (field[i][j] == 0) {
                    if (countNeighbors == 3) {
                        temp[i][j] = 1;
                    } else {
                        temp[i][j] = 0;
                    }
                } else {
                    if (countNeighbors < 2 || countNeighbors > 3) {
                        temp[i][j] = 0;
                    } else {
                        temp[i][j] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < temp.length; i++) {
            System.arraycopy(temp[i], 0, field[i], 0, temp[i].length);
        }
    }

    private static void print(int[][] field) {
        for (int i = 1; i < field.length - 1; i++) {
            for (int j = 1; j < field[i].length - 1; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
}