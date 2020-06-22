public class Power {
    public static double power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * Math.pow(x, n - 1);
    }
}
