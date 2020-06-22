public class Findsum {
    static int findsum(int a[], int n) {
        if (n == 1) {
            return a[0];
        }
        return (findsum(a, n - 1) + a[n - 1]);
    }
}
