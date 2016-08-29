package PuzzleMedium.NetworkCabling;

import java.util.*;

public class NetworkCabling {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long[] y = new long[N];
        long minX = Integer.MAX_VALUE;
        long maxX = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            long X = in.nextInt();
            y[i] = in.nextInt();
            maxX = Math.max(X, maxX);
            minX = Math.min(X, minX);
        }
        Arrays.sort(y);
        long median = y[N / 2];
        long result = maxX - minX;
        for (long Y : y) {
            result += Math.abs(Y - median);
        }
        System.out.println(result);
    }
}
