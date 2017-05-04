package Optimization.CodeVsZombies;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Save humans, destroy zombies!
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int targetX = 0;
        int targetY = 0;

        Ash ash = null;
        ArrayList<Human> humans = new ArrayList<>();
        ArrayList<Zombie> zombies = new ArrayList<>();
        // game loop
        while (true) {
            int x = in.nextInt();
            int y = in.nextInt();

            int humanCount = in.nextInt();
            for (int i = 0; i < humanCount; i++) {
                int humanId = in.nextInt();
                int humanX = in.nextInt();
                int humanY = in.nextInt();
                targetX = humanX;
                targetY = humanY;
            }
            int zombieCount = in.nextInt();
            for (int i = 0; i < zombieCount; i++) {
                int zombieId = in.nextInt();
                int zombieX = in.nextInt();
                int zombieY = in.nextInt();
                int zombieXNext = in.nextInt();
                int zombieYNext = in.nextInt();
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            System.out.println(targetX + " " + targetY); // Your destination coordinates
        }
    }

    class Unit {
        int id;
        int x;
        int y;

        Unit(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }

        void update(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }
    }

    class Ash extends Unit {
        public Ash(int id, int x, int y) {
            super(id, x, y);
        }
    }

    class Human extends Unit {
        public Human(int id, int x, int y) {
            super(id, x, y);
        }
    }

    class Zombie extends Unit {
        int xNext;
        int yNext;

        public Zombie(int id, int x, int y, int xNext, int yNext) {
            super(id, x, y);
            this.xNext = xNext;
            this.yNext = yNext;
        }

        public void update(int id, int x, int y, int xNext, int yNext) {
            this.xNext = xNext;
            this.yNext = yNext;
            super.update(id, x, y);
        }
    }
}
