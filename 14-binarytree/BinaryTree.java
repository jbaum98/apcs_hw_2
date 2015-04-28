import java.util.Random;

public class BinaryTree<E extends Comparable<E>> {
    private Node<E> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(E data) {
        root = new Node<E>(data);
    }

    public E search(E data) {
        Node<E> tmp = root;
        while (tmp != null) {
            int c = tmp.getData().compareTo(data);
            if (c > 0)
                tmp = tmp.getLeft();
            else if (c < 0)
                tmp = tmp.getRight();
            else
                return tmp.getData();
        }
        return null;
    }

    public void insert(E data) {
        if (root == null) {
            root = new Node<E>(data);
        } else {
            Node<E> newNode = new Node<E>(data);
            Node<E> n = root;
            Node<E> tmp = null;
            while (n != null) {
                tmp = n;
                boolean right = n.getData().compareTo(data) < 0;
                if (right)
                    n = n.getRight();
                else
                    n = n.getLeft();
            }
            boolean right = tmp.getData().compareTo(data) < 0;
            if (right)
                tmp.setRight(newNode);
            else
                tmp.setLeft(newNode);

        }
    }

    public String toString() {
        return root.toString();
    }

    public static void main(String[] args) {
        BinaryTree<Integer> b = new BinaryTree<Integer>();
        Random r = new Random();
        for (int i = 0; i < 15; i++) {
            b.insert(r.nextInt(50));
        }
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
