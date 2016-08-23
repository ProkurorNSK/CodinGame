package CodeGolf.DontPanicEpisode1CodeGolf;

import java.util.*;

public class DontPanicEpisode1CodeGolf {
    public static void main(String a[]) {
        Scanner I = new Scanner(System.in);
        I.nextInt();
        I.nextInt();
        I.nextInt();
        int F = I.nextInt();
        int P = I.nextInt();
        I.nextInt();
        I.nextInt();
        int n = I.nextInt();

        int[] e = new int[n+1];
        e[F] = P;
        for (int i = 0; i < n; i++) {
            int f = I.nextInt();
            e[f] = I.nextInt();
        }
        int t = 0;
        while (true) {
            int c = I.nextInt();
            int p = I.nextInt();
            String d = I.next();

            if ((t == c) && ((d.equals("RIGHT") && p > e[c]) || (d.equals("LEFT") && p < e[c]))) {
                System.out.println("BLOCK");
            }else {
                System.out.println("WAIT");
            }
            if (t == c && p == e[c]) t++;
        }
    }
}
