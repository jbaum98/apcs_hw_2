import java.util.ArrayList;
import java.util.List;

public class Mergesort {

    public List<Integer> merge(List<Integer> a, List<Integer> b) {
        if (a.size() < b.size()) {
            return merge(b, a); // ensures that a is always longer than b
        }

        List<Integer> out = new ArrayList<Integer>();

        while (b.size() > 0) {
            List<Integer> listWithLowest = a.get(0) < b.get(0) ? a : b;
            out.add(listWithLowest.remove(0));
        }

        // b is now empty, a has leftover
        while (a.size() > 0) {
            out.add(a.remove(0));
        }
        return out;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(5);
        a.add(6);
        a.add(10);

        List<Integer> b = new ArrayList<Integer>();
        b.add(-1);
        b.add(0);
        b.add(6);
        b.add(9);
        b.add(90);

        System.out.println((new Mergesort()).merge(a,b));
    }

}
