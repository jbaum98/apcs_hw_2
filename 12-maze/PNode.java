public class PNode<E> extends Node<E> {
    private final int priority;
    private PNode<E> next = null;

    public PNode(E data, int priority) {
        super(data);
        this.priority = priority;
    }

    public int getPriority() { return priority; }

    public PNode<E> getNext() { return next; }

    public void setNext(PNode<E> next) { this.next = next; }
}
