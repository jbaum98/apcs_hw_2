import java.util.NoSuchElementException;
import java.util.Random;

public class Q<E> implements Storage<E> {
    private Node<E> head = null;
    private Node<E> tail = null;

    public void put(E data){
        Node<E> node = new Node<E>(data);
        if (empty()) {
            head = node;
            tail = node;
        } else {
            if (contains(data)) return; // guarantee uniqueness
            head.setNext(node);
            head = node;
        }
    }

    public E take() {
        if (empty()) throw new NoSuchElementException();

        E out = tail.getData();
        tail = tail.getNext();
        if (tail == null) head = null;
        return out;
    }

    public boolean empty() {
        return head == null;
    }

    private boolean contains(E data) {
        for(Node<E> n = tail; n != null; n = n.getNext()) {
            if (data.equals(n.getData())) return true;
        }
        return false;
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
        int n = r.nextInt(100);
        weinerdog.put(n);
        for(int i = 0; i < 5; i++) {
            weinerdog.put(r.nextInt(100));
        }
        weinerdog.put(n);
        System.out.println(weinerdog);
        System.out.println(weinerdog.take());

        /*for(int i = 0; i < 100; i++) {
          weinerdog.put(r.nextInt(100));
        }
        System.out.println(weinerdog);
        for(int i = 0; i < 100; i++) {
        System.out.println(weinerdog.take());
        }*/
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
