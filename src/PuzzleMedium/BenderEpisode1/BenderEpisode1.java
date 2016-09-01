package PuzzleMedium.BenderEpisode1;

import java.util.*;

public class BenderEpisode1 {
    private static char lastSymbol = ' ';
    private static char[][] map;
    private static int[] currentPosition;
    private static int currentDirection = 1; //1-SOUTH; 2-EAST; 3-NORTH; 4-WEST
    private static int[] shift;
    private static boolean breakerMode = false;
    private static boolean reverseMode = false;
    private static HashMap<int[], Integer> steps;
    private static boolean isLoop = false;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int C = in.nextInt();
        in.nextLine();
        map = new char[L][C];
        currentPosition = new int[2];
        shift = new int[2];
        steps = new HashMap<>(0);
        int[][] teleports = new int[2][2];
        int indexTeleport = 0;

        for (int i = 0; i < L; i++) {
            String str = in.nextLine();
            if (str.indexOf('@') != -1) {
                currentPosition[1] = str.indexOf('@');
                currentPosition[0] = i;
            }
            if (str.indexOf('T') != -1) {
                teleports[indexTeleport][1] = str.indexOf('T');
                teleports[indexTeleport][0] = i;
                indexTeleport++;
            }
            System.arraycopy(str.toCharArray(), 0, map[i], 0, C);
        }

        boolean endGame = false;
        while (!endGame && !isLoop) {
            getDirection();
            makeMove();
            switch (lastSymbol) {
                case '$':
                    endGame = true;
                    break;
                case ' ':
                case 'X':
                    break;
                case 'I':
                    reverseMode = !reverseMode;
                    break;
                case 'T':
                    map[currentPosition[0]][currentPosition[1]] = (lastSymbol == 'X') ? ' ' : lastSymbol;
                    if (teleports[0][0] == currentPosition[0] && teleports[0][1] == currentPosition[1]) {
                        currentPosition[0] = teleports[1][0];
                        currentPosition[1] = teleports[1][1];
                    } else {
                        currentPosition[0] = teleports[0][0];
                        currentPosition[1] = teleports[0][1];
                    }
                    lastSymbol = map[currentPosition[0]][currentPosition[1]];
                    map[currentPosition[0]][currentPosition[1]] = '@';
                    break;
                case 'S':
                    currentDirection = 1;
                    break;
                case 'E':
                    currentDirection = 2;
                    break;
                case 'N':
                    currentDirection = 3;
                    break;
                case 'W':
                    currentDirection = 4;
                    break;
                case 'B':
                    breakerMode = !breakerMode;
                    break;
            }
            printMap();
            in.nextLine();
        }
    }

    private static void printResult() {
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
        int[] temp = new int[2];
        System.arraycopy(currentPosition,0, temp, 0, 2);
        steps.put(temp, currentDirection);
        map[currentPosition[0]][currentPosition[1]] = (lastSymbol == 'X') ? ' ' : lastSymbol;
        currentPosition[0] += shift[0];
        currentPosition[1] += shift[1];
        lastSymbol = map[currentPosition[0]][currentPosition[1]];
        map[currentPosition[0]][currentPosition[1]] = '@';
        printResult();
        if (steps.get(currentPosition) == currentDirection) {
            isLoop = true;
        }
    }

    private static void getDirection() {
        getShift();
        char nextField = map[currentPosition[0] + shift[0]][currentPosition[1] + shift[1]];
        if (nextField == '#' || (nextField == 'X' && !breakerMode)) {
            for (int i = 1; i < 5; i++) {
                currentDirection = (reverseMode) ? 5 - i : i;
                getShift();
                nextField = map[currentPosition[0] + shift[0]][currentPosition[1] + shift[1]];
                if (nextField != '#' && nextField != 'X') {
                    break;
                }
            }
        }
    }

    private static void getShift() {
        switch (currentDirection) {
            case 1:
                shift[0] = 1;
                shift[1] = 0;
                break;
            case 2:
                shift[0] = 0;
                shift[1] = 1;
                break;
            case 3:
                shift[0] = -1;
                shift[1] = 0;
                break;
            case 4:
                shift[0] = 0;
                shift[1] = -1;
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
