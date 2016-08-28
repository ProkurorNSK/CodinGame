package PuzzleMedium.WinamaxSponsoredContest;

import java.util.*;

public class WinamaxSponsoredContest {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        ArrayList<Integer> player1 = new ArrayList<>(0);
        ArrayList<Integer> player2 = new ArrayList<>(0);
        ArrayList<Integer> buffer1 = new ArrayList<>(0);
        ArrayList<Integer> buffer2 = new ArrayList<>(0);
        int countTurn = 0;
        boolean endGame = false;

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
        while (!endGame) {
            endGame = step(player1, player2, 1, countTurn, buffer1, buffer2);
            countTurn++;
        }
    }

    private static boolean step(ArrayList<Integer> player1, ArrayList<Integer> player2, int countCard, int countTurn, ArrayList<Integer> buffer1, ArrayList<Integer> buffer2) {
        if (player1.isEmpty()) {
            System.out.println("2 " + countTurn);
            return true;
        }
        if (player2.isEmpty()) {
            System.out.println("1 " + countTurn);
            return true;
        }
        if (player1.size() < countCard || player2.size() < countCard) {
            System.out.println("PAT");
            return true;
        } else {
            for (int i = 0; i < countCard; i++) {
                buffer1.add(player1.remove(0));
                buffer2.add(player2.remove(0));
            }
        }
        if (buffer1.get(buffer1.size() - 1) > buffer2.get(buffer2.size() - 1)) {
            winTurn(buffer1, buffer2, player1);
        } else if (buffer1.get(buffer1.size() - 1) < buffer2.get(buffer2.size() - 1)) {
            winTurn(buffer1, buffer2, player2);
        } else {
            return step(player1, player2, 4, countTurn, buffer1, buffer2);
        }
        return false;
    }

    private static void winTurn(ArrayList<Integer> buffer1, ArrayList<Integer> buffer2, ArrayList<Integer> player) {
        int size = buffer1.size();
        for (int i = 0; i < size; i++) {
            player.add(buffer1.remove(0));
        }
        for (int i = 0; i < size; i++) {
            player.add(buffer2.remove(0));
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
