package HeartOfTheCity;

public class HeartOfTheCity2 {

    public static int count;
    public static void main(String[] args) {
        FareiSequence(333);
        System.out.println(count);
    }
    public static void FareiSequence(int n)
    {
        System.out.println(0 + "/" + 1);
        FareiSequence(n, 0, 1, 1, 1);
        System.out.println( 1 + "/" + 1);
    }

    private static void FareiSequence(int n, int x, int y, int z, int t)
    {
        int a = x + z, b = y + t;
        if (b <= n)
        {
            FareiSequence(n, x, y, a, b);
            System.out.println(a + "/" + b);
            count++;
            FareiSequence(n, a, b, z, t);
        }
    }
}
