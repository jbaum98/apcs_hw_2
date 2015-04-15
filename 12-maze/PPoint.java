public class PPoint extends Point implements HasPriority {
    private final int priority;

    public PPoint(int x, int y, Point previous, int priority) {
        super(x,y,previous);
        this.priority = priority;
    }

    public PPoint(int x, int y, int priority) {
        this(x,y,null,priority);
    }

    public PPoint(Point p, int priority) { this(p.x, p.y, p.previous, priority); }

    public int getPriority() { return priority; }

    public PPoint[] neighbors(Maze m) {
        Point[] neighbors = super.neighbors(m);
        PPoint[] out = new PPoint[4];
        for (int i = 0; i < neighbors.length; i++) {
            Point p = neighbors[i];
            if (p != null) {
                int priority = m.calculatePriority(p);
                out[i] = new PPoint(p, priority);
            }
        }
        return out;
    }

    public String toString() {
        return super.toString() + " ! " + getPriority() + " ";
    }
}
