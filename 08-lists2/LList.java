public class LList<T> {
    private final Node<T> head = new Node<T>(null);

    public void add(T data){
        insert(0, data);
    }

    public T find(int index) {
        return findNode(index).getData();
    }

    private Node<T> findNode(int index) {
        Node<T> n = head;
        for (int i = index; i >= 0; i--) {
            if (n == null) {
                throw new IndexOutOfBoundsException(""+index+" is greater than the maximum index, "+i);
            }
            n = n.getNext();
        }
        return n;
    }

    public void insert(int index, T data) {
        if (index < 0) {
                throw new IndexOutOfBoundsException(""+index+" is less than 0");
        } else {
            Node<T> prev = findNode(index-1);
            Node<T> toInsert = new Node<T>(data, prev.getNext());
            prev.setNext(toInsert);
        }
    }

    public Node<T> remove(int index) {
        if (index < 0) {
                throw new IndexOutOfBoundsException(""+index+" is less than 0");
        } else {
            Node<T> prev = findNode(index-1);
            Node<T> target = prev.getNext();
            if (target == null) throw new IndexOutOfBoundsException(""+index+" is greater than the maximum index, "+index-1);
            Node<T> next = target.getNext();
            prev.setNext(next);
            return target
        }
    }

    public String toString(){
        String s = "";
        for (Node<T> n = head.getNext(); n != null; n = n.getNext()) {
            s += n + " --> ";
        }
        s = s + "null";
        return s;
    }
}
