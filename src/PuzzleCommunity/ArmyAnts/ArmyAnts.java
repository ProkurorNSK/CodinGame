package PuzzleCommunity.ArmyAnts;

//import java.util.*;

import java.util.Arrays;

public class ArmyAnts {
    public static void main(String args[]) {
//        Scanner in = new Scanner(System.in);
//        int N1 = in.nextInt();
        int N1 = 1;
//        int N2 = in.nextInt();
        int N2 = 5;
//        String S1 = in.next();
        String S1 = "A";
//        String S2 = in.next();
        String S2 = "BCDEF";
//        int T = in.nextInt();
        int T = 3;

        char[] result = new char[N1 + N2];
        int[] team = new int[N1 + N2];
        int[] team2 = new int[N1 + N2];

        char[] symbols = S1.toCharArray();
        for (int i = 0; i < N1; i++) {
            result[i] = symbols[N1 - i - 1];
        }
        symbols = S2.toCharArray();
        System.arraycopy(symbols, 0, result, N1, N2);

        Arrays.fill(team, 0, N1, 1);
        Arrays.fill(team, N1, N1 + N2, 2);
        System.arraycopy(team, 0, team2, 0, N1 + N2);

        for (int i = 1; i <= T; i++) {
//            System.out.println(result);
            for (int j = 0; j < N1 + N2 - 1; j++) {
                if (team[j] == 1 && team[j + 1] == 2) {
                    result = changeSymbols(result, j);
                    team2[j] = 2;
                    team2[j + 1] = 1;
                }
            }
            System.arraycopy(team2, 0, team, 0, N1 + N2);
        }
        System.out.println(result);
    }

    private static char[] changeSymbols(char[] symbols, int i) {
        char symbol = symbols[i];
        symbols[i] = symbols[i + 1];
        symbols[i + 1] = symbol;
        return symbols;
    }
}
