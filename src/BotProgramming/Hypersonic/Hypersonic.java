package BotProgramming.Hypersonic;

import java.util.*;

public class Hypersonic {
    private static int[][] map;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
//        int width = in.nextInt();
        int width = 13;
//        int height = in.nextInt();
        int height = 11;
//        int myId = in.nextInt();
        map = new int[height][width];
//        in.nextLine();

        while (true) {
            for (int i = 0; i < height; i++) {
                char[] row = in.nextLine().toCharArray();
                for (int j = 0; j < row.length; j++) {
                    if (row[j] == '0') {
                        map[i][j] = 9;
                    } else {
                        map[i][j] = 0;
                    }
                }
            }

//            int entities = in.nextInt();
//            for (int i = 0; i < entities; i++) {
//                int entityType = in.nextInt();
//                int owner = in.nextInt();
//                int x = in.nextInt();
//                int y = in.nextInt();
//                int param1 = in.nextInt();
//                int param2 = in.nextInt();
//            }
//            in.nextLine();

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    calculateEfficiency(i, j);
                }
            }

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    System.err.print(map[i][j]);
                }
                System.err.println("");
            }
            System.out.println("BOMB 6 5");
        }
    }

    private static void calculateEfficiency(int y, int x) {
        if (map[y][x] != 9) {
            int result = 0;
            int beginX = Math.max(0, x - 2);
            int beginY = Math.max(0, y - 2);
            int endX = Math.min(map[0].length - 1, x + 2);
            int endY = Math.min(map.length - 1, y + 2);

            for (int i = beginY; i <= endY; i++) {
                if (map[i][x] == 9) result++;
            }
            for (int i = beginX; i <= endX; i++) {
                if (map[y][i] == 9) result++;
            }
            map[y][x] = result;
        }
    }
}
