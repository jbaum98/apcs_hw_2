public class Trees {
    public static <E extends Comparable<E>> E maxValue(Node<E> n) {
        if (n.isLeaf()) {
            return n.getData();
        } else {
            return max(n.getData(), maxValue(n.getRight()), maxValue(n.getLeft()));
        }
    }

    private static <E extends Comparable<E>> E max(E a, E b) {
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        } else if (a.compareTo(b) > 0) {
            return a;
        } else {
            return b;
        }
    }

    private static <E extends Comparable<E>> E max(E a, E b, E c) {
        return max(max(a,b), c);
    }

    public static int height(Node n) {
        if (n.isLeaf()) {
            return 0;
        } else {
            return 1 + Math.max(height(n.getLeft()), height(n.getRight()));
        }
    }

    public static <E extends Incrementable<E>> void splitDupes(Node<E> n) {
        if (n.getLeft() != null && n.getData().equals(n.getLeft().getData())) {
            Node<E> newNode = new Node<E>(n.getData().increment());
            newNode.setLeft(n.getLeft());
            n.setLeft(newNode);
        } 
    }

    public static int longest(Node n) {
         return height(n.getLeft()) + height(n.getRight());
    }
}

interface Incrementable<E> {
    E increment();
}
