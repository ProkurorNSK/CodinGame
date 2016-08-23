package CodeGolf.TemperaturesCodeGolf;

import java.util.*;

public class TemperaturesCodeGolf{
    public static void main(String a[]){
        Scanner i=new Scanner(System.in);
        int n=i.nextInt();
        i.nextLine();
        String T=i.nextLine();
        int b,r,w;
        if(n==0)
            b=0;
        else{b=99;
            for(String t:T.split(" ")){
                int o=Integer.parseInt(t);
                if(o<0)r=-o;else r=o;
                if(b<0)w=-b;else w=b;
                if(r < w||(r==w && o>0))
                    b=o;
            }
        }
        System.out.println(b);
    }
}
