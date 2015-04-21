package apcs_hw.maze.prioritizers;

public class AStar<E extends Costly> implements Prioritizer<E> {
    private final Prioritizer<E> p;

    public AStar(Prioritizer<E> p) {
        this.p = p;
    }

    public int priority(E data) {
        return data.cost() + p.priority(data);
    }

}
