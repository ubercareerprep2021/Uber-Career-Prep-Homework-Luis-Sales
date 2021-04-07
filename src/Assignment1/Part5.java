package Assignment1;

import java.util.Stack;

public class Part5 {

    static class MyNode {
        int val;
        MyNode next;

        MyNode(int val) {
            this.val = val;
        }

        void push(int val) {
            MyNode temp = this;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new MyNode(val);
        }

        @Override
        public String toString() {
            if (this.next == null) {
                return this.val + "";
            }
            return this.val + "->" + this.next.toString();
        }
    }

    static MyNode iterativeReverseLL (MyNode head) {
        if (head == null) return null;

        MyNode temp = head;
        MyNode prev = null;
        while (temp.next != null) {
            MyNode bkp = temp.next;
            temp.next = prev;
            prev = temp;
            temp = bkp;
        }
        temp.next = prev;
        return temp;
    }

    static MyNode stackReverseLL (MyNode head) {
        if (head == null) return null;

        Stack<MyNode> stack = new Stack<>();

        MyNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        MyNode returnNode = stack.pop();
        temp = returnNode;

        while (!stack.isEmpty()) {
            MyNode current = stack.pop();
            temp.next = current;
            current.next = null;
            temp = current;
        }

        return returnNode;
    }

    static MyNode recursiveReverseLL (MyNode head) {
        return recursiveReverseLLHelper(head, null);
    }

    static MyNode recursiveReverseLLHelper (MyNode current, MyNode prev) {
        if (current.next == null) {
            current.next = prev;
            return current;
        }
        MyNode bkp = current.next;
        current.next = prev;

        return recursiveReverseLLHelper(bkp, current);
    }

    public static void main(String[] args) {

    }

}
