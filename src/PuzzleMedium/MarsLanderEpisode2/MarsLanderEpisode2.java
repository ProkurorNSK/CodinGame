package PuzzleMedium.MarsLanderEpisode2;

import java.util.*;

public class MarsLanderEpisode2 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int surfaceN = in.nextInt(); // the number of points used to draw the surface of Mars.
        int startFlat = 0;
        int endFlat = 0;
        int lastLandY = 0;
        int lastLandX = 0;
        for (int i = 0; i < surfaceN; i++) {
            int landX = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
            int landY = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.
            System.err.println(landX + " " + landY);
            if (i == 0) {
                lastLandY = landY;
            } else {
                if (landY == lastLandY) {
                    endFlat = landX;
                    startFlat = lastLandX;
                } else {
                    lastLandX = landX;
                    lastLandY = landY;
                }
            }
        }
        System.err.println(startFlat + " " + endFlat);
        // game loop
        while (true) {
            int X = in.nextInt();
            int Y = in.nextInt();
            int hSpeed = in.nextInt(); // the horizontal speed (in m/s), can be negative.
            int vSpeed = in.nextInt(); // the vertical speed (in m/s), can be negative.
            int fuel = in.nextInt(); // the quantity of remaining fuel in liters.
            int rotate = in.nextInt(); // the rotation angle in degrees (-90 to 90).
            int power = in.nextInt(); // the thrust power (0 to 4).

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // rotate power. rotate is the desired rotation angle. power is the desired thrust power.
            power = vSpeed <= -40 ? 4 : 0;
            if (X < startFlat && hSpeed <= 20) {
                rotate = -90;
                power = 4;
            } else if (X > endFlat && hSpeed >= 20) {
                rotate = 90;
                power = 4;
            } else {
                rotate = 0;
            }

            System.out.println(rotate + " " + power);
        }
    }
}
