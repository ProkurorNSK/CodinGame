package Optimization.CodeVsZombies;

import java.util.*;

/**
 * Save humans, destroy zombies!
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        Ash ash = new Ash(0, 0);
        List<Human> humans = new ArrayList<>();
        List<Zombie> zombies = new ArrayList<>();
        // game loop
        while (true) {
            int x = in.nextInt();
            int y = in.nextInt();
            ash.update(x, y);

            int humanCount = in.nextInt();
            for (int i = 0; i < humanCount; i++) {
                int humanId = in.nextInt();
                int humanX = in.nextInt();
                int humanY = in.nextInt();

                Human human = Human.findHuman(humans, humanId);
                if (human == null) {
                    human = new Human(humanId, humanX, humanY, ash);
                    humans.add(human);
                } else {
                    human.update(humanX, humanY, ash);
                }
            }

            int zombieCount = in.nextInt();
            for (int i = 0; i < zombieCount; i++) {
                int zombieId = in.nextInt();
                int zombieX = in.nextInt();
                int zombieY = in.nextInt();
                int zombieXNext = in.nextInt();
                int zombieYNext = in.nextInt();

                Zombie zombie = Zombie.findZombie(zombies, zombieId);
                if (zombie == null) {
                    zombies.add(new Zombie(zombieId, zombieX, zombieY, zombieXNext, zombieYNext));
                } else {
                    zombie.update(x, y, zombieXNext, zombieYNext);
                }
            }
            zombies.removeIf(zombie -> !zombie.isActive);
            humans.removeIf(human -> !human.isActive);
            ////////////////////////////////////////
            humans.sort(new humanComparator());
            System.err.println(humans);
            ash.target = humans.get(0);
            ash.run();
            ////////////////////////////////////////
            for (Human human : humans) {
                human.isActive = false;
            }
            for (Zombie zombie : zombies) {
                zombie.isActive = false;
            }
        }
    }

    static class Unit {

        int id;
        int x;
        int y;
        boolean isActive;

        Unit(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
            isActive = true;
        }

        Unit(int x, int y) {
            this.id = 0;
            this.x = x;
            this.y = y;
            isActive = true;
        }

        void update(int x, int y) {
            this.x = x;
            this.y = y;
            isActive = true;
        }

        double getDistance(Unit unit) {
            return Math.sqrt(Math.pow(unit.x - this.x, 2) + Math.pow(unit.y - this.y, 2));
        }

    }

    static class Ash extends Unit {

        Unit target;

        Ash(int x, int y) {
            super(0, x, y);
        }

        void run() {
            System.out.println(target.x + " " + target.y); // Your destination coordinates
        }
    }

    static class Human extends Unit {

        double distanceToAsh;

        Human(int id, int x, int y, Unit unit) {
            super(id, x, y);
            this.distanceToAsh = getDistance(unit);
        }

        void update(int x, int y, Unit unit) {
            super.update(x, y);
            this.distanceToAsh = getDistance(unit);
        }

        static Human findHuman(List<Human> list, int id) {
            Human result = null;
            for (Human entity : list) {
                if (entity.id == id) {
                    result = entity;
                }
            }
            return result;
        }

        @Override
        public String toString() {
            return "(" + id + "-" + x + ":" + y + "-" + (int) distanceToAsh + ")";
        }
    }

    static class Zombie extends Unit {
        int xNext;
        int yNext;
        double distanceToNearestHuman;

        Zombie(int id, int x, int y, int xNext, int yNext) {
            super(id, x, y);
            this.xNext = xNext;
            this.yNext = yNext;
        }

        void update(int x, int y, int xNext, int yNext) {
            this.xNext = xNext;
            this.yNext = yNext;
            super.update(x, y);
        }

        static Zombie findZombie(List<Zombie> list, int id) {
            Zombie result = null;
            for (Zombie entity : list) {
                if (entity.id == id) {
                    result = entity;
                }
            }
            return result;
        }
    }

    static class humanComparator implements Comparator<Human> {
        @Override
        public int compare(Human o1, Human o2) {
            double delta = o1.distanceToAsh - o2.distanceToAsh;
            return delta != 0 ? (int) (delta / Math.abs(delta)) : 0;
        }
    }
}
