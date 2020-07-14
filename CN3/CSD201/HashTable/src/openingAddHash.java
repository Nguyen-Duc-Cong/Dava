public class openingAddHash {
    String[] table;
    int M, SPTDSD=0, SDD=0, probTybe;

    openingAddHash(int M, int probTybe) {
        this.M = M;
        table = new String[M];
        for (int i = 0; i < M; i++) table[i] = "~";
        this.probTybe = probTybe;
    }

    int nexPos(int j) {
        if (probTybe == 0) return j;
        return j * j;
    }

    void add(String key) {
        if (SPTDSD == M) {
            System.out.println("FULL.");
            return;
        }
        int VTBdau = (key.charAt(0) - 'A' + 1) % M;
        int j = 0;
        while (!table[(VTBdau + nexPos(j)) % M].equals("~")) {
            j++;
            SDD++;
        }
        table[(VTBdau + nexPos(j)) % M] = key;
        SPTDSD++;
    }

    void display() {
        for (int i = 0; i < M; i++) System.out.printf("%2s", table[i]);
    }
}
