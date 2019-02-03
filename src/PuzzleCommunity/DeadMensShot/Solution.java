package PuzzleCommunity.DeadMensShot;

import java.util.*;
import java.io.*;
import java.math.*;

import static java.lang.Math.abs;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Point[] p = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            p[i] = new Point(x, y);
        }
        int M = in.nextInt();
        for (int i = 0; i < M; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            System.out.println(isPointInsidePolygon(p,N,x,y) ? "hit" : "miss");
        }

    }

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean isPointInsidePolygon(Point[] p, int Number, int x, int y) {
        int i1, i2, n, N, S, S1, S2, S3;
        boolean flag;
        N = Number;
        flag = false;
        for (n = 0; n < N; n++) {
            flag = false;
            i1 = n < N - 1 ? n + 1 : 0;
            while (!flag) {
                i2 = i1 + 1;
                if (i2 >= N) {
                    i2 = 0;
                }
                if (i2 == (n < N - 1 ? n + 1 : 0)) {
                    break;
                }
                S = abs(p[i1].x * (p[i2].y - p[n].y) + p[i2].x * (p[n].y - p[i1].y) + p[n].x * (p[i1].y - p[i2].y));
                S1 = abs(p[i1].x * (p[i2].y - y) + p[i2].x * (y - p[i1].y) + x * (p[i1].y - p[i2].y));
                S2 = abs(p[n].x * (p[i2].y - y) + p[i2].x * (y - p[n].y) + x * (p[n].y - p[i2].y));
                S3 = abs(p[i1].x * (p[n].y - y) + p[n].x * (y - p[i1].y) + x * (p[i1].y - p[n].y));
                if (S == S1 + S2 + S3) {
                    flag = true;
                    break;
                }
                i1 = i1 + 1;
                if (i1 >= N) {
                    i1 = 0;
                }
            }
            if (!flag)
                break;
        }
        return flag;
    }
}