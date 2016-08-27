package CodeGolf.PowerOfThorCodeGolf;
import java.util.*;
public class PowerOfThorCodeGolf{
    public static void main(String A[]){
        Scanner I = new Scanner(System.in);
        int a = I.nextInt();
        int b = I.nextInt();
        int x = I.nextInt();
        int y = I.nextInt();

        String c[] = {"S","","N"};
        String d[] = {"E","","W"};

        // game loop
        while (true) {
            int e=(a<x)?1:(x<a)?-1:0;
            int f=(b<y)?1:(y<b)?-1:0;
            String s=c[f+1]+d[e+1];
            x-=e;y-=f;
            System.out.println(s);
        }
    }
}
