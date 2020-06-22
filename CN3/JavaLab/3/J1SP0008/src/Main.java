public class Main {
    public static void main(String[] args) {
        System.out.print("Enter your content:");
        String content=Validation.checkInputString();
        System.out.println("WORD: "+Split.splitWord(content));
        System.out.println("CHAR: "+Split.splitChar(content));
    }
}
