package apcs_hw.maze;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import apcs_hw.maze.storage.*;
import apcs_hw.maze.prioritizers.*;

public class Maze {
    private final char[][] board;

    private final char path   = '#';
    private final char wall   = ' ';
    private final char me     = 'J';
    private final char tracks = '.';
    private final char exit   = '$';
    private final char trace  = '%';
    public final Point exitPoint;

    public Maze(File file) {
        List<char[]> b = new ArrayList<char[]>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                char[] l = new char[line.length()];
                for (int i=0; i < line.length(); i++) {
                    l[i] = line.charAt(i);
                }
                b.add(l);
            }
        }
        catch (IOException e) {
            System.out.println("Error parsing maze file");
            System.exit(1);
        }
        board = b.toArray(new char[0][0]);
        exitPoint = breadth(0,0);
        reset();
    }

    private Point solve(Storage<Point> q, boolean display) {
        while (! q.empty()) {
            Point current = q.take();
            if (display) printStat(q);
            if (isExit(current)) {
                if (display) retrievePath(current);
                return current;
            } else {
                if (display) setCharAt(current, tracks);
                for (Point p : current.neighbors(this)) {
                    if (p != null) q.put(p);
                }
            }
        }
        return null;
    }

    public void printStat(Storage q) {
        delay(10);
        System.out.print(this);
        //System.out.println(q);
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
        Storage<Point> q = new PriorityQ<Point>(new EuclideanPrioritizer(exitPoint));
        q.put(new Point(x,y));
        return solve(q, display);
    }
    public Point best(int x, int y) { return best(x,y,false); }

    public Point astar(int x, int y, boolean display) {
        Storage<Point> q = new PriorityQ<Point>(new AStar<Point>(new ManhattanPrioritizer(exitPoint)));
        q.put(new Point(x,y));
        return solve(q, display);
    }
    public Point astar(int x, int y) { return astar(x,y,false); }

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
}
