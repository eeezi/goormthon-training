public class MyQueue<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void enqueue(T item) {
        list.add(item);
    }

    public T dequeue() {
        if (list.isEmpty()) {
            throw new IllegalStateException("empty queue");
        }
        T frontItem = list.get(0);
        list.delete(0);
        return frontItem;
    }

    public T peek() {
        if (list.isEmpty()) {
            throw new IllegalStateException("empty queue");
        }
        T frontItem = list.get(0);
        return frontItem;
    }
}
