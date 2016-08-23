package PuzzleMedium.TheLastCrusadeEpisode1;

import java.util.*;

public class TheLastCrusadeEpisode1 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // number of columns.
        int H = in.nextInt(); // number of rows.
        in.nextLine();

        int[][] field = new int[H][W];
        int dX = 0;
        int dY = 0;

        for (int i = 0; i < H; i++) {
            String LINE = in.nextLine(); // represents a line in the grid and contains W integers. Each integer represents one room of a given type.
            String[] numbers = LINE.split(" ");
            for (int j = 0; j < W; j++) {
                field[i][j] = Integer.parseInt(numbers[j]);
            }
        }
        int EX = in.nextInt(); // the coordinate along the X axis of the exit (not useful for this first mission, but must be read).

        // game loop
        while (true) {
            int XI = in.nextInt();
            int YI = in.nextInt();
            String POS = in.next();
            int element = field[YI][XI];
            switch (element) {
                case 1: case 3: case 7: case 8: case 9: case 12: case 13:
                    dX = 0; dY = 1; break;
                case 2:case 6:
                    if (POS.equals("LEFT")) {
                        dX = 1; dY = 0;
                    } else {
                        dX = -1; dY = 0;
                    }
                    break;
                case 4:
                    if (POS.equals("RIGHT")) {
                        dX = 0; dY = 1;
                    } else {
                        dX = -1; dY = 0;
                    }
                    break;
                case 5:
                    if (POS.equals("LEFT")) {
                        dX = 0; dY = 1;
                    } else {
                        dX = 1; dY = 0;
                    }
                    break;
                case 10:
                    dX = -1; dY = 0; break;
                case 11:
                    dX = 1; dY = 0; break;
            }
            System.out.println((XI + dX) + " " + (YI + dY));
        }
    }
}
