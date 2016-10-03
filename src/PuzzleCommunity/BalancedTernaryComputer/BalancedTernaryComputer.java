package PuzzleCommunity.BalancedTernaryComputer;

import java.util.*;

public class BalancedTernaryComputer {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int DEC = in.nextInt();

        boolean isNegative = (DEC < 0);
        DEC = Math.abs(DEC);

        String result = "";
        do {
            int modulo = DEC % 3;
            DEC = DEC / 3;
            switch (modulo) {
                case 0:
                    result = "0" + result;
                    break;
                case 1:
                    result = (isNegative ? "T" : "1") + result;
                    break;
                case 2:
                    result = (isNegative ? "1" : "T") + result;
                    DEC++;
                    break;
            }
        } while (DEC != 0);

        System.out.println(result);
    }
}
