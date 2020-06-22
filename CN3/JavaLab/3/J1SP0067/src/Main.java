import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter your content:");
        String content = Validation.checkInputString();
        HashMap<String, ArrayList<Integer>> hm1 = List.getNumber(content);
        HashMap<String, StringBuffer> hm2 = List.getCharacter(content);
        System.out.println("__________ Result __________");
        printData1(hm1);
        System.out.println("____________________________");
        printData2(hm2);
        System.out.println("____________________________");
        ;
    }

    public static void printData1(HashMap<String, ArrayList<Integer>> hm) {
        System.out.println("PERFECT SQUARE NUMBER: " + hm.get("perfect"));
        System.out.println("EVEN NUMBER: " + hm.get("even"));
        System.out.println("ODD NUMBER: " + hm.get("odd"));
        System.out.println("ALL NUMBER: " + hm.get("all"));
    }

    public static void printData2(HashMap<String, StringBuffer> hm) {
        System.out.println("UPPERCASE: " + hm.get("upper"));
        System.out.println("LOWERCASE: " + hm.get("lower"));
        System.out.println("SPECIAL: " + hm.get("special"));
        System.out.println("ALL CHARACTER: " + hm.get("all"));
    }
}