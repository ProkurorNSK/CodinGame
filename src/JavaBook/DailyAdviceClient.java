package JavaBook;

import java.net.*;
import java.io.*;

public class DailyAdviceClient {
    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }

    private void go() {
        try {
            Socket s = new Socket("127.0.0.1", 4242);
            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            String advice = reader.readLine();
            System.out.println("Сугодня ты должен:" + advice);

            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
