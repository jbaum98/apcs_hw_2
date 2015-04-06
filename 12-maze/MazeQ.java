import java.util.Scanner;
import java.io.File;

public class MazeQ {
    private char[][] board;

    private char path   = '#';
    private char wall   = ' ';
    private char me     = 'J';
    private char tracks = '.';
    private char exit   = '$';
    protected Storage<Point> q;

    public MazeQ() {
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

        q = new Q<Point>();
    }

    public boolean solve(int startX, int startY) {
        q.put(new Point(startX,startY,null));

        while (! q.empty()) {
            Point current = q.take();
            delay(100);
            System.out.println(charAt(current));
            System.out.print(this);
            System.out.println(q);
            if (isExit(current)) {
                System.out.println("done");
                for (Point p = current; p != null; p = p.previous) {
                    setCharAt(p,'%');
                }
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
        MazeQ m = new MazeQ();
        //System.out.println(m);
        m.solve(1,1);
        System.out.println(m);
    }
}
