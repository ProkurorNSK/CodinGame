package PuzzleEasy.ASCIIArt;

import java.util.Scanner;

public class ASCIIArt {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        in.nextLine();
        String T = in.nextLine();

        String[] ROW = new String[H];
        for (int i = 0; i < H; i++) {
            ROW[i] = in.nextLine();
        }

//        System.err.println(L);
//        System.err.println(H);
//        System.err.println(T);
//        for (int i = 0; i < H; i++) {
//            System.err.println(ROW[i]);
//        }

        char[] charArray = T.toUpperCase().toCharArray();
        int[] indexAray = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            indexAray[i] = ((int) charArray[i] - 65 < 0 || (int) charArray[i] - 65 > 25) ? 26 : (int) charArray[i] - 65;
        }
        for (int i = 0; i < indexAray.length; i++) {
            System.out.println(indexAray[i]);
        }

        String[] result = new String[H];
        char[] symbol = new char[L];

        for (int i = 0; i < H; i++) {
            result[i] = "";
            for (int j = 0; j < indexAray.length; j++) {
                ROW[i].getChars(indexAray[j]*L, (indexAray[j] + 1) *L, symbol, 0);
                result[i] = result[i] + new String(symbol);
            }
        }


        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        for (int i = 0; i < H; i++) {
            System.out.println(result[i]);
        }
    }
}