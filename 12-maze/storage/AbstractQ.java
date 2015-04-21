package apcs_hw.maze.storage;

import java.util.NoSuchElementException;
import java.util.Random;

public abstract class AbstractQ<N extends AbstractNode<N,E>,E> implements Storage<E> {
    protected N head = null;
    protected N tail = null;

    protected abstract N newNode(E data);

    public void put(E data) {
        N newNode = newNode(data);
        if (empty()) {
            head = newNode;
            tail = newNode;
        } else {
            if (contains(data)) return; // guarantee uniqueness
            head.setNext(newNode);
            head = newNode;
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
        for(N n = tail; n != null; n = n.getNext()) {
            if (data.equals(n.getData())) return true;
        }
        return false;
    }

    public String toString() {
        String out = "tail | ";
        for(N n = tail; n != null; n = n.getNext()) {
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
