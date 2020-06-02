import java.util.*;

public class Validation {
    public final static Scanner in = new Scanner(System.in);

    public static int checkInputIntLimit(int min, int max) {
        while (true) {
            int result = Integer.parseInt(in.nextLine().trim());//-----------------------
            if (result >= min || result <= max) {
                return result;
            } else {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                return result;
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

    public static boolean checkKeyWordExist(HashMap<String, String> hm, String english) {
        Set set = hm.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            if (english.equalsIgnoreCase(mentry.getKey().toString())) {
                return false;
            }
        }
        return true;
    }
}
