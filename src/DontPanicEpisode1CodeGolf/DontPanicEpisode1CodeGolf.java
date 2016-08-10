package DontPanicEpisode1CodeGolf;
import java.util.*;

public class DontPanicEpisode1CodeGolf {
    public static void main(String a[]) {
        Scanner I = new Scanner(System.in);
        I.nextInt();
        I.nextInt();
        I.nextInt();
        int f = I.nextInt();
        int p = I.nextInt();
        I.nextInt();
        I.nextInt();
        int n = I.nextInt();
        int[] e = new int[n+1];
        e[f] = p;
        for (int i = 0; i < n; i++) {
            int F = I.nextInt();
            int P = I.nextInt();
            e[F] = P;
        }
        int t = 0;
        int N = 0;
        while (true) {
            int F = I.nextInt();
            int P = I.nextInt();
            String d = I.next();
            if (t == F) {
                N = e[F];
                if (d.contains("RIGHT")) {
                    if (P < N) {
                        System.out.println("WAIT");
                    } else if (P > N) {
                        System.out.println("BLOCK");
                    } else {
                        System.out.println("WAIT");
                        t++;
                    }
                } else {
                    if (P > N) {
                        System.out.println("WAIT");
                    } else if (P < N) {
                        System.out.println("BLOCK");
                    } else {
                        System.out.println("WAIT");
                        t++;
                    }
                }
            } else {
                System.out.println("WAIT");
            }
        }
    }
}
