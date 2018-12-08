package Contests.BottersOfTheGalaxy;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Made with love by AntiSquid, Illedan and Wildum.
 * You can help children learn to code while you participate by donating to CoderDojo.
 **/
class Player {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int myTeam = in.nextInt();
        System.err.println("myTeam = " + myTeam);

        int bushAndSpawnPointCount = in.nextInt(); // useful from wood1, represents the number of bushes and the number of places where neutral units can spawn
        System.err.println("bushAndSpawnPointCount = " + bushAndSpawnPointCount);
        for (int i = 0; i < bushAndSpawnPointCount; i++) {
            String entityType = in.next(); // BUSH, from wood1 it can also be SPAWN
            int x = in.nextInt();
            int y = in.nextInt();
            int radius = in.nextInt();
            System.err.println("entityType:x:y:radius = " + entityType + ":" + x + ":" + y + ":" + radius);
        }

        int itemCount = in.nextInt(); // useful from wood2
        System.err.println("itemCount = " + itemCount);
        for (int i = 0; i < itemCount; i++) {
            String itemName = in.next(); // contains keywords such as BRONZE, SILVER and BLADE, BOOTS connected by "_" to help you sort easier
            int itemCost = in.nextInt(); // BRONZE items have lowest cost, the most expensive items are LEGENDARY
            int damage = in.nextInt(); // keyword BLADE is present if the most important item stat is damage
            int health = in.nextInt();
            int maxHealth = in.nextInt();
            int mana = in.nextInt();
            int maxMana = in.nextInt();
            int moveSpeed = in.nextInt(); // keyword BOOTS is present if the most important item stat is moveSpeed
            int manaRegeneration = in.nextInt();
            int isPotion = in.nextInt(); // 0 if it's not instantly consumed
            System.err.println("itemName:itemCost:damage:health:maxHealth:mana:maxMana:moveSpeed:manaRegeneration:isPotion = " + itemName + ":" + itemCost + ":" + damage + ":" + health + ":" + maxHealth + ":" + mana + ":" + maxMana + ":" + moveSpeed + ":" + manaRegeneration + ":" + isPotion);
        }

        // game loop
        while (true) {
            int targetPoint = 0;
            int targetId = 0;
            int heroX = 0;
            int heroY = 0;
            int minDistance = Integer.MAX_VALUE;

            int gold = in.nextInt();
//            System.err.println("gold = " + gold);
            int enemyGold = in.nextInt();
//            System.err.println("enemyGold = " + enemyGold);
            int roundType = in.nextInt(); // a positive value will show the number of heroes that await a command
//            System.err.println("roundType = " + roundType);
            int entityCount = in.nextInt();
            System.err.println("entityCount = " + entityCount);
            for (int i = 0; i < entityCount; i++) {
                int unitId = in.nextInt();
                int team = in.nextInt();
                String unitType = in.next(); // UNIT, HERO, TOWER, can also be GROOT from wood1
                int x = in.nextInt();
                int y = in.nextInt();
                int attackRange = in.nextInt();
                int health = in.nextInt();
                int maxHealth = in.nextInt();
                int shield = in.nextInt(); // useful in bronze
                int attackDamage = in.nextInt();
                int movementSpeed = in.nextInt();
                int stunDuration = in.nextInt(); // useful in bronze
                int goldValue = in.nextInt();
                int countDown1 = in.nextInt(); // all countDown and mana variables are useful starting in bronze
                int countDown2 = in.nextInt();
                int countDown3 = in.nextInt();
                int mana = in.nextInt();
                int maxMana = in.nextInt();
                int manaRegeneration = in.nextInt();
                String heroType = in.next(); // DEADPOOL, VALKYRIE, DOCTOR_STRANGE, HULK, IRONMAN
                int isVisible = in.nextInt(); // 0 if it isn't
                int itemsOwned = in.nextInt(); // useful from wood1
                System.err.println("unitId:team:unitType:x:y:attackRange:health:maxHealth:shield:attackDamage:movementSpeed:stunDuration:goldValue = " + unitId + ":" + team + ":" + unitType + ":" + x + ":" + y + ":" + attackRange + ":" + health + ":" + maxHealth + ":" + shield + ":" + attackDamage + ":" + movementSpeed + ":" + stunDuration + ":" + goldValue);
                if (unitType.equals("HERO")) {
                    System.err.println("countDown1:countDown2:countDown3:mana:maxMana:manaRegeneration:heroType:isVisible:itemsOwned = " + countDown1 + ":" + countDown2 + ":" + countDown3 + ":" + mana + ":" + maxMana + ":" + manaRegeneration + ":" + heroType + ":" + isVisible + ":" + itemsOwned);
                }
                if (team == myTeam && unitType.equals("TOWER")) {
                    targetPoint = x;
                } else if (team == myTeam && unitType.equals("UNIT")) {
                    if (targetPoint < x) {
                        targetPoint = x - 50;
                    }
                } else if (team == myTeam && unitType.equals("HERO")) {
                    heroX = x;
                    heroY = y;
                } else if (team != myTeam) {
                    int distance = (heroX-x)*(heroX-x) + (heroY-y)*(heroY-y);
                    if (distance < minDistance) {
                        minDistance = distance;
                        targetId = unitId;
                    }
                }
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // If roundType has a negative value then you need to output a Hero name, such as "DEADPOOL" or "VALKYRIE".
            // Else you need to output roundType number of any valid action, such as "WAIT" or "ATTACK unitId"
            if (roundType < 0) {
                System.out.println("IRONMAN");
            } else {
                System.out.println("MOVE_ATTACK " + targetPoint + " 540 " + targetId);
            }
        }
    }
}