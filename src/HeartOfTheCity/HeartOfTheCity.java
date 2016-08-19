package HeartOfTheCity;

import java.util.*;

public class HeartOfTheCity {
    public static int count;
    public static void main(String args[]) {
//        Scanner in = new Scanner(System.in);
//        long n = in.nextLong();
        long n = 17966;
        FareiSequence((int)(n-1)/2);
        System.out.println((count+1) * 8);
        System.out.println(count);
    }
    public static void FareiSequence(int n)
    {
        FareiSequence(n, 0, 1, 1, 1);
    }
    private static void FareiSequence(int n, int x, int y, int z, int t)
    {
        int a = x + z, b = y + t;
        if (b <= n)
        {
            FareiSequence(n, x, y, a, b);
            FareiSequence(n, a, b, z, t);
            count++;
        }
    }
}
