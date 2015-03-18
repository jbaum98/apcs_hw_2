public class LList<E> {
    private final Node<E> head = new Node<E>(null);

    public E get(int index) {
        return findNode(index).getData();
    }

    private Node<E> findNode(int index) {
        Node<E> n = head;
        for (int i = index; i >= 0; i--) {
            if (n == null) {
                throw new IndexOutOfBoundsException(""+index+" is greater than the maximum index, "+i);
            }
            n = n.getNext();
        }
        return n;
    }

    public void add(E data){
        add(0, data);
    }

    public void add(int index, E data) {
        if (index < 0) {
                throw new IndexOutOfBoundsException(""+index+" is less than 0");
        } else {
            Node<E> prev = findNode(index-1);
            Node<E> toInsert = new Node<E>(data, prev.getNext());
            prev.setNext(toInsert);
        }
    }

    public Node<E> remove(int index) {
        if (index < 0) {
                throw new IndexOutOfBoundsException(""+index+" is less than 0");
        } else {
            Node<E> prev = findNode(index-1);
            Node<E> target = prev.getNext();
            if (target == null) throw new IndexOutOfBoundsException(""+index+" is greater than the maximum index, "+(index-1));
            Node<E> next = target.getNext();
            prev.setNext(next);
            return target;
        }
    }

    public String toString(){
        String s = "";
        for (Node<E> n = head.getNext(); n != null; n = n.getNext()) {
            s += n + " --> ";
        }
        s = s + "null";
        return s;
    }
}
