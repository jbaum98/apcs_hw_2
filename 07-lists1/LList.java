public class LList<T> {
    private Node<T> head = null;

    public void add(T data){
        head = new Node(data, head);
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
