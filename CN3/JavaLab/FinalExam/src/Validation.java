/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {

    static final Scanner in = new Scanner(System.in);

    public static int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int res = Integer.parseInt(in.nextLine().trim());
                if (res < min || res > max) {
                    throw new NumberFormatException();
                }
                return res;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in range(" + min + ", " + max + ")");
                System.out.print("Enter again: ");
            }
        }
    }
    
    public static String checkInputPhone() {
    	while (true) {
            String result = in.nextLine();
            if (Pattern.matches("\\d{10}",result))
                return result;
            else
            {
                if(!Pattern.matches("\\d",result))
                    System.out.println("Must be number");
                else
                    System.out.println("Need to be 10 digit");
            }
            System.out.print("Enter again:");
        }
    }
    public static double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be double");
                System.out.print("Enter again: ");
            }
        }
    }

    public static int checkInputInt() {
        while (true) {
           try {
               int result=Integer.parseInt(in.nextLine().trim()); 
               return result;               
           } catch (NumberFormatException e) {
               System.err.println("Must be integer.");
               System.out.print("Enter again: ");
           }
        }
    }

    public static String checkInputString() {
        while (true) {
            String res = in.nextLine().trim();
            if (res.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return res;
            }
        }
    }

    public static boolean checkInputYN() {
        while (true) {
            String res = checkInputString();
            if (res.equalsIgnoreCase("Y")) {
                return true;
            }
            if (res.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input Y or N: ");
            System.out.print("Enter again: ");
        }
    }

    public static char checkInputUD() {
        while (true) {
            String res = checkInputString();
            if (res.equalsIgnoreCase("Y")) {
                return 'U';
            }
            if (res.equalsIgnoreCase("N")) {
                return 'D';
            }
            System.err.println("Please input U or D: ");
            System.out.print("Enter again: ");
        }
    }

    public static Date checkInputDate() {
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
        String result = checkInputString();
        Date date = new Date();
        try {
            date = formater.parse(result);
        } catch (ParseException e) {
            System.err.println("Please input in format (dd/MM/yyyy)");
            System.out.print("Enter again: ");
            checkInputDate();
        }
        return date;
    }

    public static Date checkInputDischargedDate(Date dischargedDate) {
        Date date = new Date();
        do {
            date = checkInputDate();
            if ((date.getTime() - dischargedDate.getTime()) <= 0) {
                System.err.println("Discharged date must later than hospitalized date");
                System.out.print("Enter again: ");
            }
        } while ((date.getTime() - dischargedDate.getTime()) <= 0);
        return date;
    }

    public static String checkInputGender() {
        String result;
        while(true) {
            result=in.nextLine();
            if(result.equalsIgnoreCase("m")) return "Male";
            else if(result.equalsIgnoreCase("f")) return "Female";
        }
    }
    public static String checkInputCode() {
        while(true) {
        String result = checkInputString();
        if(result.length()<4) System.err.println("Tour's code must have 4 characters!");
        else return result;
        }
    }
    public static String getStringAcceptNull(String statement) {
        System.out.print(statement);

        return in.nextLine().trim();
    }
    public static String getString(String statement) {
        while (true) {
            String temp = getStringAcceptNull(statement);

            if (!temp.isEmpty()) {
                return temp;
            }
        }
    }
}
