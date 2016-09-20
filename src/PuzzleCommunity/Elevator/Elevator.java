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

        int shift = m - k;
        int targetFlor = k;

        if (Math.abs(m-k)%Math.abs(b-a) == 0) {

        } else {
            System.out.println("IMPOSSIBLE");
        }

    }
}
