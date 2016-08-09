package PowerOfThor;
import java.util.*;
public class PowerOfThor {
    public static void main(String a[]){
        Scanner i=new Scanner(System.in);
        int LX = i.nextInt();
        int LY = i.nextInt();
        int TX = i.nextInt();
        int TY = i.nextInt();
        while(true) {
            i.nextInt();
            String p = "";
            if (TY < LY) {
                p += "S";
                TY++;
            }
            if (TY > LY) {
                p += "N";
                TY--;
            }
            if (TX < LX) {
                p += "E";
                TX++;
            }
            if (TX > LX) {
                p += "W";
                TX--;
            }
            System.out.println(p);
        }
    }
}
