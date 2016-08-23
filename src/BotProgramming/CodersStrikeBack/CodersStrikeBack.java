package BotProgramming.CodersStrikeBack;

import java.util.*;

public class  CodersStrikeBack {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        boolean firstTurn = true;
        // game loop
        while (true) {
            int x = in.nextInt();
            int y = in.nextInt();
            int nextCheckpointX = in.nextInt(); // x position of the next check point
            int nextCheckpointY = in.nextInt(); // y position of the next check point
            int nextCheckpointDist = in.nextInt(); // distance to the next checkpoint
            int nextCheckpointAngle = in.nextInt(); // angle between your pod orientation and the direction of the next checkpoint
            int opponentX = in.nextInt();
            int opponentY = in.nextInt();

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // You have to output the target position
            // followed by the power (0 <= thrust <= 100)
            // i.e.: "x y thrust"

            int newNextCheckpointX = (599/nextCheckpointDist) * (x - nextCheckpointX) + nextCheckpointX;
            int newNextCheckpointY = (599/nextCheckpointDist) * (y - nextCheckpointY) + nextCheckpointY;

            if (Math.abs(nextCheckpointAngle) < 90) {
                if (firstTurn) {
                    System.out.println(newNextCheckpointX + " " + newNextCheckpointY + " BOOST");
                    firstTurn = false;
                } else if (Math.sqrt((x - opponentX)*(x - opponentX) + (y - opponentY)*(y - opponentY)) < 795) {
                    System.out.println(newNextCheckpointX + " " + newNextCheckpointY + " SHIELD");
                } else{
                    System.out.println(newNextCheckpointX + " " + newNextCheckpointY + " 100");
                }
            } else {
                System.out.println(newNextCheckpointX + " " + newNextCheckpointY + " 0");
            }
        }
    }
}
