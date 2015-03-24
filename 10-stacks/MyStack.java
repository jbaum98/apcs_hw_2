import java.util.Random;

public class MyStack<E> {
    Node<E> top = null;

    public void push(E data) {
        top = new Node<E>(data, top);
    }

    public E pop() {
        E oldTop = top.getData();
        top = top.getNext();
        return oldTop;
    }

    public boolean empty() {
        return top == null;
    }

    public E top() {
        return top.getData();
    }

    public String toString() {
        String out = new String();
        for(Node<E> n = top; n.getNext() != null; n = n.getNext()) {
            out += n.getData() + "----> ";
        }
        out += "null";
        return out;
    }


    public static void main(String[] args) {
        MyStack<Integer> s = new MyStack<Integer>();
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            s.push(r.nextInt(100));
        }
        System.out.println(s);
        System.out.println("first guy: " + s.top());
        System.out.println("popped him: " + s.pop());
        System.out.println(s);

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
