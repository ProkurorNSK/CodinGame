package PuzzleCommunity.BracketsExtremeEdition;

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
        String expression = "{([{S}]]6K[()]}";

        char[] symbols = expression.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for (char symbol : symbols) {
            switch (symbol) {
                case '(':
                case '[':
                case '{':
                    stack.add(0, symbol);
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.get(0) == '(') {
                        stack.remove(0);
                    } else {
                        stack.add(0, symbol);
                    }
                    break;
                case ']':
                    if (!stack.isEmpty() && stack.get(0) == '[') {
                        stack.remove(0);
                    } else {
                        stack.add(0, symbol);
                    }
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.get(0) == '{') {
                        stack.remove(0);
                    } else {
                        stack.add(0, symbol);
                    }
            }
        }
        System.out.println((stack.size() == 0) ? "true" : "false");
    }
}