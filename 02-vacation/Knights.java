import java.io.*;
import java.util.*;

public class Knights {
    public String[][] board;
    private int maxX;
    private int maxY;

    private String open="o";
    private String visited="x";
    private boolean animate;
    private int movesLeft;
    private int digits;

    public void delay(int n){
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {}
    }

    public Knights(int maxX, int maxY, boolean animate) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.animate = animate;
        board = new String[maxX][maxY];
        for (int y=0; y < maxY; y++) {
            for (int x=0; x < maxX; x++) {
                board[x][y] = open;
            }
        }
        movesLeft = maxX*maxY - 1;
        digits = (int) Math.log10(movesLeft) + 1 + 1; // for padding
    }

    public String toString() {
        String s = animate ? "[2J\n" : new String(); // clear the terminal
        //String s = new String();
        for (int y=0; y < maxY; y++) {
            for (int x=0; x < maxX; x++) {
                s += board[x][y];
            }
            s += '\n';
        }
        return s;
    }

    /**
     * @return an array of all possible moves for a knight at
     * (x,y).
     */
    public int[][] possibleMoves(int x, int y) {
        int[][] out = {
            {x+2,y+1},
            {x+2,y-1},
            {x-2,y+1},
            {x-2,y-1},
            {x+1,y+2},
            {x-1,y+2},
            {x+1,y-2},
            {x-1,y-2}
        };
        return out;
    }

    public boolean solve(int x, int y) {
        if (animate) {
            delay(100);
            System.out.println(this);
        }

        // verify valid point
        if (isDeadEnd(x,y)) {
            return false;
        }

        // mark it
        board[x][y] = visited;

        if (isSolved()) {
            mark(x,y);
            return true;
        } else {
            for (int[] move : possibleMoves(x,y)) {
                if ( solve(move[0], move[1]) ) {
                    mark(x,y);
                    return true;
                }
            }

            // none of our moves worked
            board[x][y] = open;
            return false;
        }
    }

    public void mark(int x, int y) {
        board[x][y] = String.format("%" + digits + "d", movesLeft);
        movesLeft--;
    }

    public boolean isDeadEnd(int x, int y) {
        return
            x < 0 ||
            x >= maxX ||
            y < 0 ||
            y >= maxY ||
            board[x][y].equals(visited);
    }

    public boolean isSolved() {
        for (int y=0; y < maxY; y++) {
            for (int x=0; x < maxX; x++) {
                if (board[x][y].equals(open)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage:\n\tjava Knights <X> <Y> <animate>\n\tjava Knights <X> <Y> <animate> <startX> <startY>");
        } else {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            boolean animate;
            if (args.length >= 3) {
                animate = args[2].equals("1");
            } else {
                animate = false;
            }
            int startX, startY;
            if (args.length >= 5) {
                startX = Integer.parseInt(args[3]);
                startY = Integer.parseInt(args[4]);
            } else {
                startX = 0;
                startY = 0;
            }
            Knights k = new Knights(x, y, animate);
            k.solve(startX,startY);
            System.out.println(k);
        }
    }
}
