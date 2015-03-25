public interface MyQueue<E> {
    public enqueue(E data);
    public E dequeue();
    public boolean empty();
    public E head();
    public int size();
}
