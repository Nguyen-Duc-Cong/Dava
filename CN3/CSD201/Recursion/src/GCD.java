public class GCD {
    public static int GCD(int m, int n) {
        if (n == 0) {
            return m;
        }
        return GCD(n, m % n);
    }
}
