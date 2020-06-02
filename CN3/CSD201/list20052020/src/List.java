public class List {
    Node head, tail;

    public List() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    //------------------------------------------------
    public void addAfterNode(int x, int y) {
        Nut truoc = new Nut();
        addAfter(search(x, truoc), new Node(y));
    }

    public void addToHead(int x) {
        addAfter(null, new Node(x));

    }

    public void addToTail(int x) {
        addAfter(tail, new Node(x));
    }

    public void addAfter(Node tNode, Node p) {
        if (tNode == null) {
            p.next = head;
            head = p;
        } else {
            p.next = tNode.next;
            tNode.next = p;
        }
        if (tNode == tail) tail = p;
    }
//------------------------------------------------


    public void deleteHead() {
        deleteAfter(null);
    }

    public void deleteFail() {
        deleteNote(tail.info);
    }

    public void deleteNote(int x) {
        Nut truoc = new Nut();
        search(x, truoc);
        deleteAfter(truoc.n);
    }

    public void deleteAfter(Node t) {
        Node nutXoa;
        if (t == null) {
            nutXoa = head;
            head = nutXoa.next;
        } else {
            nutXoa = t.next;
            t.next = nutXoa.next;
        }
        if (nutXoa == tail) tail = t;
    }


    //--------------------------------------------
    void dele(Node q) {
        Node f, p;
        f = null;
        p = head;
        while (p != null) {
            if (p == q) break;
            f = p;
            p = p.next;
        }
        if (p == null) return;
        if (f == null) {
            head = head.next;
            if (head == null) tail = null;
            return;
        }
        f.next = p.next;
        if (f.next == null) tail = f;
    }

    //--------------------------------------------
    public Node search(int x) {
        Node p = head;
        while (p != null && p.info != x) p = p.next;
        return p;
    }

    public Node search(int x, Nut truoc) {
        Node t = head;
        truoc.n = null;
        while (t != null && t.info != x) {
            truoc.n = t;
            t = t.next;
        }
        return t;

    }

    //--------------------------------------------
    public int size() {
        Node p = head;
        int c = 0;
        while (p != null) {
            c++;
            p = p.next;
        }
        return c;
    }

    public Node get(int k) {
        Node p = head;
        int c = 0;
        while (p != null && c < k) {
            c++;
            p = p.next;
        }
        return p;
    }

    public void sort() {
        int n = size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                Node pi = get(i), pj = get(j);
                if (pi.info > pj.info) {
                    int t = pi.info;
                    pi.info = pj.info;
                    pj.info = t;
                }
            }
        }
    }

    //---------------------------------------------
    public int max() {
        int max = Integer.MIN_VALUE;
        for (Node t = head; t != null; t = t.next) {
            if (t.info > max) {
                max = t.info;
            }
        }
        return max;
    }

    public int min() {
        int min = Integer.MAX_VALUE;
        for (Node t = head; t != null; t = t.next) {
            if (t.info < min) {
                min = t.info;
            }
        }
        return min;
    }
//----------------------------------------------------

    //remove a node from the list
    public void remove(Node p) {
        if (p == null) return;
        //find q where q.next = p
        Node f = head, q = null;
        while (f != null && f != p) {
            q = f;
            f = f.next;
        }
        //remove head
        if (q == null) {
            head = head.next;
            if (head == null) tail = null;
        } else {
            q.next = p.next;
            if (p == tail) tail = q;
        }
        p.next = null;
    }

    //reverse a list
    public void reverse() {
        int n = size();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            Node pi = get(i), pj = get(j);
            int t = pi.info;
            pi.info = pj.info;
            pj.info = t;
        }
    }

    //remove second node which have info < x
    public void removeAfter(int x) {
        int c = 0;
        Node p = head;
        while (p != null) {
            if (p.info < x) c++;
            if (c >= 2) break;
            p = p.next;
        }
        remove(p);
    }
}
