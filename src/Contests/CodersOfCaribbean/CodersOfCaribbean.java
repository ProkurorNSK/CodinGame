package Contests.CodersOfCaribbean;

import java.util.*;

public class CodersOfCaribbean {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {
            int myShipCount = in.nextInt(); // the number of remaining ships
            int entityCount = in.nextInt(); // the number of entities (e.g. ships, mines or cannonballs)
            List<Ship> myShips = new ArrayList<>();
            List<Ship> enemyShips = new ArrayList<>();
            List<Barrel> barrels = new ArrayList<>();

            for (int i = 0; i < entityCount; i++) {
                int entityId = in.nextInt();
                String entityType = in.next();
                int x = in.nextInt();
                int y = in.nextInt();
                int arg1 = in.nextInt();
                int arg2 = in.nextInt();
                int arg3 = in.nextInt();
                int arg4 = in.nextInt();
                if (entityType.equals("SHIP")) {
                    if (arg4 == 1) {
                        myShips.add(new Ship(entityId, x, y, arg1, arg2, arg3));
                    } else if (arg4 == 0) {
                        enemyShips.add(new Ship(entityId, x, y, arg1, arg2, arg3));
                    }
                } else if (entityType.equals("BARREL")) {
                    barrels.add(new Barrel(entityId, x, y, arg1));
                }
            }

            System.err.println("myShips " + myShips.size());
            System.err.println("enemyShips " + enemyShips.size());
            System.err.println("barrels " + barrels.size());

            for (int i = 0; i < myShipCount; i++) {

                Ship myShip = myShips.get(i);
                double minDistancePow2 = Integer.MAX_VALUE;
                Barrel nearestBarrel = null;

                for (Barrel barrel : barrels) {
//                    System.err.println("Xb " + barrel.x);
//                    System.err.println("Yb " + barrel.y);
                    double distancePow2 = Math.pow(barrel.x - myShip.x, 2) + Math.pow(barrel.y - myShip.y, 2);
//                    System.err.println("D " + distancePow2);
                    if (distancePow2 < minDistancePow2) {
                        minDistancePow2 = distancePow2;
                        nearestBarrel = barrel;
                    }
                }
                System.err.println("X " + myShip.x);
                System.err.println("Y " + myShip.y);
                System.err.println("minDistance" + Math.sqrt(minDistancePow2));

                if (nearestBarrel != null) {
                    System.out.println("MOVE "+nearestBarrel.x+" "+nearestBarrel.y);
                } else {
                    System.out.println("MOVE 11 10");
                }
            }
        }
    }

    static class Ship {
        int id;
        int x;
        int y;
        int orientation;
        int speed;
        int stockOfRum;

        Ship(int id, int x, int y, int orientation, int speed, int stockOfRum) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.orientation = orientation;
            this.speed = speed;
            this.stockOfRum = stockOfRum;
        }
    }

    static class Barrel {
        int id;
        int x;
        int y;
        int amountOfRum;

        Barrel(int id, int x, int y, int amountOfRum) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.amountOfRum = amountOfRum;
        }
    }
}
