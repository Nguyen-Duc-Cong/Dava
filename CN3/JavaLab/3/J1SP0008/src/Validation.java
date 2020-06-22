import java.util.Scanner;

public class Validation {
    static Scanner SCANNER =new Scanner(System.in);
    public static String checkInputString()
    {
        String result= SCANNER.nextLine();
        if (result.isEmpty()){
            System.out.print("String can't be NULL, enter again: ");
            return checkInputString();
        }
        return result;
    }
}
