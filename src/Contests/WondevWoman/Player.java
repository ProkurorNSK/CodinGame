package Contests.WondevWoman;

import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int unitsPerPlayer = in.nextInt();
        ArrayList<Action>[] Actions = new ArrayList[unitsPerPlayer];


        // game loop
        while (true) {
            for (int i = 0; i < size; i++) {
                String row = in.next();
            }
            for (int i = 0; i < unitsPerPlayer; i++) {
                int unitX = in.nextInt();
                int unitY = in.nextInt();
            }
            for (int i = 0; i < unitsPerPlayer; i++) {
                int otherX = in.nextInt();
                int otherY = in.nextInt();
            }
            int legalActions = in.nextInt();
            System.err.println(legalActions);

            for (int i = 0; i < unitsPerPlayer; i++) {
                Actions[i] = new ArrayList<>();
            }

            for (int i = 0; i < legalActions; i++) {
                String atype = in.next();
                int index = in.nextInt();
                String dir1 = in.next();
                String dir2 = in.next();
                Actions[index].add(new Action(atype, index, dir1, dir2));
                System.err.println(atype + " " + index + " " + dir1 + " " + dir2);
            }

            for (int i = 0; i < unitsPerPlayer; i++) {
                ArrayList<Action> actionList = Actions[i];
                Action action = actionList.get((int)(Math.random()*actionList.size()));
                System.out.println(action.atype + " " + action.index + " " + action.dir1 + " " + action.dir2);
            }
        }
    }

    static class Action {
        String atype;
        int index;
        String dir1;
        String dir2;

        Action(String atype, int index, String dir1, String dir2) {
            this.atype = atype;
            this.index = index;
            this.dir1 = dir1;
            this.dir2 = dir2;
        }
    }
}