package maze.prioritizers;

import maze.Point;

public class EuclideanPrioritizer implements Prioritizer<Point> {
    private final Point exit;

    public EuclideanPrioritizer(Point exit) {
        this.exit = exit;
    }

    public int priority(Point p) { return Geometry.EuclideanDistance(p.x, p.y, exit.x, exit.y); }
}
