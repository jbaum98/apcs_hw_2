import java.util.Random;

public class Driver {
    public static void main(String[] args) {
        //MyStack<Integer> s = new MyStackLList<Integer>();
        MyStack<Integer> s = new MyStackArray<Integer>();
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            s.push(r.nextInt(100));
        }
        System.out.println(s);
        System.out.println("first guy: " + s.top());
        System.out.println("popped him: " + s.pop());
        System.out.println(s);

    }
}
