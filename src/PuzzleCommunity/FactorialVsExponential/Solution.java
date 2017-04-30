package PuzzleCommunity.FactorialVsExponential;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int K = in.nextInt();
        for (int i = 0; i < K; i++) {
            float a = in.nextFloat();
            int n = 1;
            Date start = new Date();
            BigDecimal A = new BigDecimal(a);
            while (A.pow(n).compareTo(factFactor(n)) > 0) {
                n++;
            }
            System.out.print((i == 0 ? "" : " ") + n);
            System.err.println("");
            System.err.println("Time - " + ((new Date().getTime()) - start.getTime()));
        }
    }

    private static BigDecimal factNaive(int n) {
        BigDecimal r = new BigDecimal(1);
        for (int i = 2; i <= n; ++i)
            r = r.multiply(new BigDecimal(i));
        return r;
    }

    private static BigDecimal prodTree(int l, int r) {
        if (l > r)
            return new BigDecimal(1);
        if (l == r)
            return new BigDecimal(l);
        if (r - l == 1)
            return new BigDecimal(l * r);
        int m = (l + r) / 2;
        return prodTree(l, m).multiply(prodTree(m + 1, r));
    }

    private static BigDecimal factTree(int n) {
        return prodTree(2, n);
    }

    static BigDecimal factFactor(int n) {

        boolean[] u = new boolean[n + 1]; // маркеры для решета Эратосфена
        HashMap<Integer, Integer> p = new HashMap<>(); // множители и их показатели степеней
        for (int i = 2; i <= n; ++i)
            if (!u[i]) // если i - очередное простое число
            {
                // считаем показатель степени в разложении
                int k = n / i;
                int c = 0;
                while (k > 0) {
                    c += k;
                    k /= i;
                }
                // запоминаем множитель и его показатель степени
                p.put(i, c);
                // просеиваем составные числа через решето
                int j = 2;
                while (i * j <= n) {
                    u[i * j] = true;
                    ++j;
                }
            }
        // вычисляем факториал
        BigDecimal r = new BigDecimal(1);
        for (Map.Entry<Integer, Integer> entry : p.entrySet()) {
            r = r.multiply(new BigDecimal(Math.pow(entry.getKey(), entry.getValue())));
        }
        return r;
    }
}
