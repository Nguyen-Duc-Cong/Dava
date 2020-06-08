import java.util.EmptyStackException;

public class Stack {
    private Node head;

    public Stack() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
    }

    public void push(int x) {
        Node t = new Node(x);
        t.setNext(head);
        head = t;
    }

    public int pop() {
        int x = head.getData();
        head = head.getNext();
        return x;
    }

    public int top() {
            if (isEmpty())
                throw new EmptyStackException();
            return head.getData();
    }

    public void traverse() {
            Node temp = getHead();
            while (temp!=null){
                System.out.print(temp.getData());
                temp = temp.getNext();
            }
    }

    public void convert(int num){
        while (num > 0) {
            push(num % 2);
            num /= 2;
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}
