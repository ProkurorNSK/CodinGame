package PuzzleCommunity.SimplifySelectionRanges;

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
        String N = "[1,2,5,6,7,9,12,55,56,57,58,60,61,62,64,65,70]";

        String[] elements = N.substring(1, N.length() - 1).split(",");
        int[] numbers = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            numbers[i] = Integer.parseInt(elements[i]);
        }
        Arrays.sort(numbers);
        System.err.println(Arrays.toString(numbers));

        int count = 0;
        ArrayList<Integer> intervals = new ArrayList<>();
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] - numbers[i - 1] == 1) {
                count++;
            } else {
                intervals.add(count + 1);
                count = 0;
            }
            if (i == numbers.length - 1) {
                intervals.add(count + 1);
            }
        }

        System.err.println(intervals);

        StringBuilder result = new StringBuilder("");
        int index = 0;
        for (Integer interval : intervals) {
            if (interval == 1) {
                result.append(numbers[index]).append(",");
            } else if (interval == 2) {
                result.append(numbers[index]).append(",").append(numbers[index + 1]).append(",");
            } else {
                result.append(numbers[index]).append("-").append(numbers[index + interval - 1]).append(",");
            }
            index += interval;
        }

        System.out.println(result.deleteCharAt(result.length() - 1));
    }
}