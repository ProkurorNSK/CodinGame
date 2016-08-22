package TheLastCrusadeEpisode1;

import java.util.*;

public class TheLastCrusadeEpisode1 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // number of columns.
        int H = in.nextInt(); // number of rows.
        in.nextLine();
        int[][] field = new int[H][W];
        for (int i = 0; i < H; i++) {
            String LINE = in.nextLine(); // represents a line in the grid and contains W integers. Each integer represents one room of a given type.
            String[] lines = LINE.split(" ");
            for (int j = 0; j < W; j++) {
                field[i][j] = Character.digit(lines[j].toCharArray()[0], 10);
            }
        }
        int EX = in.nextInt(); // the coordinate along the X axis of the exit (not useful for this first mission, but must be read).

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                System.err.print(field[i][j] + " ");
            }
            System.err.println("");
        }

        // game loop
        while (true) {
            int XI = in.nextInt();
            int YI = in.nextInt();
            String POS = in.next();

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // One line containing the X Y coordinates of the room in which you believe Indy will be on the next turn.
            System.out.println("0 0");
        }
    }
}
