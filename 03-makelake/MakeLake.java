public class MakeLake {
    private int maxRow;
    private int maxCol;
    private int[][] field;

    public MakeLake(int maxRow, int maxCol, int[][] field) {
        this.maxRow = maxRow;
        this.maxCol = maxCol;
        this.field = field;
    }

    public void applyMove(int[] move) {
        int row = move[0] - 1 ;
        int col = move[1] - 1;
        int toStomp = move[2];

        int newElev = maxOfSquare(row, col) - toStomp;
        if (newElev < 0) newElev = 0;

        for (int r = row; r < maxRow && r < row + 3; r++) {
            for (int c = col; c < maxCol && c < col + 3; c++) {
                if (field[r][c] > newElev) {
                    field[r][c] = newElev;
                }
            }
        }

    }

    public void applyMoves(int[][] moves) {
        for (int[] move : moves) {
            applyMove(move);
        }
    }

    private int maxOfSquare(int row, int col) {
        int max = field[row][col];
        for (int r = row; r < maxRow && r < row + 3; r++) {
            for (int c = col; c < maxCol && c < col + 3; c++) {
                if (field[r][c] > max) {
                    max = field[r][c];
                }
            }
        }
        return max;
    }

    public int getVolume(int elevation) {
        int total = 0;
        for (int r = 0; r < maxRow; r++) {
            for (int c = 0; c < maxCol; c++) {
                total +=
                    field[r][c] >= elevation ? 
                    0 :
                    elevation - field[r][c];
            }
        }
        return 72 * 72 * total;
    }

    public String toString() {
        String out = new String();
        for (int r = 0; r < maxRow; r++) {
            for (int c = 0; c < maxCol; c++) {
                out += field[r][c] + " ";
            }
            out += '\n';
        }
        return out;
    }

    public static void main(String[] args) {
        int R = 4;
        int C = 6;
        int E = 22;
        int[][] field = {
            {28, 25, 20, 32, 34, 36},
            {27, 25, 20, 20, 30, 34},
            {24, 20, 20, 20, 20, 30},
            {20, 20, 14, 14, 20, 20}
        };

        int[][] moves = {
            {1, 4, 4},
            {1, 1, 10}
        };

        MakeLake m = new MakeLake(R, C, field);

        System.out.println(m);
        m.applyMoves(moves);
        System.out.println(m);
        System.out.println(m.getVolume(E));

    }
}
