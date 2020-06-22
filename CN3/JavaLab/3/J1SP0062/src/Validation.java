import java.util.Scanner;

public class Validation {
    public static Scanner sc=new Scanner(System.in);
    public static String checkString()
    {
        String res=sc.nextLine();
        if (res.isEmpty()){
            System.out.print("String can't be NULL, enter again: ");
            return checkString();
        }
        return res;
    }
}
