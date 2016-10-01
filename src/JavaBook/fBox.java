package JavaBook;


import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class fBox implements Serializable{
    private int width;
    private int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static void main(String[] args) {
        fBox myBox = new fBox();
        myBox.setHeight(20);
        myBox.setWidth(50);

        try {
            FileOutputStream fs = new FileOutputStream("foo.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(myBox);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
