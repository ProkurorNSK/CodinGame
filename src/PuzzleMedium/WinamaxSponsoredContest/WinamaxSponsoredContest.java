package PuzzleMedium.WinamaxSponsoredContest;

import java.util.*;

public class WinamaxSponsoredContest {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        ArrayList<Integer> player1 = new ArrayList<>(0);
        ArrayList<Integer> player2 = new ArrayList<>(0);
        int numberPlayer1;
        int numberPlayer2;
        int count = 0;

        int n = in.nextInt(); // the number of cards for player 1
        for (int i = 0; i < n; i++) {
            String cardp1 = in.next(); // the n cards of player 1
            player1.add(convert(cardp1.substring(0, cardp1.length() - 1)));
        }
        int m = in.nextInt(); // the number of cards for player 2
        for (int i = 0; i < m; i++) {
            String cardp2 = in.next(); // the m cards of player 2
            player2.add(convert(cardp2.substring(0, cardp2.length() - 1)));
        }

        //noinspection InfiniteLoopStatement
        while (true) {
            numberPlayer1 = player1.remove(0);
            numberPlayer2 = player2.remove(0);
            if (numberPlayer1 > numberPlayer2) {
                player1.add(numberPlayer1);
                player1.add(numberPlayer2);
            } else if (numberPlayer2 > numberPlayer1) {
                player2.add(numberPlayer2);
                player2.add(numberPlayer1);
            } else {
                numberPlayer1 = player1.get(3);
                numberPlayer2 = player2.get(3);
                for (int i = 0; i < 4; i++) {

                }
            }
            count++;
            if (player1.isEmpty()) {
                System.out.println("2 " + count);
                break;
            }
            if (player2.isEmpty()) {
                System.out.println("1 " + count);
                break;
            }
        }
    }

    private static int convert(String card) {
        int result;
        if (card.contains("J")) {
            result = 11;
        } else if (card.contains("Q")) {
            result = 12;
        } else if (card.contains("K")) {
            result = 13;
        } else if (card.contains("A")) {
            result = 14;
        } else {
            result = Integer.parseInt(card);
        }
        return result;
    }
}
