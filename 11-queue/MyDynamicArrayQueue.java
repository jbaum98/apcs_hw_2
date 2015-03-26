public class MyDynamicArrayQueue<E> implements MyQueue<E> {
    private int front;
    private int back;
    private int chunk;
    private Object[] a;

    public MyDynamicArrayQueue(int chunk) {
        this.chunk = chunk;
        front = chunk;
        back = chunk;
        a = new Object[chunk];
    }

    public MyDynamicArrayQueue() {
        this(100);
    }

    public void enqueue(E data) {
        if (front == 0) {
            Object[] newA = new Object[back - front + chunk];
            for (int i = front; i < back; i++) {
                newA[i - front + chunk]  = a[i];
            }
        }
        a[--front] = data;
    }

    public E dequeue() {
        return a(--back);
    }

    public boolean empty() {
        return size() == 0;
    }

    public E head() {
        return a(front);
    }

    public int size() {
        return back - front;
    }

    @SuppressWarnings("unchecked")
    private E a(int index) {
        return (E) a[index];
    }

    public String toString() {
        String out = "front | ";
        for (int i = front; i < back; i++) {
            out += a[i] + " ";
        }
        return out + "| back";
    }
}
