public class Node<T> {
    private T data;
    private Node next;

    public Node(T data){
        this.data = data;
        next = null;
    }

    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }

    public void setData(T data){
        data = data;
    }

    public T getData() {
        return data;
    }

    public void setNext(Node n){
        next = n;
    }

    public Node getNext(){
        return next;
    }

    public String toString() {
        return data.toString();
    }
}
