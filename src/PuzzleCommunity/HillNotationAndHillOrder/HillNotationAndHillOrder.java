package PuzzleCommunity.HillNotationAndHillOrder;

import java.util.*;

public class HillNotationAndHillOrder {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int numCompounds = in.nextInt();
        in.nextLine();
        ArrayList<HashMap<String, Integer>> formuls = new ArrayList<>();
        HashMap<String, Integer> formula;
        String buffer = "";
        String bufferNumber = "";
        for (int i = 0; i < numCompounds; i++) {
            char[] compound = in.nextLine().toCharArray();
            formula = new HashMap<>();
            for (char symbol : compound) {
                if (Character.isUpperCase(symbol)) {
                    if (!buffer.isEmpty()) {
                        formula.put(buffer, bufferNumber.isEmpty() ? 1 : Integer.parseInt(bufferNumber));
                        buffer = "";
                        bufferNumber = "";
                    }
                    buffer += symbol;
                } else if (Character.isLowerCase(symbol)) {
                    buffer += symbol;
                } else if (Character.isDigit(symbol)) {
                    bufferNumber += symbol;
                }
            }
            formula.put(buffer, bufferNumber.isEmpty() ? 1 : Integer.parseInt(bufferNumber));
            buffer = "";
            bufferNumber = "";
            formuls.add(formula);
        }

        System.out.println(formuls);
    }
}
