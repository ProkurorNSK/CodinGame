package PuzzleEasy.HorseRacingDuals;

import java.util.*;

public class HorseRacingDuals {
    public static void main(String args[]) {
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();
        int N = 3;

        int[] horses = new int[N];

//        for (int i = 0; i < N; i++) {
//            int pi = in.nextInt();
//            horses[i] = pi;
//        }
        horses[0] = 5;
        horses[1] = 8;
        horses[2] = 9;

        Arrays.sort(horses);

        int minDifferince = Integer.MAX_VALUE;
        for (int i = 0; i < horses.length-1; i++) {
            if (Math.abs(horses[i] - horses[i+1]) < minDifferince) {
                minDifferince = Math.abs(horses[i] - horses[i+1]);
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(minDifferince);
    }
}
