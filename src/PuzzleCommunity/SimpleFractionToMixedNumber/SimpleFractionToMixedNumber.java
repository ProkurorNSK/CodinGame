package PuzzleCommunity.SimpleFractionToMixedNumber;


public class SimpleFractionToMixedNumber {
    public static void main(String args[]) {
//        Scanner in = new Scanner(System.in);
        int N = 1;

        int[] numerator = new int[N];
        int[] denominator = new int[N];
        numerator[0] = -5;
        denominator[0] = 20;


        for (int i = 0; i < N; i++) {

            if (denominator[i] == 0) {
                System.out.println("DIVISION BY ZERO");
            } else if (numerator[i] == 0) {
                System.out.println("0");
            } else {
                String result = "";
                if ((float)numerator[i]/denominator[i] < 0) {
                    System.err.println("-");
                    result += "-";
                }

                int modulo = numerator[i] % denominator[i];
                int integerPart = (numerator[i] - modulo)/ denominator[i];

                if (integerPart != 0) {
                    result += Math.abs(integerPart) + " ";
                }

                if (modulo != 0) {

                    int x = gcd(modulo, denominator[i]);

                    result += Math.abs(modulo / x) + "/" + Math.abs(denominator[i] / x);
                }

                System.out.println(result.trim());
            }
        }

    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
