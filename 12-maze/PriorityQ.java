import java.util.Random;

public class PriorityQ<E extends HasPriority> extends AbstractQ<PriorityNode<E>, E> {

    public PriorityNode<E> newNode(E data) {
        return new PriorityNode<E>(data, data.getPriority());
    }

    @Override public void put(E data) {
        PriorityNode<E> newNode = new PriorityNode<E>(data, data.getPriority());
        if (empty()) {
            head = newNode;
            tail = newNode;
        } else {
            PriorityNode<E> n = tail;
            PriorityNode<E> behind = null;;
            while ( n != null  && n.getPriority() < newNode.getPriority() ) {
                if (n.getData().equals(newNode.getData())) return; // ensure uniqueness
                behind = n;
                n = n.getNext();
            }
            // now n is the first node whose priority is higher than our new node
            // and behind is the node behind that
            PriorityNode<E> firstHigher = n;
            // keep going to ensure uniqueness
            while (n != null) {
                if (n.getData().equals(newNode.getData())) return; // ensure uniqueness
                n = n.getNext();
            }

            if (firstHigher == null) { // this is the highest
                head.setNext(newNode);
                head = newNode;
            } else if (behind == null) { // this is the lowest
                newNode.setNext(firstHigher);
                tail = newNode;
            } else {
                newNode.setNext(firstHigher);
                behind.setNext(newNode);
            }
        }
    }

    public static void main(String[] args) {
        PriorityQ<PInteger> weinerdog = new PriorityQ<PInteger>();
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
