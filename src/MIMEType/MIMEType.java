package MIMEType;

import java.util.*;

public class MIMEType {
    public static void main(String args[]) {
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt(); // Number of elements which make up the association table.
        int N = 3;
        int Q = 4;
//        int Q = in.nextInt(); // Number Q of file names to be analyzed.

        String[] listExtension = new String[N];
        listExtension[0] = "html";
        listExtension[1] = "png";
        listExtension[2] = "txt";
        String[] listType = new String[N];
        listType[0] = "text/html";
        listType[1] = "image/png";
        listType[2] = "word";
//        for (int i = 0; i < N; i++) {
//            String EXT = in.next(); // file extension
//            listExtension[i] = EXT;
//            String MT = in.next(); // MIME type.
//            listType[i] = MT;
//        }
//        in.nextLine();
        String[] listFileName = new String[Q];
        listFileName[0] = "Temperatures.html";
        listFileName[1] = "no";
        listFileName[2] = "portrait.png";
        listFileName[3] = "doc.TXT";
//        for (int i = 0; i < Q; i++) {
//            String FNAME = in.nextLine(); // One file name per line.
//            listFileName[i] = FNAME;
//        }


        System.err.println(N);
        System.err.println(Q);
        for (int i = 0; i < N; i++) {
            System.err.println(listExtension[i] + "   " + listType[i]);
        }

        for (int i = 0; i < Q; i++) {
            System.err.println(listFileName[i]);
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        int dotPosition;
        String extension;
        int indexType;
        for (int i = 0; i < Q; i++) {
            indexType = -1;
            dotPosition = listFileName[i].lastIndexOf('.');

            if (dotPosition >= 0) {
                extension = listFileName[i].substring(dotPosition+1).toLowerCase();
                for (int j = 0; j < N; j++) {
                    if (extension.equals(listExtension[j].toLowerCase())) {
                            indexType = j;
                        break;
                    }
                }

                if (indexType >= 0) {
                    System.out.println(listType[indexType]);
                } else {
                    System.out.println("UNKNOWN");
                }
            } else {
                System.out.println("UNKNOWN");
            }
        }
    }
}
