public class Main2 {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        int popItem = stack.pop();
        System.out.println("popItem = " + popItem);

        int peekItem = stack.peek();
        System.out.println("peekItem = " + peekItem);
    }
}
