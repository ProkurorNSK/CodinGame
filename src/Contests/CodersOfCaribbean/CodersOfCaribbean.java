package Contests.CodersOfCaribbean;

import java.util.*;

public class CodersOfCaribbean {
    private static final int WIDE = 23;
    private static final int HIGH = 21;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int xRandom = getRandom(WIDE);
        int yRandom = getRandom(HIGH);
        List<Ship> myShips = new ArrayList<>();
        List<Ship> enemyShips = new ArrayList<>();

        // game loop
        while (true) {
            int myShipCount = in.nextInt(); // the number of remaining ships
            int entityCount = in.nextInt(); // the number of entities (e.g. ships, mines or cannonballs)
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
                            Ship foundEntity = findEntity(myShips, entityId);
                            if (foundEntity == null) {
                                myShips.add(new Ship(entityId, x, y, arg1, arg2, arg3));
                            } else {
                                foundEntity.update(x, y, arg1, arg2, arg3);
                            }
                        } else if (arg4 == 0) {
                            Ship foundEntity = findEntity(enemyShips, entityId);
                            if (foundEntity == null) {
                                enemyShips.add(new Ship(entityId, x, y, arg1, arg2, arg3));
                            } else {
                                foundEntity.update(x, y, arg1, arg2, arg3);
                            }
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

            myShips.removeIf(ship -> !ship.isActive);
            enemyShips.removeIf(ship -> !ship.isActive);

//            System.err.println("myShips " + myShips.size());
//            System.err.println("enemyShips " + enemyShips.size());
//            System.err.print("barrels - " + barrels.size());
//            System.err.print(": balls - " + balls.size());
//            System.err.println(": mines - " + mines.size());

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

                Boolean alarm = false;
                Ship newShip = ship.calculateMove().calculateMove();
                System.err.println(newShip.headShip.x + "-" + newShip.headShip.y);
                System.err.println(newShip.x + "-" + newShip.y);
                System.err.println(newShip.tailShip.x + "-" + newShip.tailShip.y);
                for (Mine mine : mines) {
                    System.err.println(mine.x + "*" + mine.y);
                    if (newShip.isCollision(mine)) {
                        System.err.println("MINE: " + mine.x + "-" + mine.y);
                        alarm = true;
                        break;
                    }
                }

                Ship target = null;
                if (ship.canFire) {
                    for (Ship enemy : enemyShips) {
//                        System.err.println(i + "! distanceToEnemy - " + ship.getDistance(enemy));
                        if (ship.getDistance(enemy) <= 10 && ship.speed == 0) {
                            target = enemy;
                            break;
                        }
                    }
                }

                if (alarm) {
                    System.out.println("SLOWER");
                } else if (target != null) {
                    ship.fire(target);
                } else if (nearestBarrel != null) {
                    ship.move(nearestBarrel);
                } else {
                    if (ship.x == xRandom && ship.y == yRandom) {
                        xRandom = getRandom(WIDE);
                        yRandom = getRandom(HIGH);
                    }
                    ship.move(xRandom, yRandom);
                }
            }
            for (Ship ship : myShips) {
                ship.isActive = false;
            }
            for (Ship ship : enemyShips) {
                ship.isActive = false;
            }
        }

    }

    private static int getRandom(int number) {
        return (int) (Math.random() * number);
    }

    private static Ship findEntity(List<Ship> list, int id) {
        Ship result = null;
        for (Ship entity : list) {
            if (entity.id == id) {
                result = entity;
            }
        }
        return result;
    }

    static class Ship extends Entity {
        int orientation;
        int speed;
        int stockOfRum;
        boolean canFire;
        boolean canSpawn;
        int lastFireTurn;
        int lastSpawnTurn;
        int xPoint;
        int yPoint;
        Entity headShip;
        Entity tailShip;

        Ship(int id, int x, int y, int orientation, int speed, int stockOfRum) {
            super(id, x, y);
            this.orientation = orientation;
            this.speed = speed;
            this.stockOfRum = stockOfRum;
            canFire = true;
            canSpawn = true;
            lastFireTurn = 0;
            lastSpawnTurn = 0;
            xPoint = x;
            yPoint = y;
            headShip = calculateHead();
            tailShip = calculateTail();
        }

        Entity calculateHead() {
            Entity result = null;
            switch (orientation) {
                case 0:
                    result = new Entity(id, x + 1, y);
                    break;
                case 1:
                    result = new Entity(id, x + offset, y - 1);
                    break;
                case 2:
                    result = new Entity(id, x + offset - 1, y - 1);
                    break;
                case 3:
                    result = new Entity(id, x - 1, y);
                    break;
                case 4:
                    result = new Entity(id, x + offset - 1, y + 1);
                    break;
                case 5:
                    result = new Entity(id, x + offset, y + 1);
                    break;
            }
            return result;
        }

        Entity calculateTail() {
            Entity result = null;
            switch (orientation) {
                case 0:
                    result = new Entity(id, x - 1, y);
                    break;
                case 1:
                    result = new Entity(id, x + offset - 1, y + 1);
                    break;
                case 2:
                    result = new Entity(id, x + offset, y + 1);
                    break;
                case 3:
                    result = new Entity(id, x + 1, y);
                    break;
                case 4:
                    result = new Entity(id, x + offset, y - 1);
                    break;
                case 5:
                    result = new Entity(id, x + offset - 1, y - 1);
                    break;
            }
            return result;
        }

        Ship calculateMove() {
            int x = this.x;
            int y = this.y;
            Ship result;
            if (speed != 0) {
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
                result = new Ship(id, x, y, orientation, speed, stockOfRum);
            } else {
                result = new Ship(id, this.x, this.y, orientation, speed, stockOfRum);
            }
            return result;
        }

        void move(int x, int y) {
            if (canSpawn && speed > 0 && x == xPoint && y == yPoint) {
                spawnMine();
            } else {
                System.out.println("MOVE " + x + " " + y);
                xPoint = x;
                yPoint = y;
            }
        }

        void move(Entity entity) {
            move(entity.x, entity.y);
        }

        void update(int x, int y, int orientation, int speed, int stockOfRum) {
            super.update(x, y);
            this.orientation = orientation;
            this.speed = speed;
            this.stockOfRum = stockOfRum;
            if (!canFire && turn - lastFireTurn > 1) {
                canFire = true;
            }
            if (!canSpawn && turn - lastSpawnTurn > 4) {
                canSpawn = true;
            }
            headShip = calculateHead();
            tailShip = calculateTail();
        }

        void fire(Ship target) {
            System.out.println("FIRE " + target.x + " " + target.y);
            canFire = false;
            lastFireTurn = turn;
        }

        void spawnMine() {
            System.out.println("MINE");
            canSpawn = false;
            lastSpawnTurn = turn;
        }

        @Override
        boolean isCollision(Entity entity) {
            return entity.isCollision(this) || headShip.isCollision(entity) || tailShip.isCollision(entity);
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
        int offset;
        int turn;
        boolean isActive;

        Entity(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.turn = 1;
            this.isActive = true;
            offset = this.y % 2;
        }

        void update(int x, int y) {
            this.x = x;
            this.y = y;
            offset = this.y % 2;
            turn++;
            isActive = true;
        }

        double getDistance(Entity entity) {
            return Math.sqrt(Math.pow(entity.x - this.x, 2) + Math.pow(entity.y - this.y, 2));
        }

        boolean isCollision(Entity entity) {
            return this.x == entity.x && this.y == entity.y;
        }
    }
}
