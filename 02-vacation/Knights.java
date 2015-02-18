import java.io.*;
import java.util.*;

public class Knights {
    private String[][] board;
    private int maxX;
    private int maxY;

    private String open="o";
    private String visited="x";
    private boolean solved = false;
    private int movesLeft;

    public void delay(int n){
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {}
    }

    public Knights(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.board = new String[maxX][maxY];
        for (int y=0; y < maxY; y++) {
            for (int x=0; x < maxX; x++) {
                board[x][y] = open;
            }
        }
        movesLeft = maxX*maxY - 1;
    }

    public String toString() {
        //String s = "[2J\n"; // clear the terminal
        String s = new String();
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

    public void solve(int x, int y) {
        delay(1000);
        //System.out.println(this);
        if (isDeadEnd(x,y)) {
            return;
        } else if (isSolved()) {
            solved = true;
        }

        board[x][y] = visited;

        for (int[] move : possibleMoves(x,y)) {
            solve(move[0], move[1]);
        }

        if (solved) {
            board[x][y] = ""+movesLeft;
            movesLeft--;
        } else {
            board[x][y] = open;
        }
        return;
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
        Knights k = new Knights(5, 5);
        k.solve(0,0);
        System.out.println(k);
    }
}
