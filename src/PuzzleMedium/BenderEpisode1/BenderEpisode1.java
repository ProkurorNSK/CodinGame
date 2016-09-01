package PuzzleMedium.BenderEpisode1;

import java.util.*;

public class BenderEpisode1 {
    private static char lastSymbol = ' ';
    private static char[][] map;
    private static int[] currentPosition = new int[2];
    private static int currentDirection = 1; //1-SOUTH; 2-EAST; 3-NORTH; 4-WEST
    private static int[] shift;
    private static boolean breakerMode = false;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int C = in.nextInt();
        in.nextLine();
        map = new char[C][L];
        shift = new int[2];

        for (int i = 0; i < L; i++) {
            String str = in.nextLine();
            if (str.indexOf('@') != -1) {
                currentPosition[0] = str.indexOf('@');
                currentPosition[1] = i;
            }
            System.arraycopy(str.toCharArray(), 0, map[i], 0, L);
        }

        boolean endGame = false;
        while (!endGame) {

            getDirection();
            getShift();

            switch (map[currentPosition[1] + shift[1]][currentPosition[0] + shift[0]]) {
                case '$':
                    endGame = true;
                    makeMove();
                    break;
                case ' ': case 'X':
                    makeMove();
                    break;
                case 'S':
                    getShift();
                    makeMove();
                    currentDirection = 1;
                    break;
                case 'E':
                    getShift();
                    makeMove();
                    currentDirection = 2;
                    break;
                case 'N':
                    getShift();
                    makeMove();
                    currentDirection = 3;
                    break;
                case 'W':
                    getShift();
                    makeMove();
                    currentDirection = 4;
                    break;
                case 'B':
                    breakerMode = breakerMode ? false : true;
                    makeMove();
                    break;
            }

            printMap();
            in.nextLine();
//            System.out.println(currentPosition[0] + " " + currentPosition[1] + " " + currentDirection);
        }
    }

    private static void print() {
        switch (currentDirection) {
            case 1:
                System.out.println("SOUTH");
                break;
            case 2:
                System.out.println("EAST");
                break;
            case 3:
                System.out.println("NORTH");
                break;
            case 4:
                System.out.println("WEST");
                break;
        }
    }

    private static void makeMove() {
        map[currentPosition[1]][currentPosition[0]] = (lastSymbol == 'X' || lastSymbol == 'B') ? ' ' : lastSymbol;
        currentPosition[0] += shift[0];
        currentPosition[1] += shift[1];
        lastSymbol = map[currentPosition[1]][currentPosition[0]];
        map[currentPosition[1]][currentPosition[0]] = '@';
        print();
    }

    private static void getDirection() {
        getShift();
        char nextField = map[currentPosition[1] + shift[1]][currentPosition[0] + shift[0]];
        if (nextField == '#' || (nextField == 'X' && !breakerMode)) {
            for (int i = 1; i < 5; i++) {
                currentDirection = i;
                getShift();
                nextField = map[currentPosition[1] + shift[1]][currentPosition[0] + shift[0]];
                if (nextField != '#' && nextField != 'X') {
                    break;
                }
            }
        }
    }

    private static void getShift() {
        switch (currentDirection) {
            case 1:
                shift[0] = 0;
                shift[1] = 1;
                break;
            case 2:
                shift[0] = 1;
                shift[1] = 0;
                break;
            case 3:
                shift[0] = 0;
                shift[1] = -1;
                break;
            case 4:
                shift[0] = -1;
                shift[1] = 0;
                break;
        }
    }

    private static void printMap() {
        for (char[] stringMap : map) {
            for (char symbolMap : stringMap) {
                System.out.print(symbolMap);
            }
            System.out.println();
        }
    }
}
