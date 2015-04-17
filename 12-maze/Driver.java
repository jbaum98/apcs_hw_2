package maze;

import java.io.File;

public class Driver {
    public static void main(String[] args){
        int x = 20;
        int y = 4;
        if (args.length < 1) {
            throw new RuntimeException("Usage: java Driver <path to maze file>");
        }
        Maze m = new Maze(new File(args[0]));
        System.out.println(m);

        System.out.println("Depth first search");
        Maze.delay(5000);
        m.depth(x,y,true);
        System.out.println(m);

        System.out.println("Breadth first search");
        m.reset();
        Maze.delay(5000);
        m.breadth(x,y,true);
        System.out.println(m);

        System.out.println("Best first search");
        m.reset();
        Maze.delay(5000);
        m.best(x,y,true);
        System.out.println(m);

        System.out.println("Astar search");
        m.reset();
        Maze.delay(5000);
        m.astar(x,y,true);
        System.out.println(m);
    }
}
