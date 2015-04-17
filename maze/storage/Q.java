package maze.storage;

public class Q<E> extends AbstractQ<Node<E>,E> {
    protected Node<E> newNode(E data) { return new Node<E>(data); }
}
