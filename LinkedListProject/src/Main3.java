public class Main3 {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        int item = queue.dequeue();
        System.out.println("item = " + item);

        int peekItem = queue.peek();
        System.out.println("peekItem = " + peekItem);

//        // 예외 확인
//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();
    }
}
