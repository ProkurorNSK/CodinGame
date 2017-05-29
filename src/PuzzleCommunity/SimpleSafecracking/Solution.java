package PuzzleCommunity.SimpleSafecracking;

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
        String msg = in.nextLine();

        String[] parts = msg.split(": ");

        String[] words = parts[1].split("-");
        char[] letters = parts[0].toCharArray();
        String symbol = "";

        for (String word : words) {
            if (word.length() == 3) {
                if (word.charAt(0) == letters[18]) {
                    symbol = "1";
                } else if (word.charAt(0) == letters[16]) {
                    symbol = "2";
                } else if (word.charAt(0) == letters[22]) {
                    symbol = "6";
                }
            } else if (word.length() == 4) {
                if (word.charAt(1) == letters[2]) {
                    symbol = "0";
                } else if (word.charAt(1) == letters[18]) {
                    symbol = "4";
                } else if (word.charAt(0) == letters[6]) {
                    symbol = "5";
                } else if (word.charAt(3) == letters[7]) {
                    symbol = "9";
                }
            } else if (word.length() == 5) {
                if (word.charAt(0) == letters[16]) {
                    symbol = "3";
                } else if (word.charAt(0) == letters[22]) {
                    symbol = "7";
                } else if (word.charAt(0) == letters[2]) {
                    symbol = "8";
                }
            }
            System.out.print(symbol);
        }
    }
}