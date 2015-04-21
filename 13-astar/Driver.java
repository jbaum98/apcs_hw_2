import apcs_hw.maze.*;
import java.io.File;

public class Driver {
    public static void main(String[] args){
        int x = 20;
        int y = 4;
        if (args.length < 1) {
            throw new RuntimeException("Usage: java Driver <path to maze file>");
        }
        Maze m = new Maze(new File(args[0]));
        m.astar(x,y,true);
    }
}
