public class Heap<E implements Comparable<E>> {
    private final List<E> a = new ArrayList<E>();

    public E findMin()  { return a.get(0); }

    public E removeMin() {
        E min = findMin();
        a.set(0, a.get(a.size()));
        pushDown(0);
    }

    public void insert(E el) {
        a.add(el);
        siftUp();
    }

    private void pushDown(int index) { pushOrSift(index, true);  }
    private void siftUp  (int index) { pushOrSift(index, false); }

    private void pushOrSift(int index, boolean down) {
        int i = index;
        while(i >= 0) {
            int l = leftChild(i);
            int r = rightChild(r);
            if (swap(i, l, down)) {
                i = l;
            } else if (swap(i, r, down)) {
                i = r;
            } else {
                break;
            }
        }
    }

    private boolean swap(int index, int childIndex, boolean down) {
        E el = a.get(index);
        if (childIndex < a.size()) {
            E child = a.get(childIndex);
            int c = child.compareTo(el)
            if ( (down && c > 0) || (up && c < 0)) {
                a.set(index, child);
                a.set(childIndex, el);
                return true;
            }
        }
        return false;
    }

    private int leftChild(int i)  { return 2*n + 1; }
    private int rightChild(int i) { return 2*n + 2; }

    public String toString() { return a.toString(); }
}
