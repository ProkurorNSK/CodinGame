package PuzzleMedium.TheGift;

import java.util.*;

public class TheGift {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int C = in.nextInt();
        int[] budgets = new int[N];
        int[] results = new int[N];
        for (int i = 0; i < N; i++) {
            budgets[i] = in.nextInt();
        }

        Arrays.sort(budgets);

        for (int i = 0; i < N - 1; i++) {
            if (budgets[i] < C / (N - i)) {
                results[i] = budgets[i];
            } else {
                results[i] = C / (N - i);
            }
            C -= results[i];
        }

        if (C <= budgets[N - 1]) {
            results[N - 1] = C;
            for (int i = 0; i < N; i++) {
                System.out.println(results[i]);
            }
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}
