package EgyptianMultiplication;

import java.util.*;

public class EgyptianMultiplication {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
//        int a = in.nextInt();
        int a = 7675;
//        int b = in.nextInt();
        int b = 179;

        String c = "";
        int result = 0;

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        if (a < b) {
            int x = a;
            a = b;
            b = x;
        }
        System.out.println(a + " * " + b);
        do {
            if (b%2 == 0) {
                a *= 2; b /= 2;
            } else {
                b--; c += " + " + a; result += a;
            }
            if (b != 0 || c != "") {
                System.out.println("= " + a + " * " + b + c);
            }
        } while (b != 0);

        System.out.println("= " + result);
    }
}
