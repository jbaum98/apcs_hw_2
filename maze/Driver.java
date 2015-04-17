package maze;

import java.io.File;

public class Driver {
    public static void main(String[] args){
        if (args.length < 1) {
            throw new RuntimeException("Usage: java Driver <path to maze file>");
        }
        Maze m = new Maze(new File(args[0]));
        //System.out.println(m);
        //m.breadth(1,1);
        //System.out.println(m);
        //System.out.println("////////////////////////////////////////////////////////////");
        //delay(3000);
        //m.reset();
        //m.depth(1,1);
        m.best(0,0,true);
        //m.setCharAt(new Point(1, 1), 'J');
        //System.out.println(m);
        //System.out.println(m.exitPoint);
    }
}
