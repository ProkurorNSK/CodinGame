package PuzzleCommunity.HillNotationAndHillOrder;

import java.util.*;

public class HillNotationAndHillOrder {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int numCompounds = in.nextInt();
        in.nextLine();
        ArrayList<> formuls;
        HashMap<String, Integer> formula;
        String buffer = "";
        for (int i = 0; i < numCompounds; i++) {
            char[] compound = in.nextLine().toCharArray();
            for (char symbol: compound) {
                if (Character.isUpperCase(symbol)) {
                    buffer += symbol;
                } else
            }

        }

        System.out.println("answer");
    }
}
