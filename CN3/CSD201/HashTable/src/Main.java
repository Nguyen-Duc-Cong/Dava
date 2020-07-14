
public class Main {
    public static void main(String[] args) {
        String KeySet = "ASEARCHINGEXAMPLEEASY";
        ChainingHash T = new ChainingHash(11);
        openingAddHash O = new openingAddHash(23, 1);
        for (int i = 0; i < KeySet.length(); i++) {
            String key = KeySet.substring(i, i + 1);
            System.out.println("Inserting key " + key + " to the Hash table");
            T.add(key);
        }
        int nC = T.display();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`");
        for (int i = 0; i < KeySet.length(); i++) {
            String key = KeySet.substring(i, i + 1);
            System.out.println("Inserting key " + key + " to the Hash table");
            O.add(key);O.display();
        }
        System.out.printf("The percent ratio of collision is %3.1f.\n", (1.0 * nC) / KeySet.length() * 100);
    }
}
