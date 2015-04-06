import java.util.EmptyStackException;

public class Stack<E> implements Storage<E> {
    Node<E> top = null;

    public void put(E data) {
        Node<E> n = new Node<E>(data);
        n.setNext(top);
        top = n;
    }

    public E take() {
        if (empty()) {
            throw new EmptyStackException();
        }
        E oldTop = top.getData();
        top = top.getNext();
        return oldTop;
    }

    public boolean empty() {
        return top == null;
    }

    public String toString() {
        String out = new String();
        for(Node<E> n = top; n != null; n = n.getNext()) {
            out += n.getData() + "----> ";
        }
        out += "null";
        return out;
    }
}
