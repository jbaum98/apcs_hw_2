public class MyFixedArrayQueue<E> implements MyQueue<E> {
    private int front;
    private int back;
    private Object[] a;

    public MyFixedArrayQueue(int maxSize) {
        a = new Object[maxSize];
        front = maxSize;
        back = maxSize;
    }

    public MyFixedArrayQueue() {
        this(100);
    }

    public void enqueue(E data) {
       if (full()) {
           throw new IllegalStateException();
       }
        a[--front] = data;
    }

    public E dequeue() {
        return a(--back);
    }

    public boolean empty() {
        return size() == 0;
    }

    public boolean full() {
        return size() == a.length;
    }

    public E head() {
        return a(front);
    }

    public int size() {
        return front - back;
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
