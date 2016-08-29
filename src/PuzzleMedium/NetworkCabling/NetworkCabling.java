package PuzzleMedium.NetworkCabling;

import java.util.*;

public class NetworkCabling {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] y = new int[N];
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int X = in.nextInt();
            y[i] = in.nextInt();
            if (X > maxX) {
                maxX = X;
            }
            if (X < minX) {
                minX = X;
            }
        }
        Arrays.sort(y);
        long median = y[N/2];
        long result = 0;
        for (long Y:y) {
            result += Math.abs(Y - median);
        }
        System.out.println((maxX - minX) + result);
    }
}
