package PuzzleMedium.Scrabble;

import java.util.*;

public class Scrabble {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String[] words = new String[N];
        ArrayList<String> answer = new ArrayList<>(0);

        for (int i = 0; i < N; i++) {
            words[i] = in.nextLine();
        }
        String letters = in.nextLine();

        for (int i = 0; i < N; i++) {
            String word = words[i];
            boolean isAnswer = true;
            for (int j = 0; j < word.length(); j++) {
                if (!letters.contains(word.substring(j,j+1))) {
                    isAnswer = false;
                    break;
                }
            }
            if (isAnswer) {
                answer.add(word);
                System.out.println(word);
            }
        }
    }
}
