import java.util.ArrayList;
import java.util.HashMap;


public class List {

    private static boolean theCharactersNumber(int num){
        if (num==0) return false;
        if ((int)Math.pow((int)(Math.sqrt(num)),2)==num) return true;
        return true;
    }
    private static boolean evenNumber(int num) {
        if ((num % 2) == 0)
            return true;
        return false;
    }

    public static HashMap<String, ArrayList<Integer>> getNumber(String s) {
        HashMap<String, ArrayList<Integer>> result = new HashMap<>();
        String[] temp = s.split("\\D");
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        ArrayList<Integer> squareNumbers = new ArrayList<>();
        for (String number : temp) {
            if (number.isEmpty()) continue;
            int tNumber = Integer.parseInt(number);
            numbers.add(tNumber);
            if(evenNumber(tNumber)) evenNumbers.add(tNumber);
                else oddNumbers.add(tNumber);
            if(theCharactersNumber(tNumber)) squareNumbers.add(tNumber);
        }
        result.put("perfect", squareNumbers);
        result.put("even", evenNumbers);
        result.put("odd", oddNumbers);
        result.put("all", numbers);
        return result;
    }

    public static HashMap<String, StringBuffer> getCharacter(String s) {
        HashMap<String, StringBuffer> result = new HashMap<>();
        char[] temp = s.replaceAll("\\d","").toCharArray();
        StringBuffer all = new StringBuffer();
        StringBuffer specialCase = new StringBuffer();
        StringBuffer upperCase = new StringBuffer();
        StringBuffer lowerCase = new StringBuffer();
        for(char word : temp){
            if (all.indexOf(Character.toString(word))>=0) continue;
            all.append(word);
            if ((word>='A')&&(word<='Z')) upperCase.append(word);
            else if ((word>='a')&&(word<='z')) lowerCase.append(word);
            else specialCase.append(word);
        }
        result.put("upper", upperCase);
        result.put("lower", lowerCase);
        result.put("special", specialCase);
        result.put("all", all);
        return result;
    }
}
