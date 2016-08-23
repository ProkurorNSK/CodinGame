package Optimization.CodinGameSponsoredContest;

import java.util.*;

public class CodinGameSponsoredContest {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int firstInitInput = in.nextInt();
        int secondInitInput = in.nextInt();
        int thirdInitInput = in.nextInt();

        System.err.println(firstInitInput);
        System.err.println(secondInitInput);
        System.err.println(thirdInitInput);

        // game loop
        while (true) {
            String firstInput = in.next();
            String secondInput = in.next();
            String thirdInput = in.next();
            String fourthInput = in.next();

            System.err.println(firstInput);
            System.err.println(secondInput);
            System.err.println(thirdInput);
            System.err.println(fourthInput);

            for (int i = 0; i < thirdInitInput; i++) {
                int fifthInput = in.nextInt();
                int sixthInput = in.nextInt();

                System.err.println(fifthInput + " - " + sixthInput);
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println("D");
        }
    }
}
