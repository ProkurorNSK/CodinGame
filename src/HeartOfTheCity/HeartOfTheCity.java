package HeartOfTheCity;

import java.util.*;

public class HeartOfTheCity {
    public static void main(String args[]) {
//        Scanner in = new Scanner(System.in);
//        long n = in.nextLong();
        long n = 333;
        int preResult;
        int result = 0;
        int count = 0;

        for (int i = 1 ; i <= (n-1)/2; i++) {
            preResult = 0;
            for (int j = 0; j < i; j++) {
                if (gcd(i,j) == 1) {
//                    result++;
                    preResult++;
//                    System.out.println((double)j/i);
                }
                count++;
            }
            result += getResult(i);
            System.out.println(i + ":" + preResult);
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(result*8);
        System.out.println(result);
        System.out.println(count);
    }
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
    private static int getResult(int n) {
        int result = (n==1)?1:n-1;

        for (int i = 2; i <= n; i++) {
            if (n%i == 0) {
                System.out.print(i + " ");
                n = n/i;
            }
        }

        return result;
    }
}
