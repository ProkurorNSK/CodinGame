package PuzzleCommunity.MayTheTriforceBeWithYou;

import java.util.Scanner;

public class MayTheTriforceBeWithYou {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        // int N = in.nextInt();
        int N = 3;

        for (int i = 0; i < N; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < N * 2 - 1 - i; j++) {
                line.append(" ");
            }
            if (i == 0) {
                line = new StringBuilder(line.toString().replaceFirst(" ", "."));
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                line.append("*");
            }
            System.out.println(line);
        }
        for (int i = 0; i < N; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < N - 1 - i; j++) {
                line.append(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                line.append("*");
            }
            for (int j = 0; j < (N - i) * 2 - 1; j++) {
                line.append(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                line.append("*");
            }
            System.out.println(line);
        }
    }
}
