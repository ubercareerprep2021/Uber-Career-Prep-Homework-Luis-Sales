package Assignment1;

import java.util.EmptyStackException;

public class Part3 {

    static class MyStack {
        private int[] stackArray = new int[8];
        private int[] minStackArray = new int[8];
        private int top = 0;

        private int[][] resize() {
            int len = stackArray.length;
            int [] newArray = new int[len * 2];
            int [] newMin = new int[len * 2];

            System.arraycopy(stackArray, 0, newArray, 0, len);
            System.arraycopy(minStackArray, 0, newMin, 0, len);

            return new int[][] {
                    newArray, newMin
            };
        }

        public void push(int x) {
            if (top == stackArray.length) {
                int[][] res = resize();
                stackArray = res[0];
                minStackArray = res[1];
            }
            stackArray[top] = x;
            if (top != 0) minStackArray[top] = Math.min(x, minStackArray[top-1]);
            else minStackArray[top] = x;
            top++;
        }

        public int pop() {
            if (top == 0) throw new EmptyStackException();
            return stackArray[--top];
        }

        public int top() {
            if (isEmpty()) throw new EmptyStackException();
            return stackArray[top-1];
        }

        public int min() {
            if (isEmpty()) throw new EmptyStackException();
            return minStackArray[top-1];
        }

        public int size() {
            return top;
        }

        public boolean isEmpty() {
            return top == 0;
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();


        System.out.println(stack.isEmpty());
        stack.push(42);
        System.out.println(stack.min());

        System.out.println(stack.isEmpty());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.min());
            System.out.println(stack.pop());
        }

        stack.push(5);
        stack.push(4);
        stack.push(6);

        System.out.println(stack.min());

        stack.push(3);
        System.out.println(stack.min());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.min());
    }

}
