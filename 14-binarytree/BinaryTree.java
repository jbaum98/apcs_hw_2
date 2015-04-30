import java.util.Random;

public class BinaryTree<E extends Comparable<E>> {
    private Node<E> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(E data) {
        root = new Node<E>(data);
    }

    private Nodes<E> findNode(E data, boolean leaf) {
        Nodes<E> ns = new Nodes<E>(root);
        while (ns.current != null) {
            int c = ns.current.getData().compareTo(data);
            if (c > 0)
                ns.cycleLeft();
            else if (c < 0)
                ns.cycleRight();
            else if (!leaf) {
                return ns;
            } else {
                ns.cycleRight();
            }
        }
        ns.current = null;
        return ns;
    }

    private Nodes<E> findNode(E data) {
        return findNode(data, false);
    }

    public E search(E data) {
        Node<E> n =  findNode(data).current;
        if (n == null) {
            return null;
        } else {
            return n.getData();
        }
    }

    public void insert(E data) {
        if (root == null) {
            root = new Node<E>(data);
        } else {
            Nodes<E> ns = findNode(data, true);
            Node<E> newNode = new Node<E>(data);
            if (ns.right)
                ns.parent.setRight(newNode);
            else
                ns.parent.setLeft(newNode);
        }
    }

    public E remove(E data) {
        Nodes<E> ns = findNode(data);
        Node<E> child;

        if (ns.current.getLeft() == null || ns.current.getRight() == null) {
            if (ns.current.getRight() == null) {
                child = ns.current.getLeft();
            } else {
                child = ns.current.getRight();
            }
        } else { // full node
            Node<E> l = ns.current.getLeft();
            while (l.getRight() != null) {
                l = l.getRight();
            }
            remove (l.getData());
            child = l;
        }

        if (ns.right) {
            ns.parent.setRight(child);
        } else {
            ns.parent.setLeft(child);
        }
        return ns.current.getData();
    }

    private static void swap(Node original, Node replacement) {
    }

    public String toString() {
        return ""+root;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> b = new BinaryTree<Integer>();
        Random r = new Random();
        int n = 0;
        for (int i = 0; i < 15; i++) {
            b.insert((n = r.nextInt(50)));
        }
        System.out.println(b);
        System.out.println("removing " + n);
        b.remove(n);
        System.out.println(b);
    }
}

class Node<E> {
    private final E data;
    private Node<E> left;
    private Node<E> right;

    public Node(E data) {
        this.data = data;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public Node<E> getLeft() {
        return left;
    }

    public E getData() {
        return data;
    }

    public boolean isLeaf() {
        return right == null && left == null;
    }

    public String toString() {
        String out = "(";
        out += catchNull(data);
        out += " left: ";
        out += catchNull(left);
        out += " right:";
        out += catchNull(right);
        out += ")";
        return out;
    }

    private String catchNull(Object o) {
        if (o == null) {
            return "null";
        } else {
            return o.toString();
        }
    }
}

class Nodes<E> {
    public Node<E> parent;
    public Node<E> current;
    public boolean right;

    public Nodes(Node<E> parent, Node<E> current, boolean right) {
        this.parent  = parent;
        this.current = current;
        this.right   = right;
    }

    public Nodes(Node<E> b) {
        this(null, b, false);
    }

    public void cycle(Node<E> n, boolean right) {
        parent = current;
        current = n;
        this.right = right;
    }

    public void cycleLeft() {
        cycle(current.getLeft(), false);
    }

    public void cycleRight() {
        cycle(current.getRight(), true);
    }

    public String toString() {
        return ""+parent;
    }
}
