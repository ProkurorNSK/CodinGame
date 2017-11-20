package PuzzleCommunity.TheTwoPilesDifference;

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
        int N = in.nextInt();
        int[] values = new int[N];
        for (int i = 0; i < N; i++) {
            values[i] = in.nextInt();
        }

        Arrays.sort(values);

        int[] A = Arrays.copyOfRange(values, 0, N / 2);
        int[] B = Arrays.copyOfRange(values, N / 2, N);
        int min = calculate(A, B);

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N / 2; j++) {
                if (A[i] != B[j]) {
                    int temp = B[i];
                    B[j] = A[i];
                    A[i] = temp;
                    int result = calculate(A, B);
                    if (result < min) {
                        min = result;
                    }
                }
            }
        }

        System.out.println(min);
    }

    private static int calculate(int[] A, int[] B) {

        int sum = 0;
        for (int number : A) {
            sum += number;
        }

        int multi = 1;
        for (int number : B) {
            multi *= number;
        }

        return (int) Math.abs(Math.pow(sum, 2) - multi);
    }
}