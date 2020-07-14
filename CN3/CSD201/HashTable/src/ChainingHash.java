public class ChainingHash {
    Entry[] table;
    int M;

    public ChainingHash(int M) {
        this.M = M;
        table = new Entry[M];
        for (int i = 0; i < M; i++) table[i] = new Entry();
    }

    void add(String key) {
        int keySo = key.charAt(0) - 'A' + 1;
        table[keySo % M].add(key);
    }

    int display() {
        int numCollideElement = 0;
        for (int i = 0; i < M; i++) {
            System.out.printf("H[%3d | ", i);
            table[i].display();
            System.out.println();
            numCollideElement += table[i].numCollideElement();
        }
        return numCollideElement;
    }

}
