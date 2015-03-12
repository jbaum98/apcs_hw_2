public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data){
        this.data = data;
        next = null;
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public void setData(T data){
        data = data;
    }

    public T getData() {
        return data;
    }

    public void setNext(Node<T> n){
        next = n;
    }

    public Node<T> getNext(){
        return next;
    }

    public String toString() {
        return data.toString();
    }
}
