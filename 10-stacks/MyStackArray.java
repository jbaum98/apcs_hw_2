public class MyStackArray<E> implements MyStack<E> {
    private final int chunk;
    private Object[] a;
    private int size = 0;

    public MyStackArray(int chunk) {
        this.chunk = chunk;
        a = new Object[chunk];
    }

    public MyStackArray() {
        this(100);
    }

    public void push(E data) {
        if (size == a.length) {
            Object[] newA = new Object[a.length + chunk];
            for (int i = 0; i < a.length; i++) {
                newA[i] = a[i];
            }
            a = newA;
        }
        a[size] = data;
        size++;
    }

    public E pop() {
        return get(size-- - 1);
    }

    public boolean empty() {
        return size == 0;
    }

    public E top() {
        return get(size-1);
    }

    @SuppressWarnings("unchecked")
    private E get(int index) {
        return (E) a[index];
    }

    public String toString() {
        String out = new String();
        for(int i = size-1; i >= 0; i--) {
            out += a[i] + "----> ";
        }
        out += "null";
        return out;
    }
}
