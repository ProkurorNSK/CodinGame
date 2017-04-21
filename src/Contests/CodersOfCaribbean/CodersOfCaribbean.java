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
            List<CannonBall> balls = new ArrayList<>();
            List<Mine> mines = new ArrayList<>();

            for (int i = 0; i < entityCount; i++) {
                int entityId = in.nextInt();
                String entityType = in.next();
                int x = in.nextInt();
                int y = in.nextInt();
                int arg1 = in.nextInt();
                int arg2 = in.nextInt();
                int arg3 = in.nextInt();
                int arg4 = in.nextInt();
                switch (entityType) {
                    case "SHIP":
                        if (arg4 == 1) {
                            myShips.add(new Ship(entityId, x, y, arg1, arg2, arg3));
                        } else if (arg4 == 0) {
                            enemyShips.add(new Ship(entityId, x, y, arg1, arg2, arg3));
                        }
                        break;
                    case "BARREL":
                        barrels.add(new Barrel(entityId, x, y, arg1));
                        break;
                    case "CANNONBALL":
                        balls.add(new CannonBall(entityId, x, y, arg1, arg2));
                        break;
                    case "MINE":
                        mines.add(new Mine(entityId, x, y));
                        break;
                }
            }

//            System.err.println("myShips " + myShips.size());
//            System.err.println("enemyShips " + enemyShips.size());
            System.err.println("barrels " + barrels.size());
            System.err.println("balls " + balls.size());
            System.err.println("mines " + mines.size());

            for (int i = 0; i < myShipCount; i++) {

                Ship ship = myShips.get(i);

                double minDistance = Integer.MAX_VALUE;
                Barrel nearestBarrel = null;
                for (Barrel barrel : barrels) {
                    double distance = ship.getDistance(barrel);
                    if (distance < minDistance) {
                        minDistance = distance;
                        nearestBarrel = barrel;
                    }
                }
//                System.err.println("X " + ship.x);
//                System.err.println("Y " + ship.y);
                System.err.println("minDistance" + minDistance);

                Ship featureShip = ship.move();
                Ship featureShip2 = featureShip.move();
                for (Mine mine : mines) {
                    if (featureShip.isCollision(mine) || featureShip2.isCollision(mine)) {
//                        System.out.println("MOVE " +  + " " + );
                        System.out.println("MOVE 0 0");
                        nearestBarrel = null;
                        break;
                    }
                }

                if (nearestBarrel != null) {
                    System.out.println("MOVE " + nearestBarrel.x + " " + nearestBarrel.y);
                } else {
                    System.out.println("MOVE 11 10");
                }
            }
        }
    }

    static class Ship extends Entity {
        int orientation;
        int speed;
        int stockOfRum;
        private int offset;


        Ship(int id, int x, int y, int orientation, int speed, int stockOfRum) {
            super(id, x, y);
            this.orientation = orientation;
            this.speed = speed;
            this.stockOfRum = stockOfRum;
            this.offset = this.y % 2;
        }

        Ship move() {
            int x = this.x;
            int y = this.y;
            switch (orientation) {
                case 0:
                    x += speed;
                    break;
                case 1:
                    y -= speed;
                    x += speed + offset - 1;
                    break;
                case 2:
                    y -= speed;
                    x -= speed - offset;
                    break;
                case 3:
                    x -= speed;
                    break;
                case 4:
                    y += speed;
                    x -= speed - offset;
                    break;
                case 5:
                    y += speed;
                    x += speed + offset - 1;
                    break;
            }
            return new Ship(0, x, y, orientation, speed, 0);
        }

        @Override
        boolean isCollision(Entity entity) {
            Entity headShip;
            Entity backShip;
            if (this.orientation == 0 || this.orientation == 3) {
                headShip = new Entity(0, this.x - 1, this.y);
                backShip = new Entity(0, this.x + 1, this.y);
            } else if (this.orientation == 1 || this.orientation == 4) {
                headShip = new Entity(0, this.x + offset, this.y - 1);
                backShip = new Entity(0, this.x + offset - 1, this.y + 1);
            } else {
                headShip = new Entity(0, this.x + offset - 1, this.y - 1);
                backShip = new Entity(0, this.x + offset, this.y + 1);
            }
            System.err.println(headShip.x + "-" + headShip.y);
            System.err.println(this.x + "-" + this.y);
            System.err.println(backShip.x + "-" + backShip.y);
            System.err.println(entity.x + "*" + entity.y);
            return entity.isCollision(this) || entity.isCollision(headShip) || entity.isCollision(backShip);
        }
    }

    static class Barrel extends Entity {
        int amountOfRum;

        Barrel(int id, int x, int y, int amountOfRum) {
            super(id, x, y);
            this.amountOfRum = amountOfRum;
        }
    }

    static class CannonBall extends Entity {
        int numberOfTurns;
        int idShip;

        CannonBall(int id, int x, int y, int idShip, int numberOfTurns) {
            super(id, x, y);
            this.idShip = idShip;
            this.numberOfTurns = numberOfTurns;
        }
    }

    static class Mine extends Entity {
        Mine(int id, int x, int y) {
            super(id, x, y);
        }
    }

    static class Entity {
        int id;
        int x;
        int y;

        Entity(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }

        double getDistance(Entity entity) {
            return Math.sqrt(Math.pow(entity.x - this.x, 2) + Math.pow(entity.y - this.y, 2));
        }

        boolean isCollision(Entity entity) {
            return this.x == entity.x && this.y == entity.y;
        }
    }
}
