import java.util.*;

public class Validation {
    public final static Scanner in = new Scanner(System.in);

    public static int checkInputIntLimit(int min, int max) {
        int value = checkInputInt();
        return min <= value && value <= max ? value : checkInputIntLimit(min, max);
    }

    public static int checkInputInt() {
        while (true) {
            try {
                return Integer.parseInt(in.nextLine().trim());
            } catch (NumberFormatException e) {
                System.err.println("Please input number");
                System.err.println("Enter again");
            }
        }
    }

    public static String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (!result.isEmpty()) {
                return result;
            } else {
                System.err.println("Can not empty");
                System.out.println("Please Enter again:");
            }
        }
    }

    public static double checkInputDouble() {
        double result = Double.parseDouble(in.nextLine());
        return result;
    }

    public static boolean checkInputYN() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y"))
                return true;
            if (result.equalsIgnoreCase("N"))
                return false;
            System.err.println("Please input y/n or Y/N");
            System.out.print("Enter again:");
        }
    }

    public static char checkInputUD() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("U"))
                return 'U';
            if (result.equalsIgnoreCase("D"))
                return 'D';
            System.err.println("Please input u/d or U/D");
            System.out.print("Enter again:");
        }
    }

    public static String checkInputCourse() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("java")
                    || result.equalsIgnoreCase(".net")
                    || result.equalsIgnoreCase("c/c++"))
                return result;
            System.err.println("There are only three courses: Java, .Net, C/C++");
            System.out.print("Enter again: ");
        }
    }
}
