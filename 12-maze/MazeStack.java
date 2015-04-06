public class MazeStack extends MazeQ {

    public MazeStack() {
        super();
        q = new Stack<Point>();
    }

    public static void main(String[] args){
        MazeStack m = new MazeStack();
        //System.out.println(m);
        m.solve(1,1);
        System.out.println(m);
    }
}
