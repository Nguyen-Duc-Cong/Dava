import java.util.HashMap;

public class Split {
    public static HashMap<String, Integer> splitWord(String s) {
        HashMap<String, Integer> result = new HashMap<>();
        String[] words = s.split("\\s");//\\s matches single  whitespace character
        for (String word : words) {
            if (result.containsKey(word)) result.put(word, result.get(word) + 1);
            else result.put(word, 1);
        }
        return result;
    }

    public static HashMap<String, Integer> splitChar(String s) {
        HashMap<String, Integer> result = new HashMap<>();
        String[] words = s.split("");
        for (String word : words)
            if (!(word.isEmpty() || (word.equals(" ")))) {
                if (result.containsKey(word)) result.put(word, result.get(word) + 1);
                else result.put(word, 1);
            }
        return result;
    }
}
