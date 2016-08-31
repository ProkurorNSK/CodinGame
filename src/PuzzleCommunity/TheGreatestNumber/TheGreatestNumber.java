package PuzzleCommunity.TheGreatestNumber;

import java.util.*;

public class TheGreatestNumber {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        in.nextInt();
        in.nextLine();
        String[] chars = in.nextLine().split(" ");
        ArrayList<String> digits = new ArrayList<>(0);
        boolean isNegative = false;
        boolean isFractional = false;
        String result = "";

        for (String symbol : chars) {
            switch (symbol) {
                case "-":
                    isNegative = true;
                    break;
                case ".":
                    isFractional = true;
                    break;
                default:
                    digits.add(symbol);
                    break;
            }
        }

        Collections.sort(digits);

        if (digits.get(digits.size()-1).equals("0")) {
            result = "0";
        } else if (isNegative) {
            result += "-";
            for (int i = 0; i < digits.size(); i++) {
                result += digits.get(i);
                if (isFractional && i == 0) result += ".";
            }
        } else {
            for (int i = digits.size() - 1; i >= 0; i--) {
                result += digits.get(i);
                if (isFractional && i == 1) {
                    if (!digits.get(0).equals("0")) {
                        result += ".";
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}