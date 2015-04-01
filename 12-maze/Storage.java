public interface Storage<E> {
    public void put(E data);
    public E take();
    public boolean empty();
}
