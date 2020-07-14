public class Mesenger {
    public static int menu() {
        System.out.println("-----------PATIENTS MANAGEMENT------------");
        System.out.println("1-Add inpatient ");
        System.out.println("2-Add outpatient ");
        System.out.println("3-Display list of patients ");
        System.out.println("4-Search patient");
        System.out.println("5-Remove the inpatients after specified date ");
        System.out.println("6-Save to file");
        System.out.println("7-Exit");
        System.out.println("-------------------------------------------------");
        System.out.print("Enter your choice:");
        int choice = Validation.checkInputIntLimit(1, 7);
        return choice;
    }
}
