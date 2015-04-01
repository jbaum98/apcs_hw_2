import java.io.*;
import java.util.*;

public class Maze {
    private char[][] board;

    private char path   = '#';
    private char wall   = ' ';
    private char me     = 'J';
    private char tracks = '.';
    private char exit   = '$';

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
    }

    public boolean solve(int startX, int startY) {
        Storage<Point> q = new Q<Point>();
        q.put(new Point(startX,startY));

        while (! q.empty()) {
            Point current = q.take();
            delay(1000);
            setCharAt(current, me);
            System.out.print(this);
            System.out.println(q);
            if (isExit(current)) {
                return true;
            } else {
                setCharAt(current, tracks);
                for (Point p : current.neighbors(this)) {
                    if (p != null) q.put(p);
                }
            }
        }
        return false;
    }


    public boolean isValid(int x, int y) {
        return
            0 <= x               &&
            x <  board.length    &&
            0 <= y               &&
            y <  board[0].length &&
            board[x][y] == path;
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

    public void delay(int n){
        try {
            Thread.sleep(n);
        } catch (Exception e) {}
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
        System.out.println(m);
        m.solve(1,1);
        System.out.println(m);
    }
}

class Point {
    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point[] neighbors(Maze m) {
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
                out[i] = new Point(x,y);
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
        Point p1 = new Point(x,y);
        Point p2 = new Point(x,y);
        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p1));

        Storage<Point> q = new Q<Point>();
        q.put(p1);
        q.put(p2);
        System.out.println(q);
    }
}
