package apcs_hw.maze.prioritizers;

import apcs_hw.maze.Point;

public class EuclideanPrioritizer implements Prioritizer<Point> {
    private final Point exit;

    public EuclideanPrioritizer(Point exit) {
        this.exit = exit;
    }

    public int priority(Point p) { return Geometry.EuclideanDistance(p.x, p.y, exit.x, exit.y); }
}
