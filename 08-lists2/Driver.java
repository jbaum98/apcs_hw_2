import java.util.Random;

public class  Driver{
    public static void main(String[] args) {
        Random r = new Random();
        LList<Integer> l = new LList<Integer>();
        for (int i=0; i < 10; i++){
            l.add(r.nextInt(50));
        }
        System.out.println(l);

        System.out.println("4: " + l.get(4));
        l.add(3, 7);
        System.out.println("inserted 7 at 3 ");
        System.out.println(l);
        l.remove(2);
        System.out.println("removed element at 2");
        System.out.println(l);

        l.remove(new Integer(7));
        System.out.println("removed the 7");
        System.out.println(l);
    }
}
