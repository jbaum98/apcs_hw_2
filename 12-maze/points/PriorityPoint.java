package maze.points;

import java.util.Arrays;
import maze.storage.HasPriority;
import maze.Maze;

public class PriorityPoint extends AbstractPoint<PriorityPoint> implements HasPriority {
    private final int priority;

    public PriorityPoint(int x, int y, PriorityPoint previous, int priority) {
        super(x,y,previous);
        this.priority = priority;
    }

    public PriorityPoint(int x, int y, int priority) {
        this(x,y,null,priority);
    }

    public PriorityPoint(PriorityPoint p, int priority) { this(p.x, p.y, p.previous, priority); }

    public int getPriority() { return priority; }

    protected PriorityPoint newNeighbor(int x, int y, Maze m) {
        int priority = m.calculatePriority(x,y);
        return new PriorityPoint(x, y, this, priority);
    }

    protected PriorityPoint[] blankArray(int length) { return new PriorityPoint[length]; }

    public String toString() {
        return super.toString() + " ! " + getPriority() + " ";
    }

    public static void main(String[] args) {
        Maze m = new Maze();
        PriorityPoint p = new PriorityPoint(1,1,m.calculatePriority(1,1));
        System.out.println(Arrays.toString(p.neighbors(m)));
    }
}
