package PuzzleCommunity.Gravity;

import java.util.*;


/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();
        int height = in.nextInt();
        ArrayList<Character>[] columns = new ArrayList[width];
        for (int i = 0; i < columns.length; i++) {
            columns[i] = new ArrayList<>();
        }

        for (int i = 0; i < height; i++) {
            char[] line = in.next().toCharArray();
            for (int j = 0; j < width; j++) {
                if (line[j] == '#') {
                    columns[j].add('#');
                }
            }
        }

        for (ArrayList<Character> column : columns) {
            while (column.size() < height) {
                column.add('.');
            }
        }

        for (int i = 0; i < height; i++) {
            for (ArrayList<Character> column : columns) {
                System.err.print(column.get(height-i-1));
            }
            System.err.println("");
        }
    }
}