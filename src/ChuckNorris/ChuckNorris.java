package ChuckNorris;


import java.util.*;
import java.io.*;
import java.math.*;

public class ChuckNorris {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
//        String MESSAGE = in.nextLine();
        String MESSAGE = "%";

        String binaryString = "";
        String result = "";
        char currentSymbol = ' ';
        String code;

        for (char symbol : MESSAGE.toCharArray()) {
            code = Integer.toBinaryString(symbol);
            for (int i = 0; i < 7 - code.length(); i++) {
                code = "0" + code;
            }
            binaryString += code;
        }

        System.out.println(binaryString);

        for (char symbol : binaryString.toCharArray()) {
            if (symbol != currentSymbol) {
                if (symbol == '1') {
                    result += " 0 0";
                } else {
                    result += " 00 0";
                }
                currentSymbol = symbol;
            } else {
                result += "0";
            }
        }


        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(result.trim());
    }
}
