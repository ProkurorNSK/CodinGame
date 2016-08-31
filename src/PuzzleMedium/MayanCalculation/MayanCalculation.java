package PuzzleMedium.MayanCalculation;

import java.util.*;

public class MayanCalculation {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        char[][][] alphabet = new char[20][H][L];
        for (int i = 0; i < H; i++) {
            char[] numeral = in.next().toCharArray();
            for (int j = 0; j < 20; j++) {
                System.arraycopy(numeral, j * L, alphabet[j][i], 0, L);
            }
        }
        long number1 = getNumber(in.nextInt(), in, H, L, alphabet);
        long number2 = getNumber(in.nextInt(), in, H, L, alphabet);

        String operation = in.next();
        ArrayList<Integer> result = null;
        switch (operation) {
            case "+":
                result = revers(number1 + number2);
                break;
            case "-":
                result = revers(number1 - number2);
                break;
            case "*":
                result = revers(number1 * number2);
                break;
            case "/":
                result = revers(number1 / number2);
                break;
        }

        for (int index : result) {
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < L; j++) {
                    System.out.print(alphabet[index][i][j]);
                }
                System.out.println();
            }
        }
    }

    private static long getNumber(int S, Scanner in, int H, int L, char[][][] alphabet) {
        char[][] number = new char[H][L];
        int[] num1 = new int[S / H];
        for (int i = 0; i < S; i++) {
            System.arraycopy(in.next().toCharArray(), 0, number[i % H], 0, L);
            if ((H == 1 || i != 0) && i % H == L - 1) {
                for (int j = 0; j < 20; j++) {
                    if (isEquals(number, alphabet[j])) {
                        num1[i / H] = j;
                    }
                }
            }
        }
        return convert(num1);
    }

    private static long convert(int[] num) {
        long result = 0;
        for (int i = 0; i < num.length; i++) {
            result += num[i] * Math.pow(20, num.length - 1 - i);
        }
        return result;
    }

    private static ArrayList<Integer> revers(long num) {
        ArrayList<Integer> result = new ArrayList<>(0);
        long modulo;
        while (num >= 20) {
            modulo = num % 20;
            result.add((int) modulo);
            num = (num - modulo) / 20;
        }
        result.add((int) num);
        Collections.reverse(result);
        return result;
    }

    private static boolean isEquals(char[][] a1, char[][] a2) {
        boolean result = true;
        for (int i = 0; i < a1.length; i++) {
            for (int j = 0; j < a1[i].length; j++) {
                if (a1[i][j] != a2[i][j]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
