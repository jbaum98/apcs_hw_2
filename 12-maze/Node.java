public class Node<E> {
    private final E data;
    private Node<E> next = null;

    public Node(E data) { this.data = data; }

    public E getData() { return data; }

    public Node<E> getNext() { return next; }

    public void setNext(Node<E> next) { this.next = next; }
}
