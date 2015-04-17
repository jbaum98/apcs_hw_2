package maze.storage;

public abstract class AbstractNode<N extends AbstractNode<N,E>, E> {
    private final E data;
    private N next = null;

    public AbstractNode(E data) { this.data = data; }

    public E getData() { return data; }

    public N getNext() { return next; }

    public void setNext(N next) { this.next = next; }
}
