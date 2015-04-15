import java.util.Random;

public class PQ<E extends HasPriority> extends Q<E> implements Storage<E> {
    private PNode<E> head = null;
    private PNode<E> tail = null;

    public void put(E data) {
        PNode<E> newNode = new PNode<E>(data, data.getPriority());
        if (empty()) {
            setHead(newNode);
            setTail(newNode);
        } else {
            PNode<E> n = getTail();
            PNode<E> behind = null;;
            while ( n != null  && n.getPriority() > newNode.getPriority() ) {
                if (n.getData().equals(newNode.getData())) return; // ensure uniqueness
                behind = n;
                n = n.getNext();
            }
            // now n is the first node whose priority is less than our new node
            // and behind is the node behind that
            PNode<E> firstLess = n;
            // keep going to ensure uniqueness
            while (n != null) {
                if (n.getData().equals(newNode.getData())) return; // ensure uniqueness
                n = n.getNext();
            }

            if (firstLess == null) { // this is the lowest
                getHead().setNext(newNode);
                setHead(newNode);
            } else if (behind == null) { // this is the highest
                newNode.setNext(firstLess);
                setTail(newNode);
            } else {
                newNode.setNext(firstLess);
                behind.setNext(newNode);
            }
        }
    }

    @Override protected PNode<E> getHead() { return head; }
    @Override protected void setHead(Node<E> h) { head = (PNode) h; }
    @Override protected PNode<E> getTail() { return tail; }
    @Override protected void setTail(Node<E> t) { tail = (PNode) t; }

    public static void main(String[] args) {
        PQ<PInteger> weinerdog = new PQ<PInteger>();
        Random r = new Random();
        PInteger n = new PInteger(r.nextInt(100));
        weinerdog.put(n);
        for(int i = 0; i < 5; i++) {
            System.out.println(weinerdog);
            PInteger x = new PInteger(r.nextInt(100));
            weinerdog.put(x);
        }
        weinerdog.put(n);
        System.out.println(weinerdog);
        System.out.println(weinerdog.take());
        System.out.println(weinerdog);

        /*for(int i = 0; i < 100; i++) {
          weinerdog.put(r.nextInt(100));
        }
        System.out.println(weinerdog);
        for(int i = 0; i < 100; i++) {
        System.out.println(weinerdog.take());
        }*/
    }
}

class PInteger implements HasPriority {
    public final int n;

    public PInteger(int n) { this.n = n; }

    public int getPriority() { return n; }

    public String toString() { return ""+n; }

    public boolean equals(Object o) {
        if (o instanceof PInteger) {
            PInteger other = (PInteger) o;
            return this.n == other.n;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        PInteger a = new PInteger(5);
        PInteger b = new PInteger(5);
        System.out.println(a.equals(b));
    }
}
