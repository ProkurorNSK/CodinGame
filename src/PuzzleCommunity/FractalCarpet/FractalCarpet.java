package PuzzleCommunity.FractalCarpet;

import java.util.*;

public class FractalCarpet {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        long x1 = in.nextLong();
        long y1 = in.nextLong();
        long x2 = in.nextLong();
        long y2 = in.nextLong();

        char[][] array = new char[(int)Math.pow(3,L)][(int)Math.pow(3,L)];
        array[0][0] = '0';
        for (int i=0; i<L; i++){
            for(int l=0; l<3; l++) {
                for(int m=0; m<3; m++) {
                    if (l==1 && m==1) {
                        fill(array, (int)Math.pow(3,i));
                    } else {
                        copy(array, (int)Math.pow(3,i), l, m);
                    }
                }
            }
        }

        for(long i=y1; i<=y2; i++){
            for(long j=x1; j<=x2; j++){
                System.out.print(array[(int)i][(int)j]);
            }
            System.out.println();
        }
    }

    public static void fill(char[][] array, int lenght) {
        for(int i=0; i<lenght; i++){
            for(int j=0; j<lenght; j++){
                array[i+lenght][j+lenght] = '+';
            }
        }
    }

    public static void copy(char[][] array, int lenght, int l, int m) {
        for(int i=0; i<lenght; i++){
            for(int j=0; j<lenght; j++){
//                System.err.println(lenght + " - " + l + " - " + m);
                array[i+lenght*l][j+lenght*m] = array[i][j];
            }
        }
    }
}
