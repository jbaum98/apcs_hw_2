package maze;

import maze.prioritizers.Costly;

public class Point implements Costly {
    public final int x;
    public final int y;
    private final int cost;
    public final Point previous;

    public Point(int x, int y, Point previous) {
        this.x = x;
        this.y = y;
        this.previous = previous;
        if (previous == null) {
            cost = 0;
        } else {
            this.cost = previous.cost + 1;
        }
    }

    public Point(int x, int y) { this(x,y,null); }

    public int cost() { return cost; }

    public Point[] neighbors(Maze m) {
        int[][] positions = {
            { x+1, y   },
            { x-1, y   },
            { x  , y+1 },
            { x  , y-1 }
        };

        Point[] out = new Point[positions.length];

        for (int i = 0; i < positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];
            if (m.isValid(x,y)) {
                out[i] = new Point(x,y,this);
            }
        }
        return out;
    }

    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point otherPoint = (Point) o;
            return this.x == otherPoint.x && this.y == otherPoint.y;
        } else {
            return false;
        }
    }

    public String toString() {
        return "("+x+","+y+")";
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        System.out.println(p1.equals(p2));
    }
}
