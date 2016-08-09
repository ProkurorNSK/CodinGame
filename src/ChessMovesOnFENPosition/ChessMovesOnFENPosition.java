package ChessMovesOnFENPosition;

import java.util.*;

public class ChessMovesOnFENPosition {

    private static char[][] field = new char[8][8];
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
//        String B = in.nextLine();
        String B = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
//        int N = in.nextInt();
        int N = 1;
//        in.nextLine();
        String[] steps = new String[N];
//        for (int i = 0; i < N; i++) {
//            steps[i] = in.nextLine();
//        }
        steps[0] = "e2e4";

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        read(B);



        System.out.println(write());
    }

    private static void read(String B) {
        String[] lines = B.split("/");
        for (int i = 0; i < lines.length; i++) {
            char[] chars = lines[i].toCharArray();
            int shift = 0;
            for (int j = 0; j < chars.length; j++) {
                if (Character.isDigit(chars[j])) {
                    int length = Integer.parseInt(Character.toString(chars[j]));
                    for (int k = 0; k < length; k++) {
                        field[i][j+shift+k] = '.';
                    }
                    shift += length;
                } else {
                    field[i][j+shift] = chars[j];
                }
            }
        }
    }

    private static String write() {
        String result = "";
        for (int i = 0; i < field.length; i++) {
            int length = 0;
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == '.') {
                    length++;
                    if (j+1 == field[i].length || field[i][j+1] != '.') {
                        result += length;
                    }
                } else {
                    result += field[i][j];
                }
            }
            if (i+1 != field.length) result += "/";
        }
        return result;
    }
}
