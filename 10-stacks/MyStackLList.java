import java.util.EmptyStackException;

public class MyStackLList<E> implements MyStack<E> {
    Node<E> top = null;

    public void push(E data) {
        top = new Node<E>(data, top);
    }

    public E pop() {
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

    public E top() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return top.getData();
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

class Node<E> {
    private E data;
    private Node<E> next = null;

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    public E getData(){
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
