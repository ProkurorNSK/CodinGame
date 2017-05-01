package PuzzleMedium.MarsLanderEpisode2;

import java.util.*;

public class MarsLanderEpisode2 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int surfaceN = in.nextInt(); // the number of points used to draw the surface of Mars.
        ArrayList<Point> surface = new ArrayList<>();
        for (int i = 0; i < surfaceN; i++) {
            int landX = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
            int landY = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.
            surface.add(new Point(landX, landY));
        }

        boolean firstTurn = true;
        Ship ship = null;
        ArrayList<Point> targetPoints = null;
        while (true) {
            int X = in.nextInt();
            int Y = in.nextInt();
            int hSpeed = in.nextInt(); // the horizontal speed (in m/s), can be negative.
            int vSpeed = in.nextInt(); // the vertical speed (in m/s), can be negative.
            int fuel = in.nextInt(); // the quantity of remaining fuel in liters.
            int rotate = in.nextInt(); // the rotation angle in degrees (-90 to 90).
            int power = in.nextInt(); // the thrust power (0 to 4).

            if (firstTurn) {
                ship = new Ship(X, Y, hSpeed, vSpeed, fuel, rotate, power);
                targetPoints = calculatePoints(ship.x, ship.y, surface);
                firstTurn = false;
            } else {
                ship.update(X, Y, hSpeed, vSpeed, fuel, rotate, power);
            }

            for (Point target : targetPoints) {
                ship.fly(target);
            }
        }
    }

    private static ArrayList<Point> calculatePoints(int x, int y, ArrayList<Point> surface) {
        int startFlat = 0;
        int endFlat = 0;
        int yFlat = 0;
        int lastLandY = -1;
        int lastLandX = 0;
        int xFlat;

        for (Point point : surface) {
            if (lastLandY < 0) {
                lastLandY = point.y;
            } else {
                if (point.y == lastLandY) {
                    endFlat = point.x;
                    startFlat = lastLandX;
                    yFlat = point.y;
                } else {
                    lastLandX = point.x;
                    lastLandY = point.y;
                }
            }
        }
        System.err.println(startFlat + " " + endFlat + " " + yFlat);

        if (x > endFlat) {
            xFlat = endFlat;
        } else if (x < startFlat) {
            xFlat = startFlat;
        } else {
            xFlat = x;
        }

        ArrayList<Point> result = new ArrayList<>();
        result.add(new Point(xFlat, yFlat, true));

        System.err.println(result);
        return result;
    }

    static class Ship {
        int x;
        int y;
        int hSpeed;
        int vSpeed;
        int fuel;
        int rotate;
        int power;

        Ship(int x, int y, int hSpeed, int vSpeed, int fuel, int rotate, int power) {
            this.x = x;
            this.y = y;
            this.hSpeed = hSpeed;
            this.vSpeed = vSpeed;
            this.fuel = fuel;
            this.rotate = rotate;
            this.power = power;
        }

        void update(int x, int y, int hSpeed, int vSpeed, int fuel, int rotate, int power) {
            this.x = x;
            this.y = y;
            this.hSpeed = hSpeed;
            this.vSpeed = vSpeed;
            this.fuel = fuel;
            this.rotate = rotate;
            this.power = power;
        }

        void fly(Point target) {

            int powerControl = 0;
            int rotateControl;
            int xDistance = target.x - this.x;
            int yDistance = target.y - this.y;

            System.err.println("xD=" + xDistance + " yD=" + yDistance + " hS=" + hSpeed);
            if (Math.abs(xDistance) > 50 && (hSpeed == 0 || xDistance / hSpeed > yDistance / 40)) {
                rotateControl = xDistance > 0 ? -21 : 21;
                powerControl = 4;
            } else {
                rotateControl = 0;
                powerControl = vSpeed < -40 ? 4 : 0;
            }
            System.out.println(rotateControl + " " + powerControl);
        }
    }

    static class Point {
        int x;
        int y;
        boolean finish;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.finish = false;
        }

        Point(int x, int y, boolean finish) {
            this(x, y);
            this.finish = finish;
        }

        @Override
        public String toString() {
            return x + " - " + y;
        }
    }
}
