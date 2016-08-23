package PuzzleEasy.Temperatures;

import java.util.*;

public class Temperatures{
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        in.nextLine();
        String temps = in.nextLine(); // the n temperatures expressed as integers ranging from -273 to 5526

        if (n == 0) {
            System.out.println(0);
        } else {
            String[] tempsArray = temps.split(" ");
            int min = Integer.parseInt(tempsArray[0]);

            for (int i = 1; i < tempsArray.length; i++) {
                if (Math.abs(Integer.parseInt(tempsArray[i])) < Math.abs(min)) {
                    min = Integer.parseInt(tempsArray[i]);
                } else if (Math.abs(Integer.parseInt(tempsArray[i])) == Math.abs(min) && Integer.parseInt(tempsArray[i]) > 0) {
                    min = Integer.parseInt(tempsArray[i]);
                }
            }
            System.out.println(min);
        }
    }
}
