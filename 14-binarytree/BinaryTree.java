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
            Node<E> newNode = new Node(data);
            Node<E> n = root;
            boolean right = false;
            while (n != null) {
                right = n.getData().compareTo(data) < 0;
                if (right)
                    n = n.getRight();
                else
                    n = n.getLeft();
            }
            if (right)
                n.setRight(newNode);
            else
                n.setLeft(newNode);

        }
    }

    public String toString() {
        int[] info = toStringInfo(root);
        maxString = info[0];
        maxPath   = info[1];
        height = maxPath*2 - 1;
        width = Math.pow(2, maxPath - 1)*(maxString +1) - 1;
        String[] s = new char[height][width];
        

    }

    private static char[] populate(char[] chrs, int x, int y) {

    }

    /**
     * @return an array of two ints, where the first number
     * is the maximum length of toString and the second number
     * is the maximum path length.
     */
    private static int[] toStringInfo(Node n) {
        if (isLeaf()) {
            int[] out = new int[2];
            out[0] = n.getData().toString().length();
            out[1] = 0;
            return out;
        } else {
            int[] left  = toStringInfo(n.getLeft());
            int[] right = toStringInfo(n.getRight());
            int[] out;

            if (left[0] > right[0])
                out = left;
            else
                out = right;
            // now out has highest first element
            // so we need to fix the second
            
            if (left[1] > right[1])
                out[1] = left[1];
            else
                out[1] = right[1];

            return out;
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> b = new BinaryTree<Integer>();
        b.insert(20);
        b.insert(10);
        b.insert(15);
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

}
