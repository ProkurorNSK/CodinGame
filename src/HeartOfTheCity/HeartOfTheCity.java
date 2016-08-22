package HeartOfTheCity;

public class HeartOfTheCity {
    public static int count;
    public static void main(String args[]) {
//        Scanner in = new Scanner(System.in);
//        long n = in.nextLong();
        long n = 9999999;

        long result = 0;
        for (int i = 1 ; i <= (n-1)/2; i++) {
            result += phi(i);
        }
        System.out.println(result*8);
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
