package PuzzleCommunity.Elevator;

import java.util.*;

public class Elevator {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int k = in.nextInt();
        int m = in.nextInt();

        boolean isSolution = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m-k == a*i - b*j) {
                    System.out.println(i+j);
                    isSolution = true;
                    break;
                }
            }
            if (isSolution) break;
        }
        if (!isSolution) System.out.println("IMPOSSIBLE");
    }
}
