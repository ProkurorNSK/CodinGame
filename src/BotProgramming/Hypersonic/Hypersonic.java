package BotProgramming.Hypersonic;

import java.util.*;

public class Hypersonic {
    private static int[][] map;
    private static int xI;
    private static int yI;
    private static int xE;
    private static int yE;
    private static int countBomb;
    private static int range;
    private static final ArrayList<int[]> cells = new ArrayList<>();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
//        int width = in.nextInt();
        int width = 13;
//        int height = in.nextInt();
        int height = 11;
        int myId = in.nextInt();
        map = new int[height][width];
//        in.nextLine();

        while (true) {
            for (int i = 0; i < height; i++) {
                char[] row = in.nextLine().toCharArray();
                for (int j = 0; j < row.length; j++) {
                    if (row[j] == '.') {
                        map[i][j] = 0;
                    } else if (row[j] == '0') {
                        map[i][j] = 10;
                    } else if (row[j] == '1') {
                        map[i][j] = 11;
                    } else if (row[j] == '2') {
                        map[i][j] = 12;
                    } else if (row[j] == 'X') {
                        map[i][j] = 13;
                    }
                }
            }

            int entities = in.nextInt();
            for (int i = 0; i < entities; i++) {
                int entityType = in.nextInt();
                int owner = in.nextInt();
                int x = in.nextInt();
                int y = in.nextInt();
                int param1 = in.nextInt();
                int param2 = in.nextInt();
                if (entityType == 0 && owner == myId) {
                    xI = x;
                    yI = y;
                    countBomb = param1;
                    range = param2;
                }else if (entityType == 0) {
                    xE = x;
                    yE = y;
                }else if (entityType == 1 && owner == myId) {
                    map[y][x] = 8;
                }else if (entityType == 1) {
                    map[y][x] = 7;
                }
            }
            in.nextLine();

            cells.clear();
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    calculateEfficiency(i, j);
                }
            }
            cells.sort(new CellsCompare());

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    System.err.print(map[i][j]);
                }
                System.err.println("");
            }

            System.err.println("X = " + xI + ", Y = " + yI + ", Bombs = " + countBomb);
            for (int[] cell : cells) {
                System.err.println(cell[0] + " " + cell[1] + " " + cell[2] + " " + cell[3]);
            }

            if (xI == cells.get(0)[2] && yI == cells.get(0)[3] && countBomb > 0) {
                System.out.println("BOMB " + cells.get(1)[2] + " " + cells.get(1)[3] + " X" + cells.get(1)[2] + "Y" + cells.get(1)[3] + "B" + cells.get(1)[0]);
            } else {
                System.out.println("MOVE " + cells.get(0)[2] + " " + cells.get(0)[3] + " X" + cells.get(0)[2] + "Y" + cells.get(0)[3] + "M" + cells.get(0)[0]);
            }
        }
    }

    private static void calculateEfficiency(int y, int x) {
        if (map[y][x] < 7) {
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
            int distance = Math.abs(x - xI) + Math.abs(y - yI);
            cells.add(new int[]{result, distance, x, y});
        }
    }
}

class CellsCompare implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        int result;

        if (o1[0] > o2[0])
            result = -1;
        else if (o1[0] < o2[0])
            result = 1;
        else {
            if (o1[1] > o2[1])
                result = 1;
            else if (o1[1] < o2[1])
                result = -1;
            else
                result = 0;
        }

        return result;
    }
}