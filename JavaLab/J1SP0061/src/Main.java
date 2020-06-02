public class Main {
    public static void main(String[] args) {
        int chosse = Manager.menu();
        switch (chosse)
        {
            case 1:
                Program.normalCalculator();
                break;
            case 2:
                Program.calculatorBMIIndex();
                break;
            case 3:
                break;
        }
    }
}
