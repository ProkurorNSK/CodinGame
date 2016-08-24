package PuzzleMedium.TelephoneNumbers;

import java.util.*;

public class TelephoneNumbers {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();
        int N = 5;
        String[] telephones = new String[N];
//        for (int i = 0; i < N; i++) {
//            String telephone = in.next();
//            telephones[i] = telephone;
//        }
        telephones[0] = "0412578440";
        telephones[1] = "0412199803";
        telephones[2] = "0468892011";
        telephones[3] = "112";
        telephones[4] = "15";

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        Arrays.sort(telephones);
        // The number of elements (referencing a number) stored in the structure.
        for (String number: telephones) {
            System.out.println(number);
        }
        int result = telephones[0].length();
        int count;

        for (int i = 1; i < telephones.length; i++) {
            count = 0;
            for (int j = 0; j < Math.min(telephones[i].length(), telephones[i-1].length()); j++) {
                if (telephones[i].charAt(j) == telephones[i-1].charAt(j)){
                    count++;
                } else {
                    break;
                }
            }
            result += telephones[i].length() - count;
        }
        System.out.println(result);
    }
}
