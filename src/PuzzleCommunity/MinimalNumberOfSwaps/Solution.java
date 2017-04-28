package PuzzleCommunity.MinimalNumberOfSwaps;

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
        int n = in.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (numbers[i] == 0) {
                for (int j = n - 1; j > i; j--) {
                    if (numbers[j] == 1) {
                        numbers[i] = 1;
                        numbers[j] = 0;
                        result++;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
