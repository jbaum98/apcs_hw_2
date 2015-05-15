import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Heap<E extends Comparable<E>> {
    private final List<E> a = new ArrayList<E>();

    public Heap() {}

    public Heap(E[] items) {
        for (E item : items) {
            insert(item);
        }
    }

    public Heap(Iterable<E> items) {
        for (E item : items) {
            insert(item);
        }
    }

    public E findMin()  { return a.get(0); }

    public E removeMin() {
        E min = findMin();
        a.set(0, a.get(a.size() - 1));
        pushDown(0);
        return min;
    }

    public void insert(E el) {
        a.add(el);
        siftUp(a.size() - 1);
    }

    private void pushDown(int i) {
        while (!isLeaf(i)) {
            int l = leftChild(i);
            int r = rightChild(i);
            if (trySwap(i, l)) {
                i = l;
            } else if (trySwap(i, r)) {
                i = r;
            } else {
                return;
            }
        }
    }

    private void siftUp(int i) {
        while (!isRoot(i)) {
            int p = parent(i);
            if (trySwap(p, i)) {
                i = p;
            } else {
                return;
            }
        }
    }

    private boolean trySwap(int parentIndex, int childIndex) {
        if (!(parentIndex < a.size() && childIndex < a.size())) return false;
        E parent = a.get(parentIndex);
        E child  = a.get(childIndex);
        if (parent.compareTo(child) > 0) {
            a.set(parentIndex, child);
            a.set(childIndex, parent);
            return true;
        } else {
            return false;
        }
    }

    private static int leftChild (int i) { return 2*i + 1; }
    private static int rightChild(int i) { return 2*i + 2; }
    private static int parent    (int i) { return (i-1)/2; }

    private boolean isRoot(int i) { return i == 0; }
    private boolean isLeaf(int i) {
        return leftChild(i) < a.size();
    }

    public String toString() { return a.toString(); }

    public static void main(String[] args) {
        Heap<Integer> h = new Heap<Integer>();
        Random r = new Random(9);
        for (int i = 0; i < 10; i++) {
            Integer n = r.nextInt(100);
            System.out.print(" " + n);
            h.insert(n);
        }
        System.out.println();
        System.out.println(h);
    }
}
