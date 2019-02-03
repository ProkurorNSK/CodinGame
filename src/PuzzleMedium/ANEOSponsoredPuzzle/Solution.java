package PuzzleMedium.ANEOSponsoredPuzzle;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int speed = in.nextInt();

        int lightCount = in.nextInt();
        int[] distances = new int[lightCount];
        int[] durations = new int[lightCount];

        for (int i = 0; i < lightCount; i++) {
            int distance = in.nextInt();
            int duration = in.nextInt();
            distances[i] = distance;
            durations[i] = duration;
        }

        int result;
        for (result = speed; result >= 0; result--) {
            boolean pass = true;
            for (int i = 0; i < lightCount; i++) {
                float period = ((distances[i] * 3.6f)/result)/durations[i];
                if ((int) period % 2 == 1) {
                    pass = false;
                    break;
                }
            }
            if (pass) {
                break;
            }
        }

        System.out.println(result);
    }
}