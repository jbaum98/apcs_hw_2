package maze.storage;

import java.util.Random;
import maze.prioritizers.Prioritizer;

public class PriorityQ<E> extends AbstractQ<PriorityNode<E>, E> {
    private final Prioritizer<E> p;

    public PriorityQ(Prioritizer<E> prioritizer) {
        p = prioritizer;
    }

    public PriorityNode<E> newNode(E data) {
        return new PriorityNode<E>(data, p.priority(data));
    }

    @Override public void put(E data) {
        PriorityNode<E> newNode = newNode(data);
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
        Storage<Integer> weinerdog = new PriorityQ<Integer>(new IntegerPrioritizer());
        Random r = new Random();
        Integer n = r.nextInt(100);
        weinerdog.put(n);
        for(int i = 0; i < 5; i++) {
            System.out.println(weinerdog);
            weinerdog.put(r.nextInt(100));
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

class IntegerPrioritizer implements Prioritizer<Integer> {
    public int priority(Integer n) { return n; }
}
