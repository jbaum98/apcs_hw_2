
import java.util.Random;

public class Point {
    public final int x;
    public final int y;
    public final Point previous;

    public Point(int x, int y, Point previous) {
        this.x = x;
        this.y = y;
        this.previous = previous;
    }

    public Point[] neighbors(MazeQ m) {
        int[][] positions = {
            { x+1, y   },
            { x-1, y   },
            { x  , y+1 },
            { x  , y-1 }
        };

        Point[] out = new Point[4];

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
        Random r = new Random();
        int x = r.nextInt(10);
        int y = r.nextInt(10);
        Point p1 = new Point(x,y,null);
        Point p2 = new Point(x,y,null);
        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p1));

        Storage<Point> q = new Q<Point>();
        q.put(p1);
        q.put(p2);
        System.out.println(q);
    }
}
