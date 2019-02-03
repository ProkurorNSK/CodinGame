package PuzzleCommunity.HeartOfTheCity;


import java.math.BigInteger;
import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        long n = 5;

        long time = System.currentTimeMillis();
        System.out.println(isPrime(n));
        System.out.println("Время выполнения(мс) - " + (System.currentTimeMillis() - time));
    }

    // Given a positive number n, find the largest number m such
    // that 2^m divides n.
    private static int val2(int n) {
        int m = 0;
        if ((n & 0xffff) == 0) {
            n >>= 16;
            m += 16;
        }
        if ((n & 0xff) == 0) {
            n >>= 8;
            m += 8;
        }
        if ((n & 0xf) == 0) {
            n >>= 4;
            m += 4;
        }
        if ((n & 0x3) == 0) {
            n >>= 2;
            m += 2;
        }
        if (n > 1) {
            m++;
        }
        return m;
    }

    // For convenience, handle modular exponentiation via BigInteger.
    private static int modPow(int base, int exponent, int m) {
        BigInteger bigB = BigInteger.valueOf(base);
        BigInteger bigE = BigInteger.valueOf(exponent);
        BigInteger bigM = BigInteger.valueOf(m);
        BigInteger bigR = bigB.modPow(bigE, bigM);
        return bigR.intValue();
    }

    // Basic implementation.
    private static boolean isStrongProbablePrime(int n, int base) {
        int s = val2(n - 1);
        int d = modPow(base, n >> s, n);
        if (d == 1) {
            return true;
        }
        for (int i = 1; i < s; i++) {
            if (d + 1 == n) {
                return true;
            }
            d = d * d % n;
        }
        return d + 1 == n;
    }

    private static boolean isPrime(int n) {
        if ((n & 1) == 0) {
            return n == 2;
        }
        if (n < 9) {
            return n > 1;
        }

        return isStrongProbablePrime(n, 2) && isStrongProbablePrime(n, 7) && isStrongProbablePrime(n, 61);
    }

}