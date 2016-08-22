package StockExchangeLosses;

import java.util.*;

public class StockExchangeLosses {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int iMin = 0;
        int iMax = 0;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            int v = in.nextInt();
            array[i] = v;
            if (v < min && i >= iMax) {
                min = v; iMin = i;
            }
            if (v > max && i <= iMin){
                max = v; iMax = i;
            }
            System.out.println(max + " " + min + " - " + iMax + " " + iMin);
        }

        int[] tempArray = Arrays.copyOf(array,array.length);

        result = min - max;
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(result < 0 ? result : 0);
    }
}
