package Optimization.CodeOfTheRings;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String magicPhrase = in.nextLine();

        char symbol;
        int lastNumberOfSymbol = 0;
        int numberOfSymbol;
        int delta;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < magicPhrase.length(); i++) {
            symbol = magicPhrase.charAt(i);
            if (symbol == ' ') {
                numberOfSymbol = 0;
            } else {
                numberOfSymbol = symbol - 'A' + 1;
            }

            delta = numberOfSymbol - lastNumberOfSymbol;
            if (Math.abs(delta) > 13) {
                delta = delta > 0 ? delta - 27 : delta + 27;
            }
            for (int j = 0; j < Math.abs(delta); j++) {
                if (delta > 0) {
                    result = result.append("+");
                } else {
                    result = result.append("-");
                }
            }
            result = result.append(".");
            lastNumberOfSymbol = numberOfSymbol;
        }

        System.out.println(result);
    }
}