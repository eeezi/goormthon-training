public class MyStack<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();
    public void push(T item){
        list.add(item);
    }

    public T pop() {
        if (list.isEmpty()) {
            throw new IllegalStateException("empty stack!");
        }

        int lastIndex = list.size()-1;
        T top = list.get(lastIndex);
        list.delete(lastIndex);
        return top;
    }

    public T peek() {
        if (list.isEmpty()) {
            throw new IllegalStateException("empty stack!");
        }

        int lastIndex = list.size()-1;
        T top = list.get(lastIndex);
        return top;
    }
}
