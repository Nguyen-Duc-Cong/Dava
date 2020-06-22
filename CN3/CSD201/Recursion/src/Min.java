public class Min {
    static int min(int a[], int n) {
        if (n == 1) {
            return a[0];
        }
        int m = min(a, n - 1);
        if (m < a[n - 1]) {
            return m;
        }
        return a[n - 1];
    }
}
