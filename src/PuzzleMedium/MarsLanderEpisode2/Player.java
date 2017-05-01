package PuzzleMedium.MarsLanderEpisode2;

import java.util.*;

class Player {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int surfaceN = in.nextInt();
        in.nextLine();
        int[] landXl = new int[surfaceN];
        int[] landYl = new int[surfaceN];
        int xStartFlat = 0, xEndFlat = 0, yCentreFlat;

        for (int i = 0; i < surfaceN; i++) {
            int landX = in.nextInt();
            int landY = in.nextInt();
            landXl[i] = landX;
            landYl[i] = landY;
            if (i > 0) {
                if (landYl[i] == landYl[i - 1]) {
                    xStartFlat = landXl[i - 1];
                    xEndFlat = landXl[i];
                }
            }
        }
        yCentreFlat = (xStartFlat + xEndFlat) / 2;

        // game loop
        while (true) {
            int X = in.nextInt();
            int Y = in.nextInt();
            int hSpeed = in.nextInt(); // the horizontal speed (in m/s), can be negative.
            int vSpeed = in.nextInt(); // the vertical speed (in m/s), can be negative.
            int fuel = in.nextInt(); // the quantity of remaining fuel in liters.
            int rotate = in.nextInt(); // the rotation angle in degrees (-90 to 90).
            int power = in.nextInt(); // the thrust power (0 to 4).


            if (Math.abs(yCentreFlat - X) < 750) {
                if (hSpeed > 5) {
                    System.out.println("50 4");
                } else if (hSpeed < -5) {
                    System.out.println("-50 4");
                } else {
                    if (vSpeed < -39) {
                        System.out.println("0 4");
                    } else {
                        System.out.println("0 3");
                    }
                }
            } else {
                if ((yCentreFlat - X) > 0) {
                    if (hSpeed > 40) {
                        System.out.println("20 4");
                    } else {
                        System.out.println("-20 4");
                    }
                } else if ((yCentreFlat - X) < 0) {
                    if (hSpeed < -40) {
                        System.out.println("-20 4");
                    } else {
                        System.out.println("20 4");
                    }
                }
            }
        }
    }
}