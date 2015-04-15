import java.util.Scanner;
import java.io.File;

public class Maze {
    private char[][] board;

    private char path   = '#';
    private char wall   = ' ';
    private char me     = 'J';
    private char tracks = '.';
    private char exit   = '$';
    private char trace  = '%';
    public final Point exitPoint;

    public Maze() {
        board = new char[40][20];

        try {
            Scanner sc = new Scanner(new File("maze.dat"));
            int j=0;
            while (sc.hasNext())
            {
                String line = sc.nextLine();
                for (int i=0;i<board.length;i++)
                {
                    board[i][j] = line.charAt(i);
                }
                j++;
            }
        }
        catch (Exception e) {}
        exitPoint = breadth(1,1);
        reset();
    }

    private <P extends Point> P solve(Storage<P> q, boolean display) {
        while (! q.empty()) {
            P current = q.take();
            if (display) printStat(q);
            if (isExit(current)) {
                if (display) retrievePath(current);
                return current;
            } else {
                setCharAt(current, tracks);
                for (P p : (P[]) current.neighbors(this)) {
                    if (p != null) q.put(p);
                }
            }
        }
        return null;
    }

    public void printStat(Storage q) {
        delay(100);
        System.out.print(this);
        System.out.println(q);
    }

    public void retrievePath(Point exit) {
        for (Point p = exit.previous; p != null; p = p.previous) {
            setCharAt(p,trace);
        }
    }

    public Point breadth(int x, int y, boolean display) {
        Storage<Point> q = new Q<Point>();
        q.put(new Point(x,y));
        return solve(q, display);
    }
    public Point breadth(int x, int y) { return breadth(x,y,false); }

    public Point depth(int x, int y, boolean display) {
        Storage<Point> q = new Stack<Point>();
        q.put(new Point(x,y));
        return solve(q, display);
    }
    public Point depth(int x, int y) { return depth(x,y,false); }

    public Point best(int x, int y, boolean display) {
        Storage<PPoint> q = new PQ<PPoint>();
        q.put(new PPoint(x,y,calculatePriority(x,y)));
        return solve(q, display);
    }
    public Point best(int x, int y) { return best(x,y,false); }

    public boolean isValid(int x, int y) {
        return
            0 <= x               &&
            x <  board.length    &&
            0 <= y               &&
            y <  board[0].length &&
            (board[x][y] == path || board[x][y] == exit);
    }

    public char charAt(Point p) {
        return board[p.x][p.y];
    }

    public void setCharAt(Point p, char c) {
        board[p.x][p.y] = c;
    }

    public boolean isExit(Point p) {
        return charAt(p) == exit;
    }

    public int calculatePriority(int x, int y) {
        return EuclideanDistance(x,y);
    }

    public int calculatePriority(Point p) {
        return calculatePriority(p.x, p.y);
    }

    private int EuclideanDistance(int x, int y) {
        int dx = exitPoint.x - x;
        if (dx < 0) dx = -dx;
        int dy = exitPoint.y - y;
        if (dy < 0) dy = -dy;
        return dx*dx + dy*dy;
    }

    public static void delay(int n){
        try {
            Thread.sleep(n);
        } catch (Exception e) {}
    }

    public void reset() {
        for (int y=0; y < board[0].length; y++)
        {
            for (int x=0; x < board.length; x++) {
                char c = board[x][y];
                if (c == me || c == tracks || c == trace) {
                    board[x][y] = path;
                }
            }
        }
    }

    public String toString() {
        String s = "[2J\n";

        for (int y=0; y < board[0].length; y++)
        {
            for (int x=0; x < board.length; x++)
                s += board[x][y];
            s+='\n';
        }
        return s;
    }

    public static void main(String[] args){
        Maze m = new Maze();
        //System.out.println(m);
        //m.breadth(1,1);
        //System.out.println(m);
        //System.out.println("////////////////////////////////////////////////////////////");
        //delay(3000);
        //m.reset();
        //m.depth(1,1);
        m.best(1,1,true);
        System.out.println(m);
        System.out.println(m.exitPoint);
    }
}
