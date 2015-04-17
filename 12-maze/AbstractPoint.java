public abstract class AbstractPoint<P extends AbstractPoint<P>> {
    public final int x;
    public final int y;
    public final P previous;

    public AbstractPoint(int x, int y, P previous) {
        this.x = x;
        this.y = y;
        this.previous = previous;
    }

    public AbstractPoint(int x, int y) { this(x,y,null); }

    protected P[] neighbors(Maze m) {
        int[][] positions = {
            { x+1, y   },
            { x-1, y   },
            { x  , y+1 },
            { x  , y-1 }
        };

        P[] out = blankArray(positions.length);

        for (int i = 0; i < positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];
            if (m.isValid(x,y)) {
                out[i] = newNeighbor(x,y,m);
            }
        }
        return out;
    }

    protected abstract P[] blankArray(int length);
    protected abstract P newNeighbor(int x, int y, Maze m);

    public boolean equals(Object o) {
        if (o instanceof AbstractPoint) {
            AbstractPoint otherPoint = (AbstractPoint) o;
            return this.x == otherPoint.x && this.y == otherPoint.y;
        } else {
            return false;
        }
    }

    public String toString() {
        return "("+x+","+y+")";
    }

    public static void main(String[] args) {
        PriorityPoint p1 = new PriorityPoint(1, 2, 6);
        PriorityPoint p2 = new PriorityPoint(1, 2, 9);
        System.out.println(p1.equals(p2));
    }
}
