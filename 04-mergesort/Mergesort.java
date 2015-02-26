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

    public List<Integer> mergeSort(List<Integer> list) {
        if (list.size() == 0) {
            return list;
        } else {
            int divider = list.size() / 2;
            List<Integer> front = new ArrayList<Integer>();
            List<Integer> back = new ArrayList<Integer>();
            int i = 0;
            for (; i < divider; i++) {
                front.add(list.get(i));
            }
            for (; i < list.size(); i++) {
                back.add(list.get(i));
            }
            System.out.println(front);
            System.out.println(back);
            return merge(mergeSort(front), mergeSort(back));
        }
    }

    public static void main(String[] args) {

        Mergesort m = new Mergesort();

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

        List<Integer> c = new ArrayList<Integer>();
        c.add(0);
        c.add(90);
        c.add(-1);
        c.add(6);
        c.add(9);

        //System.out.println(m.merge(a,b));
        System.out.println(c);
        System.out.println(m.mergeSort(c));
    }

}
