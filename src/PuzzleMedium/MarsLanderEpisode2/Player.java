package PuzzleMedium.MarsLanderEpisode2;

import java.util.*;

class Player {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int startFlat = 0;
        int endFlat = 0;
        int yFlat = 0;
        int lastLandY = 0;
        int lastLandX = 0;
        int surfaceN = in.nextInt(); // the number of points used to draw the surface of Mars.
        for (int i = 0; i < surfaceN; i++) {
            int landX = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
            int landY = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.
            if (i == 0) {
                lastLandY = landY;
            } else {
                if (landY == lastLandY) {
                    endFlat = landX;
                    startFlat = lastLandX;
                    yFlat = landY;
                } else {
                    lastLandX = landX;
                    lastLandY = landY;
                }
            }
        }

        boolean firstTurn = true;
        int xTarget = 0;
        final int ANGLE_FAST = 50;
        final int ANGLE_FAR = 31;
        final int SPEED_FAR = 70;
        // game loop
        while (true) {
            int x = in.nextInt();
            int y = in.nextInt();
            int hSpeed = in.nextInt(); // the horizontal speed (in m/s), can be negative.
            int vSpeed = in.nextInt(); // the vertical speed (in m/s), can be negative.
            int fuel = in.nextInt(); // the quantity of remaining fuel in liters.
            int rotate = in.nextInt(); // the rotation angle in degrees (-90 to 90).
            int power = in.nextInt(); // the thrust power (0 to 4).

            if (firstTurn) {
                if (x > endFlat) {
                    xTarget = endFlat;
                } else if (x < startFlat) {
                    xTarget = startFlat;
                } else {
                    xTarget = x;
                }
                System.err.println(startFlat + " - " + endFlat + " - " + yFlat + " - " + xTarget);
                firstTurn = false;
            }

            if (Math.abs(xTarget - x) < 750 || (x > startFlat && x < endFlat)) {
                System.err.println("Near, above platform");
                if (hSpeed > 19) {
                    System.err.println("Fast Right " + hSpeed);
                    System.out.println(ANGLE_FAST + " 4");
                } else if (hSpeed < -19) {
                    System.err.println("Fast Left " + hSpeed);
                    System.out.println(-ANGLE_FAST + " 4");
                } else {
                    System.err.println("Slow horizontal " + hSpeed);
                    if (vSpeed <= -40) {
                        System.err.println("Fast Down " + vSpeed);
                        System.out.println("0 4");
                    } else {
                        System.err.println("Slow Down " + vSpeed);
                        System.out.println("0 3");
                    }
                }
            } else {
                System.err.println("Far Away");
                if ((xTarget - x) > 0) {
                    System.err.println("Platform right");
                    if (hSpeed > SPEED_FAR + 1) {
                        System.err.println("Horizontal > 41 " + hSpeed);
                        System.out.println(ANGLE_FAR + " 4");
                    } else if (hSpeed < SPEED_FAR - 1) {
                        System.err.println("Horizontal < 39 " + hSpeed);
                        System.out.println(-ANGLE_FAR + " 4");
                    } else {
                        System.err.println("Horizontal = 39-41 " + hSpeed);
                        System.out.println("0 3");
                    }
                } else if ((xTarget - x) < 0) {
                    System.err.println("Platform right");
                    if (hSpeed < -(SPEED_FAR + 1)) {
                        System.err.println("Horizontal > 41 " + hSpeed);
                        System.out.println(-ANGLE_FAR + " 4");
                    } else if (hSpeed > -(SPEED_FAR - 1)) {
                        System.err.println("Horizontal < 39 " + hSpeed);
                        System.out.println(ANGLE_FAR + " 4");
                    } else {
                        System.err.println("Horizontal = 39-41 " + hSpeed);
                        if (y - yFlat > 550) {
                            System.out.println("0 3");
                        } else {
                            System.out.println("0 4");
                        }
                    }
                }
            }
        }
    }
}