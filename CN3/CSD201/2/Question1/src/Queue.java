import com.sun.xml.internal.ws.message.EmptyMessageImpl;

import java.util.EmptyStackException;

public class Queue {
    Node head, tail;

    public Queue() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {

    }

    public void enqueue(int x) {
        if (isEmpty())
            head = tail = new Node(x);
        else {
            tail.setNext(new Node(x));
            tail = tail.getNext();
        }
    }

    public int dequeue() {
        if (isEmpty())
            throw new EmptyStackException();
        int x = head.getData();
        head = head.getNext();
        if (head == null) tail = null;
        return x;
    }

    public int first() {
        if(isEmpty())
            throw new EmptyStackException();
        return head.getData();
    }
    public void sort(){
        Node t = head.getNext(); tail = head;tail.setNext(null);
        while (t != null){
            Node afterT = t.getNext();
            chenThuTu(t);
        }
    }
    public void chenThuTu(Node t){
        Node beforX = null, x = head;
        while (x != null && x.getData() < t.getData()){
            beforX = x;x = x.getNext();
        }
    }
    public void addAfter(Node tNode, Node p) {
        if (tNode == null) {
            p.setNext(head);
            head = p;
        } else {
            p.setNext(tNode.getNext());
            tNode.setNext(p);
        }
        if (tNode == tail) tail = p;
    }
    public void sortqueue(int x){
        chenThuTu(new Node(x));
    }
    public void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getData());
            temp = temp.getNext();
        }
    }

}
