package Defibrillators;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.*;
import java.io.*;
import java.math.*;

public class Defibrillators {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
//        String LON = in.next();
        String LON = "3,879483";
//        String LAT = in.next();
        String LAT = "43,608177";
//        int N = in.nextInt();
        int N = 3;
//        in.nextLine();
        String[] DEFIB = new String[N];
//        for (int i = 0; i < N; i++) {
//            String DEFIB = in.nextLine();

//        }

        DEFIB[0] = "1;Maison de la Prevention Sante;6 rue Maguelone 340000 Montpellier;;3,87952263361082;43,6071285339217";
        DEFIB[1] = "2;Hotel de Ville;1 place Georges Freche 34267 Montpellier;;3,89652239197876;43,5987299452849";
        DEFIB[2] = "3;Zoo de Lunaret;50 avenue Agropolis 34090 Mtp;;3,87388031141133;43,6395872778854";


        float longitudeUser = Float.parseFloat(LON.replace(',', '.'));
        float latitudeUser = Float.parseFloat(LAT.replace(',', '.'));
        String currentName = "";
        double currentDistance = 0;

        for (int i = 0; i < N; i++) {
            String[] fields = DEFIB[i].split(";");
            double longitude = Float.parseFloat(fields[4].replace(',', '.'));
            double latitude  = Float.parseFloat(fields[5].replace(',', '.'));

            double x = (longitude - longitudeUser) * Math.cos((latitude + latitudeUser)/2);
            double y = (latitude - latitudeUser);
            double distance = Math.sqrt(x * x + y * y) * 6371;


            if (i == 0) {
                currentDistance = distance;
                currentName = fields[1];
            } else {
                if (distance < currentDistance) {
                    currentName = fields[1];
                    currentDistance = distance;
                }
            }
        }

        System.out.println(currentName);
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
    }
}
