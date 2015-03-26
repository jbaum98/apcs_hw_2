import java.util.Random;

public class Driver {
    public static void main(String[] ars) {
        MyQueue<Integer> q = new MyDynamicArrayQueue<Integer>();
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            q.enqueue(r.nextInt(100));
        }
        System.out.println(q);
        System.out.println("head: "+q.head());
        System.out.println("end: "+q.dequeue());
        System.out.println(q);
    }
}
