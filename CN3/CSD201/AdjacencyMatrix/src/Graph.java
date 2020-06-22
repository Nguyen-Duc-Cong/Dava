import java.util.ArrayList;
import java.util.Stack;

public class Graph {
    int[][] Adj;
    int n;

    public Graph() {
        // n = 7;
//        Adj = new int[][]{
//                {},
//                {-1, 0, 1, 1, 1, 0, 0, 1},
//                {-1, 1, 0, 1, 0, 1, 0, 0},
//                {-1, 1, 1, 0, 0, 1, 0, 0},
//                {-1, 1, 0, 0, 0, 0, 1, 0},
//                {-1, 0, 1, 1, 0, 0, 1, 1},
//                {-1, 0, 0, 0, 1, 1, 0, 0},
//                {-1, 1, 0, 0, 0, 1, 0, 0}};
        n = 5;
        int INF = Integer.MAX_VALUE;
        Adj = new int[][]{
                {},//dòng 0: bỏ qua.
                {-1, 0, 1, INF, 9, INF},
                {-1, INF, 0, 2, 5, 10},
                {-1, INF, INF, 0, INF, 3},
                {-1, INF, INF, 4, 0, 8},
                {-1, 6, INF, INF, INF, 0}
        };

    }

    int degree(int u) {
        int s = 0;
        for (int i = 1; i <= n; i++) if (Adj[u][i] == 1) s++;
        return s;
    }

    int numedges() {
        int s = 0;
        for (int i = 1; i <= n; i++) s = s + degree(i);
        return s / 2;
    }

    void dfs(int start) {
        Stack<Integer> S = new Stack<>();
        boolean[] Mark = new boolean[n + 1];
        for (int i = 1; i <= n; i++) Mark[i] = false;
        S.push(start);
        while (!S.empty()) {
            int current = S.pop();
            if (Mark[current]) continue;
            Mark[current] = true;
            for (int i = n; i >= 1; i--) {
                if ((!Mark[i]) && (Adj[current][i] == 1)) {
                    S.push(i);
                    //Mark[i] = true;
                }
            }
            System.out.println("->" + (char) (current - 1 + 'A'));
        }
    }

    void display() {
        System.out.printf("\n%3s", " ");
        for (int i = 1; i <= n; i++) System.out.printf("%2c ", (char) (i - 1 + 'A'));

        for (int i = 1; i <= n; i++) {
            System.out.printf("\n%3c", (char) (i - 1 + 'A'));
            for (int j = 1; j <= n; j++) {
                if (Adj[i][j] == Integer.MAX_VALUE) System.out.printf("%3s", "-");
                else System.out.printf("%3d", Adj[i][j]);
            }
        }
    }

    void dijkstra(int s, int E) {
        int[] lable = new int[n + 1];
        int[] Previous = new int[n + 1];

        boolean[] Mark = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            lable[i] = Integer.MAX_VALUE;
            Mark[i] = false;
        }
        lable[s] = 0;
        int current = s;

        while (current != E) {
            System.out.println("Xet" + current);
            Mark[current] = true;
            for (int i = 1; i <= n; i++)
                if (Adj[current][i] < Integer.MAX_VALUE) {
                    int moi = lable[current] + Adj[current][i];
                    if (moi < lable[i]) {
                        Previous[i] = current;
                        lable[i] = moi;
                    }
                }
            int ind = 0, min = Integer.MAX_VALUE;
            for (int i = 1; i <= n; i++)
                if (!Mark[i] && lable[i] < min) {
                    min = lable[i];
                    ind = i;
                }
//                    if(min == Integer.MAX_VALUE) System.out.println("ko co");return;
            current = ind;
            lable[current] = min;

        }
        System.out.println("Đường đi ngắn nhất từ " + s + " đến " + E + " có trọng số là " + lable[E]);
        int t = E;
        while (t != s) {
            System.out.print(t + " <--");
            t = Previous[t];
        }
        System.out.println(s);

    }

    public static void main(String[] args) {
        Graph G2 = new Graph();
        for (int i = 1; i <= G2.n; i++) System.out.println("So bac cau dinh thu" + i + ": " + G2.degree(i));
        System.out.println("so canh: " + G2.numedges());
        G2.dfs(1);
        G2.display();
        System.out.println();
        G2.dijkstra(1, 5);
    }
}
