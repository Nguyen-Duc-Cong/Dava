public class Main {
    public static void main(String[] args) {
        int chosse = Manager.menu();
        switch (chosse)
        {
            case 1:
                Program.alculateSuperlativeEquation();
                break;
            case 2:
                Program.calculateQuadraticEquation();
                break;
            case 3:
                break;
        }
    }
}
