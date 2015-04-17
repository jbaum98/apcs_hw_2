package maze.storage;

public class PriorityNode<E> extends AbstractNode<PriorityNode<E>, E> {
    private final int priority;

    public PriorityNode(E data, int priority) {
        super(data);
        this.priority = priority;
    }

    public int getPriority() { return priority; }
}
