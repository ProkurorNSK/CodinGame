package PuzzleCommunity.HeartOfTheCity;

//import java.util.*;

public class HeartOfTheCity2 {
    public static void main(String args[]) {
//        Scanner in = new Scanner(System.in);
//        long n = in.nextLong();
        long n = 999999;
        long time = System.currentTimeMillis();
        long result = 0;
        for (int i = 1 ; i <= (n-1)/2; i++) {
            result += phi(i);
        }
        System.out.println(result*8);
        System.out.println("Время выполнения(мс) - " +  (System.currentTimeMillis() - time));
    }
    private static long phi(int n) {
        long result = n;
        for (int i=2; i*i<=n; ++i) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                result -= result / i;
            }
        }
        if (n > 1) result -= result / n;
        return result;
    }
}
