import java.util.Random;

public class BinaryTree<E extends Comparable<E>> {
    private Node<E> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(E data) {
        root = new Node<E>(data);
    }

    private Node<E>[] findNode(E data) {
        Node<E>[] out = {null, root};
        while (n != null) {
            out[0] = out[1];
            int c = out[1].getData().compareTo(data);
            if (c > 0)
                out[1] = out[1].getLeft();
            else if (c < 0)
                out[1] = out[1].getRight();
            else {
                return out;
            }
        }
        out[1] = null;
        return out;
    }

    public E search(E data) { 
        Node<E> n =  findNode(data)[1];
        if (n == null) return null;
        else return n.getData();
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

    public E remove(Node<E> n) {
        E nodeData = n.getData();
        if (n.isLeaf()) {

        } else if (n.getRight() == null) {
        } else if (n.getLeft()  == null) {
        } else {
            Node<E> l = n.getLeft();
            while (l.getRight() != null) {
                l = l.getRight();
            }
            remove(l);
        }
    }

    private static void swap(Node original, Node replacement) {
       original 
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
