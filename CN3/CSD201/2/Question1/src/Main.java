import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner SCANNER = new Scanner(System.in);
        System.out.print("Enter: ");
        int N = SCANNER.nextInt();
        Stack T = new Stack();
        while (N > 0) {
            T.push(N % 2);
            N /= 2;
        }
        T.traverse();
        T.clear();
        T.convert(N);
        T.push(SCANNER.nextInt());
        T.pop();
        T.top();
    }
}
