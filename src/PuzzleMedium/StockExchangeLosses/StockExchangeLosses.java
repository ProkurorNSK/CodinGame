package PuzzleMedium.StockExchangeLosses;

import java.util.*;

public class StockExchangeLosses {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long time = System.currentTimeMillis();
        int result = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int v = in.nextInt();
            result = Math.min(result, v - max);
            max = Math.max(max,v);
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(result < 0 ? result : 0);
        System.out.println("Время выполнения(мс) - " + (System.currentTimeMillis() - time));
    }
}
