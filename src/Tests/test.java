package Tests;


import java.util.Properties;

public class test {
    public static void main(String[] args) {
        Integer a = 1;
        int s = a.hashCode();
        Class<? extends Number> c = a.getClass();
        System.out.println(c);

        Properties v = System.getProperties();

        System.out.println(a.getClass().getName() + '@' + Integer.toHexString(a.hashCode()));
        System.out.println(a);

        Object O = new Object();
    }
}
