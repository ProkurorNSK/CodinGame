package PuzzleCommunity.SumOfDivisors;

import java.util.*;

public class SumOfDivisors {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        long result = 0;

        for (int i = 1; i <= n/2; i++) {
            long N = (int) (n/i);
            result += ((N + 1) * N)/ 2;
        }

        System.out.println(result + n/2);
    }
}
