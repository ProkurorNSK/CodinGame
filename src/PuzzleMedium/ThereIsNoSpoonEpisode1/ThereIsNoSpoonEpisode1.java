package PuzzleMedium.ThereIsNoSpoonEpisode1;

import java.util.*;

public class ThereIsNoSpoonEpisode1 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        in.nextLine();


        int[][] field = new int[width][height];

        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            for (int j = 0; j < line.length(); j++) {
                char symbol = line.charAt(j);
                if (symbol == '0') {
                    field[j][i] = 1;
                } else if (symbol == '.'){
                    field[j][i] = 0;
                }
            }
        }

        String out = "";
        boolean isRight = true;
        boolean isBottom = true;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 1) {
                    out += i + " " + j;
                    for (int k = 1; k < field.length - i; k++) {
                        if (i+k < field.length && field[i+k][j] == 1) {
                            out += " " + (i+k) + " " + j;
                            isRight = false;
                            break;
                        }
                    }
                    if (isRight) {
                        out += " " + (-1) + " " + (-1);
                    }

                    for (int k = 1; k < field[i].length-j; k++) {
                        if (j+k < field[i].length && field[i][j+k] == 1) {
                            out += " " + i + " " + (j+k);
                            isBottom = false;
                            break;
                        }
                    }
                    if (isBottom) {
                        out += " " + (-1) + " " + (-1);
                    }


                    System.out.println(out);
                    out = "";
                    isRight = true;
                    isBottom = true;
                }
            }
        }
    }
}
