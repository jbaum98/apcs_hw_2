package maze;

public abstract class Geometry {
    public static int abs(int n) {
        if (n < 0) {
            return -n;
        } else {
            return n;
        }
    }

    public static int EuclideanDistance(int x1, int y1, int x2, int y2) {
        int dx = x1 - x2;
        int dy = y1 - y2;
        return dx*dx + dy*dy;
    }

    public static int ManhattanDistance(int x1, int y1, int x2, int y2) {
        int dx = abs(x1 - x2);
        int dy = abs(y1 - y2);
        return dx + dy;
    }

    public static void main(String[] args) {
        System.out.println("should be 25: " + EuclideanDistance(0,0,3,4));
        System.out.println("should be 7: " + ManhattanDistance(0,0,3,4));

        System.out.println("should be 25: " + EuclideanDistance(1,1,4,5));
        System.out.println("should be 7: " + ManhattanDistance(1,1,4,5));
    }
}
