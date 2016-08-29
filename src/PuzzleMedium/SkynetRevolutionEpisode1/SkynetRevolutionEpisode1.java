package PuzzleMedium.SkynetRevolutionEpisode1;

import java.util.Scanner;

public class SkynetRevolutionEpisode1 {

    private  static int[] exits;
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways
        System.err.print(N + " " + L + " " + E);

        int[][] links = new int[L][2];
        exits = new int[E];
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            links[i][0] = N1;
            links[i][1] = N2;
        }
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            exits[i] = EI;
        }

        // game loop
        while (true) {
            int SI = in.nextInt();
            boolean flag = true;

            for (int[] line: links) {
                if ((line[0] == SI && isExit(line[1])) || (line[1] == SI && isExit(line[0]))) {
                    System.out.println(line[0] + " " + line[1]);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (int[] line: links) {
                    if (line[0] == SI || line[1] == SI) {
                        System.out.println(line[0] + " " + line[1]);
                        break;
                    }
                }
            }
        }
    }

    static boolean isExit(int point) {
        boolean result = false;
        for (int exit: exits) {
            if (exit == point) {
                result = true;
            }
        }
        return result;
    }
}
