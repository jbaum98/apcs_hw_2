package maze.prioritizers;

import maze.Point;

public class ManhattanPrioritizer implements Prioritizer<Point> {
    private final Point exit;

    public ManhattanPrioritizer(Point exit) {
        this.exit = exit;
    }

    public int priority(Point p) { return Geometry.ManhattanDistance(p.x, p.y, exit.x, exit.y); }
}
