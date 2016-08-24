package BotProgramming.CodeBusters;

import java.util.*;

public class CodeBusters {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int bustersPerPlayer = in.nextInt(); // the amount of busters you control
        int ghostCount = in.nextInt(); // the amount of ghosts on the map
        int myTeamId = in.nextInt(); // if this is 0, your base is on the top left of the map, if it is one, on the bottom right

        Buster[] arrayBusters = new Buster[bustersPerPlayer];
        Ghost[] arrayGhosts = new Ghost[ghostCount];
        Enemy[] arrayEnemies = new Enemy[bustersPerPlayer];
        int xBase = myTeamId==0 ? 0 : 16000;
        int yBase = myTeamId==0 ? 0 : 9000;

        // game loop
        while (true) {
            int entities = in.nextInt(); // the number of busters and ghosts visible to you
            for (int i = 0; i < Ghost.countGhosts; i++) {
                arrayGhosts[i].isVisible = 0;
            }
            for (int i = 0; i < Enemy.countEnemies; i++) {
                arrayEnemies[i].isVisible = 0;
            }
            for (int i = 0; i < entities; i++) {
                int entityId = in.nextInt(); // buster id or ghost id
                int x = in.nextInt();
                int y = in.nextInt(); // position of this buster / ghost
                int entityType = in.nextInt(); // the team id if it is a buster, -1 if it is a ghost.
                int state = in.nextInt(); // For busters: 0=idle, 1=carrying a ghost.
                int value = in.nextInt(); // For busters: Ghost id being carried. For ghosts: number of busters attempting to trap this ghost.
                if (entityType == -1) {
                    int index = Ghost.findGhosts(entityId, arrayGhosts);
                    if (index == -1) {
                        arrayGhosts[Ghost.countGhosts] = new Ghost(x, y, entityId, state, value);
                    } else {
                        arrayGhosts[index].x = x;
                        arrayGhosts[index].y = y;
                        arrayGhosts[index].value = value;
                        arrayGhosts[index].isVisible = 1;
                    }
                } else if (entityType == myTeamId) {
                    int index = Buster.findBusters(entityId, arrayBusters);
                    if (index == -1) {
                        arrayBusters[Buster.countBusters] = new Buster(x, y, entityId, state, value);
                    } else {
                        arrayBusters[index].x = x;
                        arrayBusters[index].y = y;
                        arrayBusters[index].state = state;
                        arrayBusters[index].value = value;
                    }
                } else {
                    int index = Enemy.findEnemies(entityId, arrayEnemies);
                    if (index == -1) {
                        arrayEnemies[Enemy.countEnemies] = new Enemy(x, y, entityId, state, value);
                    } else {
                        arrayEnemies[index].x = x;
                        arrayEnemies[index].y = y;
                        arrayEnemies[index].state = state;
                        arrayEnemies[index].value = value;
                        arrayEnemies[index].isVisible = 1;
                    }
                }
            }

            for (int i=0; i<Buster.countBusters; i++) {
                System.err.println(arrayBusters[i].id + " - " + arrayBusters[i].state + " - " + arrayBusters[i].isHunting + " - " + arrayBusters[i].indexTarget + " - " + arrayBusters[i].delayStun);
                if (arrayBusters[i].state == 3) {
                    arrayBusters[i].huntGhost(arrayGhosts[arrayBusters[i].indexTarget]);
                } else if (arrayBusters[i].state == 2) {
                    if (arrayBusters[i].indexTarget != -1) {
                        arrayGhosts[arrayBusters[i].indexTarget].isTarget = 0;
                    }
                    arrayBusters[i].isHunting = 0;
                    arrayBusters[i].indexTarget = -1;
                    arrayBusters[i].moveBuster(arrayBusters[i].x, arrayBusters[i].y, " T" + arrayBusters[i].id);
                } else if (arrayBusters[i].state == 1) {
                    arrayBusters[i].moveBase(xBase, yBase);
                } else if (arrayBusters[i].isHunting == 1) {
                    arrayBusters[i].huntGhost(arrayGhosts[arrayBusters[i].indexTarget]);
                } else if (arrayBusters[i].isHunting == 2 && arrayBusters[i].delayStun <= 0) {
                    arrayBusters[i].huntEnemy(arrayEnemies[arrayBusters[i].indexTarget]);
                } else {
                    System.err.println(Ghost.countGhosts + " - " + Enemy.countEnemies);
                    boolean flag = true;
                    for (int j = 0; j < Ghost.countGhosts; j++) {
                        System.err.println(arrayGhosts[j].id + " - " + arrayGhosts[j].isVisible + " - " + arrayGhosts[j].isTarget);
                        if (arrayGhosts[j].isVisible == 1 && (arrayGhosts[j].isTarget == 0 || (arrayGhosts[j].isTarget == 1 && arrayGhosts[j].state > 10))) {
                            arrayGhosts[j].isTarget = 1;
                            arrayBusters[i].isHunting = 1;
                            arrayBusters[i].indexTarget = j;
                            arrayBusters[i].huntGhost(arrayGhosts[arrayBusters[i].indexTarget]);
                            flag = false;
                            break;
                        }
                    }
                    if (flag && arrayBusters[i].delayStun <= 0) {
                        for (int j = 0; j < Enemy.countEnemies; j++) {
                            System.err.println(arrayEnemies[j].id + " - " + arrayEnemies[j].isVisible + " - " + arrayEnemies[j].isTarget);
                            if (arrayEnemies[j].isVisible == 1 && arrayEnemies[j].isTarget == 0 && arrayEnemies[j].state != 2) {
                                arrayEnemies[j].isTarget = 1;
                                arrayBusters[i].isHunting = 2;
                                arrayBusters[i].indexTarget = j;
                                arrayBusters[i].huntEnemy(arrayEnemies[arrayBusters[i].indexTarget]);
                                flag = false;
                                break;
                            }
                        }
                    }
                    if (flag) arrayBusters[i].findGhost();
                    System.err.println(arrayBusters[i].id + " - " + arrayBusters[i].state + " - " + arrayBusters[i].isHunting + " - " + arrayBusters[i].indexTarget + " - " + arrayBusters[i].delayStun);
                }
            }
        }
    }
}

class Buster {
    static int countBusters = 0;
    int x;
    int y;
    final int id;
    int state;
    int value;
    int isHunting;
    int indexTarget;
    private int targetX;
    private int targetY;
    int delayStun;

    Buster(int x, int y, int id, int state, int value) {
        countBusters++;
        this.x = x;
        this.y = y;
        this.id = id;
        this.state = state;
        this.value = value;
        this.isHunting = 0;
        this.indexTarget = -1;
        this.targetX = -1;
        this.targetY = -1;
        this.delayStun = 0;
    }

    static int findBusters(int id, Buster[] arrayBusters) {
        for (int i = 0; i < countBusters; i++) {
            if (arrayBusters[i].id == id) {
                return i;
            }
        }
        return -1;
    }

    void findGhost() {
        Random random = new Random();
        if ((targetX == -1 && targetY == -1) || (targetX == x && targetY == y)) {
            targetX = random.nextInt(16000);
            targetY = random.nextInt(9000);
        }

        this.moveBuster(targetX, targetY, " R" + id);
    }

    void moveBase(int xBase, int yBase) {
        double distance = Math.sqrt((x - xBase)*(x - xBase) + (y - yBase)*(y - yBase));
        System.err.println((x - xBase) + " - " + (y - xBase) + " - " + (int)distance);
        if (distance < 1600) {
            System.out.println("RELEASE");
            delayStun--;
            this.state = 0;
        } else {
            this.moveBuster(xBase, yBase, " B" + id);
        }
    }

    void moveBuster(int x, int y, String message) {
        System.out.println("MOVE " + x + " " + y + message); // MOVE x y | BUST id | RELEASE
        delayStun--;
    }

    void huntGhost(Ghost targetGhost) {
        double distance = Math.sqrt((x - targetGhost.x)*(x - targetGhost.x) + (y - targetGhost.y)*(y - targetGhost.y));
        System.err.println(this.id + " - " + this.value + " - " + targetGhost.id);
        System.err.println(this.x + " - " + this.y + " - " + targetGhost.x + " - " + targetGhost.y);
        System.err.println((x - targetGhost.x) + " - " + (y - targetGhost.y) + " - " + (int)distance);
        if (distance < 1800 && targetGhost.isVisible == 0) {
            this.isHunting = 0;
            this.indexTarget = -1;
            targetGhost.isTarget = 0;
            this.findGhost();
        } else if (distance > 1760) {
            this.moveBuster(targetGhost.x, targetGhost.y, " H" + targetGhost.id);
        } else if (distance > 900) {
            System.out.println("BUST " + targetGhost.id);
            this.delayStun--;
            if (targetGhost.state == 0) {
                this.isHunting = 0;
                this.indexTarget = -1;
                targetGhost.isTarget = 2;
            }
        }else {
            this.moveBuster(this.x, this.y, " S" + targetGhost.id);
        }
    }

    void huntEnemy(Enemy targetEnemy) {
        double distance = Math.sqrt((x - targetEnemy.x)*(x - targetEnemy.x) + (y - targetEnemy.y)*(y - targetEnemy.y));
        System.err.println(this.id + " - " + this.value + " - " + targetEnemy.id);
        System.err.println(this.x + " - " + this.y + " - " + targetEnemy.x + " - " + targetEnemy.y);
        System.err.println((x - targetEnemy.x) + " - " + (y - targetEnemy.y) + " - " + (int)distance);
        if (distance < 1800 && targetEnemy.isVisible == 0) {
            this.isHunting = 0;
            this.indexTarget = -1;
            targetEnemy.isTarget = 0;
            this.findGhost();
        } else if (distance > 1760) {
            this.moveBuster(targetEnemy.x, targetEnemy.y, " E" + targetEnemy.id);
        } else {
            System.out.println("STUN " + targetEnemy.id);
            this.delayStun = 20;
            this.isHunting = 0;
            this.indexTarget = -1;
            targetEnemy.isTarget = 0;
        }
    }
}

class Ghost {
    static int countGhosts = 0;
    int x;
    int y;
    final int id;
    final int state;
    int value;
    int isVisible;
    int isTarget;

    Ghost(int x, int y, int id, int state, int value) {
        countGhosts++;
        this.x = x;
        this.y = y;
        this.id = id;
        this.state = state;
        this.value = value;
        this.isTarget = 0;
        this.isVisible = 1;
    }

    static int findGhosts(int id, Ghost[] arrayGhosts) {
        for (int i = 0; i < countGhosts; i++) {
            if (arrayGhosts[i].id == id) {
                return i;
            }
        }
        return -1;
    }
}

class Enemy {
    static int countEnemies = 0;
    int x;
    int y;
    final int id;
    int state;
    int value;
    int isVisible;
    int isTarget;

    Enemy(int x, int y, int id, int state, int value) {
        countEnemies++;
        this.x = x;
        this.y = y;
        this.id = id;
        this.state = state;
        this.value = value;
        this.isTarget = 0;
        this.isVisible = 1;
    }

    static int findEnemies(int id, Enemy[] arrayEnemies) {
        for (int i = 0; i < countEnemies; i++) {
            if (arrayEnemies[i].id == id) {
                return i;
            }
        }
        return -1;
    }
}