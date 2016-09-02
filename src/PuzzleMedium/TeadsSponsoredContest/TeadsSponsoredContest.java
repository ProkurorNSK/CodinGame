package PuzzleMedium.TeadsSponsoredContest;

import java.util.*;

public class TeadsSponsoredContest {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of adjacency relations
        for (int i = 0; i < n; i++) {
            int xi = in.nextInt(); // the ID of a person which is adjacent to yi
            int yi = in.nextInt(); // the ID of a person which is adjacent to xi
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");


        // The minimal amount of steps required to completely propagate the advertisement
        System.out.println("1");
    }
}
