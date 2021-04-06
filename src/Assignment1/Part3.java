package Assignment1;

import java.util.EmptyStackException;

public class Part3 {

    static abstract class MyStack<T> {
        private T[] stackArray;
        private T[] minStackArray;
        private int top = 0;

        MyStack() {
            stackArray = (T[]) new Object[8];
            minStackArray = (T[]) new Object[8];
        }

        private T[][] resize() {
            int len = stackArray.length;
            T [] newArray = (T[]) new Object[len * 2];
            T [] newMin = (T[]) new Object[len * 2];

            System.arraycopy(stackArray, 0, newArray, 0, len);
            System.arraycopy(minStackArray, 0, newMin, 0, len);

            return (T[][]) new Object[][] {
                    newArray, newMin
            };
        }

        abstract int compare(T t1, T t2);

        public void push(T x) {
            if (top == stackArray.length) {
                T[][] res = resize();
                stackArray = res[0];
                minStackArray = res[1];
            }
            stackArray[top] = x;
            if (top != 0) {
                int comparison = compare(x, minStackArray[top-1]);
                if (comparison < 0) {
                    minStackArray[top] = x;
                } else {
                    minStackArray[top] = minStackArray[top-1];
                }
            }
            else minStackArray[top] = x;
            top++;
        }

        public T pop() {
            if (top == 0) throw new EmptyStackException();
            return stackArray[--top];
        }

        public T top() {
            if (isEmpty()) throw new EmptyStackException();
            return stackArray[top-1];
        }

        public T min() {
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
        System.out.println("Testing stack of integers: ");
        MyStack<Integer> stack = new MyStack<>() {
            @Override
            int compare(Integer t1, Integer t2) {
                return t1 - t2;
            }
        };


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

        System.out.println("Testing stack of strings");
        MyStack<String> stack2 = new MyStack<String>() {
            @Override
            int compare(String t1, String t2) {
                return t1.length() - t2.length();
            }
        };

        stack2.push("abc");
        stack2.push("abcd");
        stack2.push("ab");
        System.out.println(stack2.min());
        stack2.pop();
        System.out.println(stack2.min());
    }

}
