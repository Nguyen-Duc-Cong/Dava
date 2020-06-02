public class Manager {
    static int menu() {
        System.out.println("===================================================================");
        System.out.println("Press 1. Calculate Superlative Equation");
        System.out.println("Press 2. Calculate Quadratic Equation");
        System.out.println("Press 3. Exit");
        System.out.println("===================================================================");
        System.out.print("Enter your choice[1-6]: ");
        int choice = Validation.checkInputIntLimit(1,6);
        return choice;
    }
}
