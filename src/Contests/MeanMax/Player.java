package Contests.MeanMax;

import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);


        // game loop
        while (true) {
            Reaper reaper = new Reaper(-1, 0, -1, -1, -1, -1, -1, -1, -1, -1);
            Destroyer destroyer = new Destroyer(-1, 0, -1, -1, -1, -1, -1, -1, -1, -1);
            Doof doof = new Doof(-1, 0, -1, -1, -1, -1, -1, -1, -1, -1);
            List<Unit> wrecks = new ArrayList<>();
            List<Unit> tankers = new ArrayList<>();

            int myScore = in.nextInt();
            int enemyScore1 = in.nextInt();
            int enemyScore2 = in.nextInt();
            int myRage = in.nextInt();
            int enemyRage1 = in.nextInt();
            int enemyRage2 = in.nextInt();
            int unitCount = in.nextInt();

            for (int i = 0; i < unitCount; i++) {
                int unitId = in.nextInt();
                int unitType = in.nextInt();
                int player = in.nextInt();
                float mass = in.nextFloat();
                int radius = in.nextInt();
                int x = in.nextInt();
                int y = in.nextInt();
                int vx = in.nextInt();
                int vy = in.nextInt();
                int extra = in.nextInt();
                int extra2 = in.nextInt();

                switch (unitType) {
                    case 0:
                        if (player == 0) {
                            reaper = new Reaper(unitId, player, (int) mass, radius, x, y, vx, vy, extra, extra2);
                        }
                        break;
                    case 1:
                        if (player == 0) {
                            destroyer = new Destroyer(unitId, player, (int) mass, radius, x, y, vx, vy, extra, extra2);
                        }
                        break;
                    case 2:
                        if (player == 0) {
                            doof = new Doof(unitId, player, (int) mass, radius, x, y, vx, vy, extra, extra2);
                        }
                        break;
                    case 3:
                        tankers.add(new Tanker(unitId, player, (int) mass, radius, x, y, vx, vy, extra, extra2));
                        break;
                    case 4:
                        wrecks.add(new Wreck(unitId, player, (int) mass, radius, x, y, vx, vy, extra, extra2));
                        break;
                }
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            reaper.printUnit();
            destroyer.printUnit();
            doof.printUnit();
            tankers.forEach(Unit::printUnit);
            wrecks.forEach(Unit::printUnit);

            reaper.action(wrecks);
            destroyer.action(tankers);
            doof.action(tankers);
        }
    }
}

class Unit {
    int unitId;
    //int unitType; //0 (Reaper), 1 (Destroyer), 2 (Doof), 3 (Tanker), 4 (Wreck)
    int playerId; //id of the player for Reapers, Destroyers and Doofs, -1 otherwise
    int mass; //Mass of the unit, -1 for Wrecks
    int radius;
    int x;
    int y;
    int vx;
    int vy;
    int extra; //The quantity of water for Tankers and Wrecks, -1 otherwise
    int extra2; //The water capacity for a Tanker, -1 otherwise

    Unit(int unitId, int playerId, int mass, int radius, int x, int y, int vx, int vy, int extra, int extra2) {
        this.unitId = unitId;
        this.playerId = playerId;
        this.mass = mass;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.extra = extra;
        this.extra2 = extra2;
    }

    public void printUnit() {
        System.err.println("unitId=" + unitId + " playerId=" + playerId + " mass=" + mass + " radius=" + radius + " X=" + x + " Y=" + y + " vX=" + vx + " vY=" + vy + " extra=" + extra + " extra2=" + extra2);
    }

    void action(List<Unit> units) {
        System.out.println("WAIT");
    }

    int calculateDistance(Unit unit) {
        double distance = Math.sqrt((unit.x - this.x) * (unit.x - this.x) + (unit.y - this.y) * (unit.y - this.y));
        return (int) distance;
    }

    void goToUnit(Unit unit) {
        System.out.println(unit.x + " " + unit.y + " 300");
    }
}

class Wreck extends Unit {
    Wreck(int unitId, int playerId, int mass, int radius, int x, int y, int vx, int vy, int extra, int extra2) {
        super(unitId, playerId, mass, radius, x, y, vx, vy, extra, extra2);
    }

    @Override
    public void printUnit() {
        System.err.println("unitId=" + unitId + " radius=" + radius + " X=" + x + " Y=" + y + " extra=" + extra);
    }

}

class Tanker extends Unit {
    Tanker(int unitId, int playerId, int mass, int radius, int x, int y, int vx, int vy, int extra, int extra2) {
        super(unitId, playerId, mass, radius, x, y, vx, vy, extra, extra2);
    }

    @Override
    public void printUnit() {
        System.err.println("unitId=" + unitId + " radius=" + radius + " X=" + x + " Y=" + y + " extra=" + extra + " extra2=" + extra2);
    }

}

class Reaper extends Unit {
    Reaper(int unitId, int playerId, int mass, int radius, int x, int y, int vx, int vy, int extra, int extra2) {
        super(unitId, playerId, mass, radius, x, y, vx, vy, extra, extra2);
    }

    @Override
    public void printUnit() {
        System.err.println("unitId=" + unitId + " playerId=" + playerId + " mass=" + mass + " radius=" + radius + " X=" + x + " Y=" + y + " vX=" + vx + " vY=" + vy);
    }

    @Override
    void action(List<Unit> units) {
        if (!units.isEmpty()) {
            int minDistance = Integer.MAX_VALUE;
            Unit nearestWreck = null;
            for (Unit unit : units) {
                int distance = calculateDistance(unit);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestWreck = unit;
                }
            }

            goToUnit(nearestWreck);
        } else {
            System.out.println("WAIT");
        }
    }
}

class Destroyer extends Unit {
    Destroyer(int unitId, int playerId, int mass, int radius, int x, int y, int vx, int vy, int extra, int extra2) {
        super(unitId, playerId, mass, radius, x, y, vx, vy, extra, extra2);
    }

    @Override
    public void printUnit() {
        System.err.println("unitId=" + unitId + " playerId=" + playerId + " mass=" + mass + " radius=" + radius + " X=" + x + " Y=" + y + " vX=" + vx + " vY=" + vy);
    }

    @Override
    void action(List<Unit> units) {
        if (!units.isEmpty()) {
            int minDistance = Integer.MAX_VALUE;
            Unit nearestTanker = null;
            for (Unit unit : units) {
                int distance = calculateDistance(unit);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestTanker = unit;
                }
            }

            goToUnit(nearestTanker);
        } else {
            System.out.println("WAIT");
        }
    }
}

class Doof extends Unit {
    Doof(int unitId, int playerId, int mass, int radius, int x, int y, int vx, int vy, int extra, int extra2) {
        super(unitId, playerId, mass, radius, x, y, vx, vy, extra, extra2);
    }

    @Override
    public void printUnit() {
        System.err.println("unitId=" + unitId + " playerId=" + playerId + " mass=" + mass + " radius=" + radius + " X=" + x + " Y=" + y + " vX=" + vx + " vY=" + vy);
    }

    @Override
    void action(List<Unit> units) {
        if (!units.isEmpty()) {
            int maxDistance = Integer.MIN_VALUE;
            Unit furtherTanker = null;
            for (Unit unit : units) {
                int distance = calculateDistance(unit);
                if (distance > maxDistance) {
                    maxDistance = distance;
                    furtherTanker = unit;
                }
            }

            goToUnit(furtherTanker);
        } else {
            System.out.println("WAIT");
        }
    }
}