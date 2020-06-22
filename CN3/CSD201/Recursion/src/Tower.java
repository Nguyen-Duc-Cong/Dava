public class Tower {
    static int count = 0;

    public static int Tower(int tower, int bus, int checkPoint) {
        if (tower == 1) {
            checkPoint++;
            tower--;
            return 1;
        }
        count++;
        System.out.println("tower: " + tower + " bus:" + bus + " checkPoint:" + checkPoint);
        return Tower(bus, tower, checkPoint);
    }

    public static void main(String[] args) {
        int time = Tower(4, 0, 0);
        System.out.println(time);
    }
}
