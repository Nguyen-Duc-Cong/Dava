public class Tail {
    static void tail(int n) {
        if (n > 0) {
            System.out.println(n);
            tail(n - 1);
            System.out.println(n);
        }
    }
}
