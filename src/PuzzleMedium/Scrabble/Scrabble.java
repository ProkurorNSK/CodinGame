package PuzzleMedium.Scrabble;

import java.util.*;

public class Scrabble {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String[] words = new String[N];
        ArrayList<String> answers = new ArrayList<>(0);

        for (int i = 0; i < N; i++) {
            words[i] = in.nextLine();
        }
        String letters = in.nextLine();

        for (int i = 0; i < N; i++) {
            String word = words[i];
            String buffer = letters;
            boolean isAnswer = true;
            for (int j = 0; j < word.length(); j++) {
                if (!buffer.contains(word.substring(j,j+1))) {
                    isAnswer = false;
                    break;
                } else {
                    buffer = buffer.replaceFirst(word.substring(j,j+1), "#");
                }
            }
            if (isAnswer) {
                answers.add(word);
//                System.out.println(word);
            }
        }
        int maxPoint = 0;
        int iTarget = 0;
        for (int i = 0; i < answers.size(); i++) {
            if (calculatePoint(answers.get(i)) > maxPoint) {
                maxPoint = calculatePoint(answers.get(i));
                iTarget = i;
            }
        }
        System.out.println(answers.get(iTarget));
    }
    private static int calculatePoint(String word) {
        int result = 0;
        for (int i = 0; i < word.length(); i++) {
            switch (word.charAt(i)) {
                case 'e': case 'a': case 'i': case 'o': case 'n': case 'r': case 't': case 'l': case 's': case 'u':
                    result += 1;
                    break;
                case 'd': case 'g':
                    result += 2;
                    break;
                case 'b': case 'c': case 'm': case 'p':
                    result += 3;
                    break;
                case 'f': case 'h': case 'v': case 'w': case 'y':
                    result += 4;
                    break;
                case 'k':
                    result += 5;
                    break;
                case 'j': case 'x':
                    result += 8;
                    break;
                case 'q': case 'z':
                    result += 10;
                    break;
            }
        }
        return result;
    }
}
