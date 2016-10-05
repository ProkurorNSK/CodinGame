package JavaBook;

import java.io.*;
import java.net.*;
import java.util.*;


public class MusicServer
{
    private ArrayList clientOutputStreams;

    public static void main(String[] args) {
        new MusicServer().go();
    }

    public class ClientHandler implements Runnable {
        ObjectInputStream in;
        Socket sock;

        public ClientHandler(Socket clientSocket) {
            try {
                sock = clientSocket;
                in = new ObjectInputStream(sock.getInputStream());

            } catch (Exception ex) { ex.printStackTrace(); }
        }

        public void run() {
            Object o1;
            Object o2;
            try {
                while ((o1 = in.readObject()) != null) {
                    o2 = in.readObject();
                    System.out.println("read two objects");
                    tellEveryone(o1, o2);
                }
            } catch (Exception ex) { ex.printStackTrace(); }
        }
    }



    private void go() {
        clientOutputStreams = new ArrayList();
        try {
            ServerSocket serverSock = new ServerSocket(4242);
            while(true) {
                Socket clientSocket = serverSock.accept();
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                clientOutputStreams.add(out);

                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
                System.out.println("got a connection");
            }
        } catch (Exception ex) { ex.printStackTrace(); }
    }

    private void tellEveryone(Object one, Object two) {
        for (Object clientOutputStream : clientOutputStreams) {
            try {
                ObjectOutputStream out = (ObjectOutputStream) clientOutputStream;
                out.writeObject(one);
                out.writeObject(two);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}