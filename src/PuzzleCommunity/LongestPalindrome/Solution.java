package PuzzleCommunity.LongestPalindrome;

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
//        char[] s = in.next().toCharArray();
        char[] s = "CGTCATTCATGCGGAAGGGGTAAGACCATTAGAAGTAGGGATAGTCCCGAACCTCACTTACCACTCCCAATAAGGGATCCCTGTCTGAAGGATGAGTGTCAGCCAGTGTAACCCGATGAGGTACCCAGAAGCCGAACTGGGCCAGACAACCCGGCGCTAACGCACTCAAAGCCGGGACGCGACGCGACATATCGGCTAAGAGTAGGCCGGGAGTGTAGACCTTTGGGGTTGAATAAATCTGTCGTAGTAACCGGCT".toCharArray();
        int n = s.length;
        int[] oddPalindrome = new int[n];
        int[] evenPalindrome = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            oddPalindrome[i] = 1;
            while (i - oddPalindrome[i] >= 0 && i + oddPalindrome[i] < n && s[i - oddPalindrome[i]] == s[i + oddPalindrome[i]]) {
                oddPalindrome[i]++;
            }
            if (oddPalindrome[i] * 2 - 1 > max) {
                max = oddPalindrome[i] * 2 - 1;
            }

            evenPalindrome[i] = 0;
            while (i - evenPalindrome[i] - 1 >= 0 && i + evenPalindrome[i] < n && s[i - evenPalindrome[i] - 1] == s[i + evenPalindrome[i]])
                evenPalindrome[i]++;
            if (evenPalindrome[i] * 2 > max) {
                max = evenPalindrome[i] * 2;
            }
        }

//        System.out.println(Arrays.toString(oddPalindrome));
//        System.out.println(Arrays.toString(evenPalindrome));

        for (int i = 0; i < n; i++) {
            if (oddPalindrome[i] * 2 - 1 == max) {
                System.out.println(new String(Arrays.copyOfRange(s, i - oddPalindrome[i] + 1, i + oddPalindrome[i])));
            }
            if (evenPalindrome[i] * 2 == max) {
                System.out.println(new String(Arrays.copyOfRange(s, i - evenPalindrome[i], i + evenPalindrome[i])));
            }
        }
    }
}