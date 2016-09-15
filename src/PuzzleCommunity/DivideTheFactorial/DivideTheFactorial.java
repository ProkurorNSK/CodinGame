package PuzzleCommunity.DivideTheFactorial;

import java.util.*;

public class DivideTheFactorial {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();

        int last;
        int count = 0;
        for (int i = 2; i * i <= A; ++i) {
            if (A % i == 0) {
                count = 0;
                while (A != i && A % i == 0) {
                    A /= i;
                    count++;
                }
            }
        }

        int result = 0;
        while (B >= A) {
            B /= A;
            result += B;
        }
        System.out.println(result / (count + 1));
    }
}
