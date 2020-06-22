public class Recursion {
    public Recursion() {
    }

    static double addReciprocals(int n) {
        if (n == 0)
            return 0.0;
        return (1.0 / n) + addReciprocals(n - 1);
    }

    static int bSearch(int a[], int left, int right, int x) {
        if (left > right) return -1;
        int m = (left + right) / 2;
        if (a[m] == x) return m;
        if (a[m] < x) return bSearch(a, m + 1, right, x);
        return bSearch(a, left, m - 1, x);
    }

    static int findPivot(int a[], int left, int right) {
        if (right < left)
            return -1;
        if (right == left)
            return left;
        int mid = (left + right) / 2;
        if (mid < right && a[mid] > a[mid + 1])
            return mid;
        if (mid > left && a[mid] < a[mid - 1])
            return (mid - 1);
        if (a[left] >= a[mid])
            return findPivot(a, left, mid - 1);
        return findPivot(a, mid + 1, right);
    }

    static int pivotBinarySearch(int a[], int n, int x) {
        int pivot = findPivot(a, 0, n - 1);
        if (pivot == -1)
            return bSearch(a, 0, n - 1, x);
        if (a[pivot] == x)
            return pivot;
        if (a[0] <= x)
            return bSearch(a, 0, pivot - 1, x);
        return bSearch(a, pivot + 1, n - 1, x);
    }

    static int Stirling(int n, int k) {
        if (n == 0 && k == 0)
            return 1;
        if (n > 0 && k == 0)
            return 0;
        if (n == k)
            return 1;
        if (k > n)
            return 0;
        int result = k * Stirling(n - 1, k) + Stirling(n - 1, k - 1);
        return result;

    }
}
