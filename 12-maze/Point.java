import java.util.Random;

public class Point extends AbstractPoint<Point> {
    public Point(int x, int y, Point previous) {
        super(x,y,previous);
    }

    public Point(int x, int y) { super(x,y); }

    protected Point[] blankArray(int length) { return new Point[length]; }
    protected Point newNeighbor(int x, int y, Maze m) { return new Point(x,y,this); }

    public static void main(String[] args) {
        /*Random r = new Random();
        int x = r.nextInt(10);
        int y = r.nextInt(10);
        Point p1 = new Point(x,y,null);
        Point p2 = new Point(x,y,null);
        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p1));

        Storage<Point> q = new Q<Point>();
        q.put(p1);
        q.put(p2);
        System.out.println(q);*/
    }
}
