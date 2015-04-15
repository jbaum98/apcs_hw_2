import java.util.NoSuchElementException;
import java.util.Random;

public class Q<E> implements Storage<E> {
    private Node<E> head = null;
    private Node<E> tail = null;

    public void put(E data) {
        Node<E> newNode = new Node<E>(data);
        if (empty()) {
            setHead(newNode);
            setTail(newNode);
        } else {
            if (contains(data)) return; // guarantee uniqueness
            getHead().setNext(newNode);
            setHead(newNode);
        }
    }

    public E take() {
        if (empty()) throw new NoSuchElementException();

        E out = getTail().getData();
        setTail(getTail().getNext());
        if (getTail() == null) setHead(null);
        return out;
    }

    public boolean empty() {
        return getHead() == null;
    }

    private boolean contains(E data) {
        for(Node<E> n = getTail(); n != null; n = n.getNext()) {
            if (data.equals(n.getData())) return true;
        }
        return false;
    }

    protected Node<E> getHead() { return head; }
    protected void setHead(Node<E> h) { head = h; }
    protected Node<E> getTail() { return tail; }
    protected void setTail(Node<E> t) { tail = t; }

    public String toString() {
        String out = "tail | ";
        for(Node<E> n = getTail(); n != null; n = n.getNext()) {
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
        System.out.println(weinerdog);

        /*for(int i = 0; i < 100; i++) {
          weinerdog.put(r.nextInt(100));
        }
        System.out.println(weinerdog);
        for(int i = 0; i < 100; i++) {
        System.out.println(weinerdog.take());
        }*/
    }
}
