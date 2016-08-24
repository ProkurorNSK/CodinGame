package PuzzleCommunity.HeartOfTheCity;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactorsEffective {
    public static List<Integer> primeFactors(int numbers) {
        int n = numbers;
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }

    public static void main(String[] args) {
        System.out.println("Primefactors of 44");
        primeFactors(44).forEach(System.out::println);
        System.out.println("Primefactors of 3");
        primeFactors(3).forEach(System.out::println);
        System.out.println("Primefactors of 32");
        primeFactors(32).forEach(System.out::println);
    }
}
