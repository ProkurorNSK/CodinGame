package BotProgramming.SmashTheCode;

import java.util.*;

public class SmashTheCode {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        char[][] myField = new char[12][6];
        // game loop
        while (true) {
            for (int i = 0; i < 8; i++) {
                int colorA = in.nextInt(); // color of the first block
                int colorB = in.nextInt(); // color of the attached block
            }
            int score1 = in.nextInt();
            for (int i = 0; i < 12; i++) {
                String row = in.next();
                char[] charArray = row.toCharArray();
                for (int j = 0; j < charArray.length; j++) {
                    myField[i][j] = charArray[j];
                }
            }
            int score2 = in.nextInt();
            for (int i = 0; i < 12; i++) {
                String row = in.next(); // One line of the map ('.' = empty, '0' = skull block, '1' to '5' = colored block)
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            printArray(myField);
            System.out.println("0"); // "x": the column in which to drop your blocks
        }
    }
    public static void printArray(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.err.println(field[i][j] + " ");
            }
            System.err.println("");
        }
    }
    public static void findPlace(char[][] field, int color) {

    }
}
