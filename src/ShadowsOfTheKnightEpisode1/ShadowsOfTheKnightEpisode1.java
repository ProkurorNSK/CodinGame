package ShadowsOfTheKnightEpisode1;

import java.util.*;

public class ShadowsOfTheKnightEpisode1 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();

        // game loop
        while (true) {
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            if (bombDir == U)


            // the location of the next window Batman should jump to.
            System.out.println("0 0");
        }
    }
}
