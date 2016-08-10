package DontPanicEpisode1CodeGolf;
import java.util.*;

public class DontPanicEpisode1CodeGolf {
    public static void main(String a[]) {
        Scanner I = new Scanner(System.in);
        int nbFloors = I.nextInt(); // number of floors
        int width = I.nextInt(); // width of the area
        int nbRounds = I.nextInt(); // maximum number of rounds
        int exitFloor = I.nextInt(); // floor on which the exit is found
        int exitPos = I.nextInt(); // position of the exit on its floor
        int nbTotalClones = I.nextInt(); // number of generated clones
        int nbAdditionalElevators = I.nextInt(); // ignore (always zero)
        int nbElevators = I.nextInt(); // number of elevators
        int[] elevators = new int[nbElevators+1];
        elevators[exitFloor] = exitPos;
        for (int i = 0; i < nbElevators; i++) {
            int elevatorFloor = I.nextInt(); // floor on which this elevator is found
            int elevatorPos = I.nextInt(); // position of the elevator on its floor
            elevators[elevatorFloor] = elevatorPos;
        }
        int targetFloor = 0;
        int posNearestTarget = 0;
        // game loop
        while (true) {
            int cloneFloor = I.nextInt(); // floor of the leading clone
            int clonePos = I.nextInt(); // position of the leading clone on its floor
            String direction = I.next(); // direction of the leading clone: LEFT or RIGHT
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            if (targetFloor == cloneFloor) {
                posNearestTarget = elevators[cloneFloor];
                if (direction.contains("RIGHT")) {
                    if (clonePos < posNearestTarget) {
                        System.out.println("WAIT");
                    } else if (clonePos > posNearestTarget) {
                        System.out.println("BLOCK");
                    } else {
                        System.out.println("WAIT");
                        targetFloor++;
                    }
                } else {
                    if (clonePos > posNearestTarget) {
                        System.out.println("WAIT");
                    } else if (clonePos < posNearestTarget) {
                        System.out.println("BLOCK");
                    } else {
                        System.out.println("WAIT");
                        targetFloor++;
                    }
                }
            } else {
                System.out.println("WAIT"); // action: WAIT or BLOCK
            }
        }
    }
}
