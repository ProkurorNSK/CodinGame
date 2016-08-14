package HeartOfTheCity;

import java.util.*;

public class HeartOfTheCity {
    public static void main(String args[]) {
//        Scanner in = new Scanner(System.in);
//        long n = in.nextLong();
        long n = 1191;
        ArrayList<Double> listAngle = new ArrayList<>();
        int result = 0;
        int count = 0;
        Double angle;

        for (int i = 1 ; i <= (n-1)/2; i++) {
            for (int j = 0; j < i; j++) {
                angle = new Double((double)j/i);
                if (!listAngle.contains(angle)) {
                    listAngle.add(angle);
                    result++;
                }
                count++;
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(result*8);
        System.out.println(result);
        System.out.println(count);
    }
}
