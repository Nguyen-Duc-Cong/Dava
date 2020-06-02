import java.util.Scanner;

//class List {
//    public void addHead(int x) {
//        Node mid = new Node(x);
//        if (isEmpty()) {
//            head = tail = mid;
//        } else {
//            mid.next = head;
//            head = mid;
//        }
//    }
//    public void output() {
//        for (Node t = head; t != null; t = t.next) {
//            System.out.println(t.info);
//        }
//        System.out.println("");
//    }
//    public void addTail(int x) {
//        Node t = new Node(x);
//        if (isEmpty()) {
//            head = t;
//        } else {
//            tail.next = t;
//        }
//        tail = t;
//    }
//}
////__________________________________________________________________________________

class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        //  System.out.println("Nhap a: ");
        // int a = Integer.parseInt(sc.nextLine());
        //  Node c = new Node(a);
        // System.out.println("Infor: "+c.info);
        //  System.out.println("Next: "+c.next);
        List l = new List();
        // System.out.println("Head: "+l.head);
        //System.out.println("Tail: "+l.tail);
//        l.addHead(5);
//        l.addHead(1);
//        l.addHead(2);
//        l.addHead(4);
//        l.addHead(6);
//        l.addHead(3);
//        l.output();
//        System.out.println("Max is: " + l.max());
//        System.out.println("Min is: " + l.min());
//        l.addTail(5);
//        l.addTail(1);
//        l.addTail(2);
//        l.addTail(4);
//        l.addTail(6);
//        l.addTail(3);
        l.addHead2(4);
        l.addTail2(5);
        //l.addAfterNode(0, 100);
        //l.addAfterNode(100, 5000);
        l.output();
        Node pos = l.search(sc.nextInt());
        if (pos == null) {
            System.out.println("Not Exists");
        } else {
            System.out.println("Nut's infor is: " + pos.info);
        }
    }
}