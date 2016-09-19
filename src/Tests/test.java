package Tests;


public class test {
    public static void main(String[] args) {
        Integer a = new Integer(1);
        Class<? extends Number> c = a.getClass();
        System.out.println(c);
    }
}
