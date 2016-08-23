package PuzzleMedium.DontPanicEpisode1;

import java.util.*;

public class DontPanicEpisode1 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int nbFloors = in.nextInt(); // number of floors
        int width = in.nextInt(); // width of the area
        int nbRounds = in.nextInt(); // maximum number of rounds
        int exitFloor = in.nextInt(); // floor on which the exit is found
        int exitPos = in.nextInt(); // position of the exit on its floor
        int nbTotalClones = in.nextInt(); // number of generated clones
        int nbAdditionalElevators = in.nextInt(); // ignore (always zero)
        int nbElevators = in.nextInt(); // number of elevators

        int[] elevators = new int[nbElevators+1];
        elevators[exitFloor] = exitPos;
        for (int i = 0; i < nbElevators; i++) {
            int elevatorFloor = in.nextInt(); // floor on which this elevator is found
            elevators[elevatorFloor] = in.nextInt();
        }
        int targetFloor = 0;
        // game loop
        while (true) {
            int cloneFloor = in.nextInt(); // floor of the leading clone
            int clonePos = in.nextInt(); // position of the leading clone on its floor
            String direction = in.next(); // direction of the leading clone: LEFT or RIGHT

            if ((targetFloor == cloneFloor) && ((direction.equals("RIGHT") && clonePos > elevators[cloneFloor]) || (direction.equals("LEFT") && clonePos < elevators[cloneFloor]))) {
                System.out.println("BLOCK");
            }else {
                System.out.println("WAIT");
            }
            if (targetFloor == cloneFloor && clonePos == elevators[cloneFloor]) targetFloor++;
        }
    }
}
