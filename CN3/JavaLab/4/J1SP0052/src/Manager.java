public class Manager {
    public static int menu(InputChecker ic){
        System.out.println("==========================================================================");
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending order");
        System.out.println("5. Exit");
        System.out.print("======>>YOUR CHOICE: ");
        int choice=ic.inputIntRange(1,5);
        return choice;
    }
}
