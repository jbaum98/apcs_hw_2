public class LList<T> {
    private Node<T> head = null;

    public void add(T data){
        head = new Node<T>(data, head);
    }

    public T find(int index) {
        return findNode(index).getData();
    }

    private Node<T> findNode(int index) {
        Node<T> n = head;
        for (int i = index; i > 0; i--) {
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
        } else if (index == 0) {
            add(data);
        } else {
            Node<T> prev = findNode(index-1);
            Node<T> toInsert = new Node<T>(data, prev.getNext());
            prev.setNext(toInsert);
        }
    }

    public String toString(){
        String s = "";
        for (Node<T> n = head; n != null; n = n.getNext()) {
            s += n + " --> ";
        }
        s = s + "null";
        return s;
    }
}
