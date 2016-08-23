package PuzzleMedium.ShadowsOfTheKnightEpisode1;

import java.util.*;

public class ShadowsOfTheKnightEpisode1 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();

        int xMin = 0;
        int xMax = W;
        int yMin = 0;
        int yMax = H;

        // game loop
        while (true) {
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)

            if (bombDir.contains("D")) yMin = Y0;
            if (bombDir.contains("U")) yMax = Y0;
            if (bombDir.contains("R")) xMin = X0;
            if (bombDir.contains("L")) xMax = X0;

            X0 = getPosition(xMin, xMax);
            Y0 = getPosition(yMin, yMax);

            System.out.println(X0 + " " + Y0);
        }
    }

    public static int getPosition(int minPosition, int maxPosition) {
        return ((maxPosition-minPosition) - (maxPosition-minPosition)%2)/2 + minPosition;
    }
}
