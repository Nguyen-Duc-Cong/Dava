import java.util.LinkedList;

public class Entry {
    LinkedList<String> L;

    Entry() {
        L = new LinkedList<>();
    }

    void add(String key) {
        L.add(key);
    }

    void display() {
        for (int i = 0; i < L.size(); i++) {
            System.out.print("--->" + L.get(i));
        }
    }

    int numCollideElement() {
        if (L.size() > 0) return L.size() - 1;
        return 0;
    }
}
