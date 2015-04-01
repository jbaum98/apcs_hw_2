import java.util.NoSuchElementException;
import java.util.Random;

public class Q<E> {
    private Node<E> head = null;
    private Node<E> tail = null;

    public void enqueue(E data){
        Node<E> node = new Node<E>(data);
        if (empty()) {
            head = node;
            tail = head;
        } else {
            head.setNext(node);
            head = node;
        }
    }

    public E dequeue() {
        if (empty()) {
            throw new NoSuchElementException();
        }
        E out = tail.getData();
        tail = tail.getNext();
        if (head == null) tail = null;
        return out;
    }

    public boolean empty() {
        return head == null;
    }

    public E head() {
        return head.getData();
    }

    public int size() {
        int size = 0;
        for(Node<E> n = tail; n != null; n = n.getNext()) {
            size++;
        }
        return size;
    }

    public String toString() {
        String out = "tail | ";
        for(Node<E> n = tail; n != null; n = n.getNext()) {
            out += n.getData() + " ";
        }
        return out + "| head";
    }

    public static void main(String[] args) {
        Q<Integer> weinerdog = new Q<Integer>();
        Random r = new Random();
        for(int i = 0; i < 100; i++) {
            weinerdog.enqueue(r.nextInt(100));
        }
        System.out.println(weinerdog);
        for(int i = 0; i < 100; i++) {
            System.out.println(weinerdog.dequeue());
        }
    }
}

class Node<E> {
    private final E data;
    private Node<E> next = null;

    public Node(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
