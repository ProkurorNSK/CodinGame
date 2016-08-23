package PuzzleMedium.ConwaySequence;

//import java.util.*;

import java.util.ArrayList;

public class ConwaySequence {
    public static void main(String args[]) {
//        Scanner in = new Scanner(System.in);
//        int R = in.nextInt();
        int R = 1;
//        int L = in.nextInt();
        int L = 11;

        ArrayList<Integer> result = new ArrayList<>(0);
        result.add(R);

        calculateSequence(L, result);
    }

    private static void calculateSequence(int L, ArrayList<Integer> incomingData) {
        if (L > 1) {
            ArrayList<Integer> result = new ArrayList<>(0);

            int count = 1;
            int lastNumber = incomingData.get(0);
            for (int i = 1; i < incomingData.size(); i++) {
                if (incomingData.get(i) != lastNumber) {
                    result.add(count);
                    result.add(lastNumber);
                    count = 1;
                    lastNumber = incomingData.get(i);
                } else {
                    count++;
                }
            }
            result.add(count);
            result.add(lastNumber);

            L--;
            calculateSequence(L, result);
        } else {
            String result = "";
            for (int number: incomingData) {
                result += number + " ";
            }
            System.out.println(result.trim());
        }
    }
}
