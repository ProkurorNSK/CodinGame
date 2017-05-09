package ClashOfCode;

import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        char[] S = in.nextLine().toCharArray();

        System.err.println(S);
        String result = "";
        for (char symbol: S) {
            int begin = 0;
            if (Character.isDigit(symbol)) {
                begin = 48;
            } else if (Character.isLowerCase(symbol)) {
                begin = 97;
            } else if (Character.isUpperCase(symbol)) {
                begin = 65;
            }

            for (int i = begin; i <= (int)symbol; i++) {
                result += (char)i;
            }
        }

        System.out.println(result);
    }
}