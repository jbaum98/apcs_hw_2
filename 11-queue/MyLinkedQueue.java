public class MyLinkedQueue implements MyQueue {
    private Node<E> head;
    private Node<E> tail;

    public myQueue(){
	head = null;
	tail = null;
    }

    public void enqueue(E data){
	Node<E> node = new Node<E>(data);
	if (empty()) {
	    head = node
	    tail = head;
	} else {
	    head.setNext(node);
	    head = node;
	}
    }

    public E dequeue() {
	E out = tail.getData();
	tail = tail.getNext();
	return out;
    }

    public boolean empty() {
	return head == null;
    }

    public E head() {
	return head.getData();
    }

    public int size() {
	int size = 0;
	for(Node<E> n = tail; n != null; n = n.getNext()) {
	    size++;
	}
	return size;
    }
}

class Node<E> {
    private final E data;
    private Node<E> next;

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    public E getData() {
        return data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
