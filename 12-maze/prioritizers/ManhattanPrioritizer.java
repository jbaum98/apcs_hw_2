package apcs_hw.maze.prioritizers;

import apcs_hw.maze.Point;

public class ManhattanPrioritizer implements Prioritizer<Point> {
    private final Point exit;

    public ManhattanPrioritizer(Point exit) {
        this.exit = exit;
    }

    public int priority(Point p) { return Geometry.ManhattanDistance(p.x, p.y, exit.x, exit.y); }
}
